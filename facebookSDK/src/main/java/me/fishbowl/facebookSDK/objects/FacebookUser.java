package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class FacebookUser {

	private List<FacebookUserData> data;

	@Override
	public String toString() {
		return "FacebookUser [data=" + data + ", getData()=" + getData()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}

	public List<FacebookUserData> getData() {
		return data;
	}

	public void setData(List<FacebookUserData> data) {
		this.data = data;
	}

}
