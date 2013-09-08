package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Likes {
	@Override
	public String toString() {
		return "Likes [data=" + data + ", paging=" + paging + "]";
	}

	private List<LikeData> data;
	private Paging paging;

	public Likes getNextLikes() throws UtilHTTPException {
		String nextLikesLink;
		if (paging != null) {
			nextLikesLink = paging.getNext();

			if (nextLikesLink != null && !nextLikesLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextLikesLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type LikesType = new TypeToken<Likes>() {
					}.getType();
					return (Likes) gson.fromJson(json, LikesType);
				}
			}
		}

		return null;
	}

	public Likes getPrevLikes() throws UtilHTTPException {
		String nextPrevLink;
		if (paging != null) {
			nextPrevLink = paging.getPrevious();

			if (nextPrevLink != null && !nextPrevLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextPrevLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type LikesType = new TypeToken<Likes>() {
					}.getType();
					return (Likes) gson.fromJson(json, LikesType);
				}
			}
		}

		return null;
	}

	public List<LikeData> getData() {
		return data;
	}

	public void setData(List<LikeData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
