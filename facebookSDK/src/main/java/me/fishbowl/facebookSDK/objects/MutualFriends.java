package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class MutualFriends {

	@Override
	public String toString() {
		return "MutualFriends [data=" + data + ", paging=" + paging + "]";
	}

	List<MutualFriendsData> data;
	Paging paging;

	public MutualFriends getNextNotes() throws UtilHTTPException {
		String nextMutualFriendsLink;
		if (paging != null) {
			nextMutualFriendsLink = paging.getNext();

			if (nextMutualFriendsLink != null
					&& !nextMutualFriendsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextMutualFriendsLink,
						null, Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MutualFriendsType = new TypeToken<MutualFriends>() {
					}.getType();
					return (MutualFriends) gson.fromJson(json,
							MutualFriendsType);
				}
			}
		}

		return null;
	}

	public MutualFriends getPrevNotes() throws UtilHTTPException {
		String prevMutualFriendsLink;
		if (paging != null) {
			prevMutualFriendsLink = paging.getPrevious();

			if (prevMutualFriendsLink != null
					&& !prevMutualFriendsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevMutualFriendsLink,
						null, Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MutualFriendsType = new TypeToken<MutualFriends>() {
					}.getType();
					return (MutualFriends) gson.fromJson(json,
							MutualFriendsType);
				}
			}
		}

		return null;
	}

	public List<MutualFriendsData> getData() {
		return data;
	}

	public void setData(List<MutualFriendsData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
