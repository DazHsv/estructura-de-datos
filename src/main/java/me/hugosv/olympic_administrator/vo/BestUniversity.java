package me.hugosv.olympic_administrator.vo;

/**
 * An object to hold information about the best university.
 *
 * @author Hugo Sanchez
 */
public class BestUniversity {

	private final String name;
	private final Integer wins;

	public BestUniversity(String name, Integer wins) {
		this.name = name;
		this.wins = wins;
	}

	public String getName() {
		return name;
	}

	public Integer getWins() {
		return wins;
	}

	@Override
	public String toString() {
		return String.format("Best university: %s, with %d wins.",
			name, wins);
	}

}
