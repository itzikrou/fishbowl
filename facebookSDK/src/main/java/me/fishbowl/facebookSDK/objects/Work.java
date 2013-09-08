package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Work {
	@Override
	public String toString() {
		return "Work [employer=" + employer + ", location=" + location
				+ ", position=" + position + ", start_date=" + start_date
				+ ", end_date=" + end_date + ", with=" + with + "]";
	}

	private Employer employer;
	private Location location;
	private Position position;
	private String start_date;
	private String end_date;
	private List<With> with;

	public List<With> getWith() {
		return with;
	}

	public void setWith(List<With> with) {
		this.with = with;
	}

	public Employer getEmployer() {
		return employer;
	}

	public void setEmployer(Employer employer) {
		this.employer = employer;
	}

	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	public Position getPosition() {
		return position;
	}

	public void setPosition(Position position) {
		this.position = position;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

}
