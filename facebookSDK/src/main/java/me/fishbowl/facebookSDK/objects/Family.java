package me.fishbowl.facebookSDK.objects;

public class Family {

	private long uid;
	private String relationship;
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRelationship() {
		return relationship;
	}

	public void setRelationship(String relationship) {
		this.relationship = relationship;
	}

	public long getUid() {
		return uid;
	}

	public void setUid(long uid) {
		this.uid = uid;
	}

	@Override
	public String toString() {
		return "Family [relationship=" + relationship + ", name=" + name
				+ ", uid=" + uid + "]";
	}

}
