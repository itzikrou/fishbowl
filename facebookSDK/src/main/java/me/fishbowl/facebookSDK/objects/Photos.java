package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class Photos {

	@Override
	public String toString() {
		return "Photos [data=" + data + "]";
	}

	private List<PhotoData> data;

	public List<PhotoData> getData() {
		return data;
	}

	public void setData(List<PhotoData> data) {
		this.data = data;
	}

}
