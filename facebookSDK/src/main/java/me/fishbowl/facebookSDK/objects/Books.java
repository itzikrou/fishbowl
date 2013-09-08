package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Books {

	List<BooksData> data;
	Paging paging;

	public Books getNextBooks() throws UtilHTTPException {
		String nextBooksLink;
		if (paging != null) {
			nextBooksLink = paging.getNext();

			if (nextBooksLink != null && !nextBooksLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextBooksLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type BooksType = new TypeToken<Books>() {
					}.getType();
					return (Books) gson.fromJson(json, BooksType);
				}
			}
		}

		return null;
	}

	public Books getPrevBooks() throws UtilHTTPException {
		String prevBooksLink;
		if (paging != null) {
			prevBooksLink = paging.getPrevious();

			if (prevBooksLink != null && !prevBooksLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevBooksLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type BooksType = new TypeToken<Books>() {
					}.getType();
					return (Books) gson.fromJson(json, BooksType);
				}
			}
		}

		return null;
	}

	public List<BooksData> getData() {
		return data;
	}

	public void setData(List<BooksData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

	@Override
	public String toString() {
		return "Books [data=" + data + ", paging=" + paging + "]";
	}

}
