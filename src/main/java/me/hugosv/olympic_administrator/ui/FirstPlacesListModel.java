package me.hugosv.olympic_administrator.ui;

import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractListModel;
import me.hugosv.olympic_administrator.vo.Participant;

/**
 *
 * @author Hugo Sanchez
 */
public class FirstPlacesListModel extends AbstractListModel<String>{

	private static final long serialVersionUID = -8220251984277316815L;

	private Map<String, Participant> best;

	public FirstPlacesListModel() {
		this.best = new HashMap<>();
	}
	
	@Override
	public int getSize() {
		return best.size();
	}

	@Override
	public String getElementAt(int index) {
		int idx = 0;
		for (Map.Entry<String, Participant> entry : best.entrySet()) {
			if(index == idx) {
				return entry.getKey() + " : [" + entry.getValue().getUniversity() + "] " + entry.getValue().getName();
			}
			idx++;
		}
		return "MIAU";
	}

	public void setBest(Map<String, Participant> best) {
		this.best.clear();
		this.best = best;
		this.fireIntervalAdded(best, getSize(), getSize() + 1);
	}

}
