package me.fishbowl.facebookSDK.objects;

public class Sports {

	private String name;
	private long id;

	@Override
	public String toString() {
		return "Sports [name=" + name + ", id=" + id + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
