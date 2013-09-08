package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Friends {

	@Override
	public String toString() {
		return "Friends [data=" + data + ", paging=" + paging + "]";
	}

	List<FriendData> data;
	Paging paging;

	public Friends getNextFriends() throws UtilHTTPException {
		String nextFriendsLink;
		if (paging != null) {
			nextFriendsLink = paging.getNext();

			if (nextFriendsLink != null && !nextFriendsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextFriendsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type FriendsType = new TypeToken<Friends>() {
					}.getType();
					return (Friends) gson.fromJson(json, FriendsType);
				}
			}
		}

		return null;
	}

	public Friends getPrevFriends() throws UtilHTTPException {
		String prevFriendsLink;
		if (paging != null) {
			prevFriendsLink = paging.getPrevious();

			if (prevFriendsLink != null && !prevFriendsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevFriendsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type FriendsType = new TypeToken<Friends>() {
					}.getType();
					return (Friends) gson.fromJson(json, FriendsType);
				}
			}
		}

		return null;
	}

	public List<FriendData> getData() {
		return data;
	}

	public void setData(List<FriendData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
