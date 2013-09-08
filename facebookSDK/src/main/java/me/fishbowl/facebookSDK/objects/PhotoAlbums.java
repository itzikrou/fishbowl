package me.fishbowl.facebookSDK.objects;

import java.util.List;

public class PhotoAlbums {

	@Override
	public String toString() {
		final int maxLen = 10;
		return "PhotoAlbums [data="
				+ (data != null ? data
						.subList(0, Math.min(data.size(), maxLen)) : null)
				+ "]";
	}

	private List<PhotoAlbumData> data;

	public List<PhotoAlbumData> getData() {
		return data;
	}

	public void setData(List<PhotoAlbumData> data) {
		this.data = data;
	}

}
