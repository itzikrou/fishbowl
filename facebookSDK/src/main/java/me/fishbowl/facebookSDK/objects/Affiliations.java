package me.fishbowl.facebookSDK.objects;

public class Affiliations {
	private long nid;
	private String name;
	private String type;

	@Override
	public String toString() {
		return "Affiliations [nid=" + nid + ", name=" + name + ", type=" + type
				+ ", getNid()=" + getNid() + ", getName()=" + getName()
				+ ", getType()=" + getType() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public long getNid() {
		return nid;
	}

	public void setNid(long nid) {
		this.nid = nid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

}
