package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Events {

	@Override
	public String toString() {
		return "Events [data=" + data + ", paging=" + paging + "]";
	}

	List<EventData> data;
	Paging paging;

	public Events getNextEvents() throws UtilHTTPException {
		String nextEventsLink;
		if (paging != null) {
			nextEventsLink = paging.getNext();

			if (nextEventsLink != null && !nextEventsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextEventsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type EventsType = new TypeToken<Events>() {
					}.getType();
					return (Events) gson.fromJson(json, EventsType);
				}
			}
		}

		return null;
	}

	public Events getPrevEvents() throws UtilHTTPException {
		String prevEventsLink;
		if (paging != null) {
			prevEventsLink = paging.getNext();

			if (prevEventsLink != null && !prevEventsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevEventsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type EventsType = new TypeToken<Events>() {
					}.getType();
					return (Events) gson.fromJson(json, EventsType);
				}
			}
		}

		return null;
	}

	public List<EventData> getData() {
		return data;
	}

	public void setData(List<EventData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
