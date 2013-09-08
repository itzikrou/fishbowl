package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Groups {

	@Override
	public String toString() {
		return "Groups [data=" + data + ", paging=" + paging + "]";
	}

	List<GroupsData> data;
	Paging paging;

	public Groups getNextGroups() throws UtilHTTPException {
		String nextGroupsLink;
		if (paging != null) {
			nextGroupsLink = paging.getNext();

			if (nextGroupsLink != null && !nextGroupsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextGroupsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type GroupsType = new TypeToken<Groups>() {
					}.getType();
					return (Groups) gson.fromJson(json, GroupsType);
				}
			}
		}

		return null;
	}

	public Groups getPrevGroups() throws UtilHTTPException {
		String prevGroupsLink;
		if (paging != null) {
			prevGroupsLink = paging.getNext();

			if (prevGroupsLink != null && !prevGroupsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevGroupsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type GroupsType = new TypeToken<Groups>() {
					}.getType();
					return (Groups) gson.fromJson(json, GroupsType);
				}
			}
		}

		return null;
	}

	public List<GroupsData> getData() {
		return data;
	}

	public void setData(List<GroupsData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
