package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Education {
	@Override
	public String toString() {
		return "Education [school=" + school + ", year=" + year + ", type="
				+ type + ", classes=" + classes + ", concentration="
				+ concentration + ", with=" + with + ", degree=" + degree + "]";
	}

	private School school;
	private Year year;
	private String type;
	private List<Classes> classes;
	private List<Concentration> concentration;
	private List<With> with;
	private Degree degree;

	public List<Concentration> getConcentration() {
		return concentration;
	}

	public void setConcentration(List<Concentration> concentration) {
		this.concentration = concentration;
	}

	public List<With> getWith() {
		return with;
	}

	public void setWith(List<With> with) {
		this.with = with;
	}

	public Degree getDegree() {
		return degree;
	}

	public void setDegree(Degree degree) {
		this.degree = degree;
	}

	public List<Classes> getClasses() {
		return classes;
	}

	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Year getYear() {
		return year;
	}

	public void setYear(Year year) {
		this.year = year;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

}
