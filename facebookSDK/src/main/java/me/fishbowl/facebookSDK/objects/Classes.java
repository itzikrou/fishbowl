package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Classes {
	private long id;
	private String name;
	private String description;
	private List<With> with;
	private From from;

	public List<With> getWith() {
		return with;
	}

	public void setWith(List<With> with) {
		this.with = with;
	}

	public From getFrom() {
		return from;
	}

	public void setFrom(From from) {
		this.from = from;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", description="
				+ description + "]";
	}

}
