package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Music {

	@Override
	public String toString() {
		return "Music [data=" + data + ", paging=" + paging + "]";
	}

	List<MusicData> data;
	Paging paging;

	public Music getNextMusic() throws UtilHTTPException {
		String nextMusicLink;
		if (paging != null) {
			nextMusicLink = paging.getNext();

			if (nextMusicLink != null && !nextMusicLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextMusicLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MusicType = new TypeToken<Music>() {
					}.getType();
					return (Music) gson.fromJson(json, MusicType);
				}
			}
		}

		return null;
	}

	public Music getPrevMusic() throws UtilHTTPException {
		String prevMusicLink;
		if (paging != null) {
			prevMusicLink = paging.getPrevious();

			if (prevMusicLink != null && !prevMusicLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevMusicLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MusicType = new TypeToken<Music>() {
					}.getType();
					return (Music) gson.fromJson(json, MusicType);
				}
			}
		}

		return null;
	}

	public List<MusicData> getData() {
		return data;
	}

	public void setData(List<MusicData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
