package me.hugosv.olympic_administrator.ui;

import java.util.ArrayList;
import java.util.List;
import javax.swing.AbstractListModel;
import me.hugosv.olympic_administrator.vo.Participant;

/**
 *
 * @author Hugo Sanchez
 */
public class ParticipantListModel extends AbstractListModel<String> {

	private static final long serialVersionUID = -1663254045860909311L;

	private List<Participant> participants;

	public ParticipantListModel() {
		this.participants = new ArrayList<Participant>();
	}	
	
	@Override
	public int getSize() {
		return this.participants.size();
	}

	@Override
	public String getElementAt(int index) {
		return this.participants.get(index).getName();
	}
	
	public void addParticipant(Participant p) {
		this.participants.add(p);
		this.fireIntervalAdded(this, getSize(), getSize()+1);
	}
	
	public Participant getParticipant(int index) {
		return this.participants.get(index);
	}
	
	public void setParticipants(List<Participant> participants) {
		this.participants.clear();
		this.participants = participants;
		this.fireIntervalAdded(this, getSize(), getSize() + 1);
	}
}
