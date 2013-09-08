package me.fishbowl.facebookSDK.objects;

public class Inspirational_people {
	private long id;
	private String name;

	@Override
	public String toString() {
		return "Inspirational_people [id=" + id + ", name=" + name + "]";
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

}
