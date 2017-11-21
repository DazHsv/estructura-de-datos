package me.hugosv.olympic_administrator.services;

/*
 * IMPORTANT
 * This code uses JDK 1.8 for:
 * - Lambda expressions
 * - Infered types with Diamont operator.
 */
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import me.hugosv.olympic_administrator.filters.Filter;
import me.hugosv.olympic_administrator.vo.BestUniversity;
import me.hugosv.olympic_administrator.vo.Holder;
import me.hugosv.olympic_administrator.vo.Participant;
import org.apache.log4j.Logger;

/**
 * A service to handle data queries over a {@link Participant} data store.
 *
 * @author Hugo Sanchez
 * @version 1.0.0
 * @since OlympicAdministrator 1.0.0
 */
public class OlympicControlService {

	private Logger logger = Logger.getLogger(OlympicControlService.class);

	/**
	 * Instantiates a new {@link OlympicControlService}.
	 */
	public OlympicControlService() {
		this.participants = new ArrayList<>();
		this.universities = new HashSet<>();
		this.swimStyles = new HashSet<>();
	}

	/**
	 * Gets all the participants.
	 *
	 * @return A {@link List} with all the participants.
	 */
	public List<Participant> getParticipants() {
		return participants;
	}

	/**
	 * Filter the participants of a given univesity.
	 *
	 * @param u The university of the participants to be searched for.
	 * @return A {@link List} with the participants that belongs to the given
	 * university.
	 */
	public List<Participant> participantsByUniversity(String u) {
		logger.info("Search by university: " + u);
		return this.findAllFilterBy(this.participants, (Participant current) -> {
			return current.getUniversity().equalsIgnoreCase(u);
		});
	}

	/**
	 * Filter the participants of a given swimming style.
	 *
	 * @param ss The swimming style of the participants to be searched for.
	 * @return A {@link List} with the participants that make to the given swim
	 * style.
	 */
	public List<Participant> participantsBySwimStyle(String ss) {
		return this.findAllFilterBy(this.participants, (Participant current) -> {
			return current.getSwimStyle().equalsIgnoreCase(ss);
		});
	}

	/**
	 * Gets a participant by its name.
	 *
	 * @param name A {@link String} with the name of the participant.
	 * @return A {@link List} with the {@link Participant}s that match the given
	 * name.
	 */
	public List<Participant> getParticipantByName(String name) {
		return this.findAllFilterBy(this.participants, (Participant current) -> {
			return current.getName().equalsIgnoreCase(name);
		});
	}

	/**
	 * Gets the best university by its times on all swim styles.
	 *
	 * @return A {@link BestUniversity} with the name of the best university and
	 * the times by swimming style.
	 */
	public BestUniversity bestUniversityByTime() {
		logger.info("Starting method: bestUniversityByTime");

		Map<String, Participant> bp = this.bestParticipantsBySwimStyle();
		Map<String, Integer> univs = new HashMap<>();

		bp.entrySet().forEach((e) -> {
			String u = e.getValue().getUniversity();
			univs.put(u, (univs.containsKey(u) ? univs.get(u) + 1 : 1));
		});

		final Holder<String> best = new Holder<>();
		final Holder<Integer> count = new Holder<>(0);
		univs.entrySet().forEach((e) -> {
			if (e.getValue() > count.getValue()) {
				best.setValue(e.getKey());
				count.setValue(e.getValue());
			}
		});
		return new BestUniversity(best.getValue(), count.getValue());
	}

	/**
	 * Gets the first place participants on each swim style.
	 *
	 * @return A {@link Map} of the first place participants, where each
	 * {@link Map.Entry} key and value are Swimming style an the first place
	 * participant.
	 */
	public Map<String, Participant> bestParticipantsBySwimStyle() {
		List<Participant> candidates = new ArrayList<>(participants);
		Map<String, Participant> best = new HashMap<>();
		candidates.sort(Comparator.comparingInt(Participant::getSwimTime));
		swimStyles.forEach((String ss) -> {
			Participant p = this.findFirstFilterBy(candidates, (current) -> {
				return current.getSwimStyle().equalsIgnoreCase(ss);
			});
			best.put(ss, p);
		});
		return best;
	}

	/**
	 * Adds a participant.
	 * <p>
	 * It also:<br>
	 * 1. Adds the participant's university to the universities list if isn't
	 * on.<br>
	 * 2. Adds the participant's swimmig style to the swimming styles list if it
	 * isn't on.
	 * </p>
	 *
	 * @param p The {@link Participant} to be added.
	 * @return {@code true} if the participant wasn't already in the list,
	 * {@code false} otherwise.
	 */
	public boolean addParticipant(Participant p) {
		logger.info("Adding participant");
		if (logger.isTraceEnabled()) {
			logger.trace(p);
		}
		this.universities.add(p.getUniversity());
		this.swimStyles.add(p.getSwimStyle());
		return this.participants.add(p);
	}

	/**
	 * A list of unique participants.
	 */
	private final List<Participant> participants;
	/**
	 * A list of unique universities.
	 */
	private final Set<String> universities;
	/**
	 * A list of unique swimming styles.
	 */
	private final Set<String> swimStyles;

	/**
	 * Return the objects that passes the filter.
	 *
	 * @param filter A {@link Filter} that evaluates each object.
	 * @return A {@link List} of the objects that passed the filter.
	 */
	private <T> List<T> findAllFilterBy(
		Collection<T> collection,
		Filter<T> filter) {

		List<T> matched = new ArrayList<>();
		collection.forEach((t) -> {
			if (filter.accept(t)) {
				matched.add(t);
			}
		});
		return matched;
	}

	/**
	 * Return the first object that passes the filter.
	 *
	 * @param filter A {@link Filter} that evaluates each object.
	 * @return T first object that passed the filter.
	 */
	private <T> T findFirstFilterBy(
		Collection<T> collection,
		Filter<T> filter) {
		for (T t : collection) {
			if (filter.accept(t)) {
				return t;
			}
		}
		return null;
	}

}
