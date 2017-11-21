package me.hugosv.olympic_administrator.vo;

/**
 * An object representing a Olympic Participant.
 *
 * @author Hugo Sanchez
 */
public class Participant {

	private String name;
	private String university;
	private String swimStyle;
	private Integer swimTime;

	public Participant() {
	}

	public Participant(String name, String university, String swimStyle, Integer swimTime) {
		this.name = name;
		this.university = university;
		this.swimStyle = swimStyle;
		this.swimTime = swimTime;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getUniversity() {
		return university;
	}

	public void setUniversity(String university) {
		this.university = university;
	}

	public String getSwimStyle() {
		return swimStyle;
	}

	public void setSwimStyle(String swimStyle) {
		this.swimStyle = swimStyle;
	}

	public Integer getSwimTime() {
		return swimTime;
	}

	public void setSwimTime(Integer swimTime) {
		this.swimTime = swimTime;
	}

	@Override
	public String toString() {
		return String.format(
			"Participant: %s%nUniversity: %s%nSwim style: %s%nSwim Time: %d%n",
			name, university, swimStyle, swimTime);
	}

}
