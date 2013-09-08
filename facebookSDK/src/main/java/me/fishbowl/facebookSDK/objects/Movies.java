package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Movies {

	@Override
	public String toString() {
		return "Movies [data=" + data + ", paging=" + paging + "]";
	}

	List<MovieData> data;
	Paging paging;

	public Movies getNextMovies() throws UtilHTTPException {
		String nextMoviesLink;
		if (paging != null) {
			nextMoviesLink = paging.getNext();

			if (nextMoviesLink != null && !nextMoviesLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextMoviesLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MoviesType = new TypeToken<Movies>() {
					}.getType();
					return (Movies) gson.fromJson(json, MoviesType);
				}
			}
		}

		return null;
	}

	public Movies getPrevMovies() throws UtilHTTPException {
		String prevMoviesLink;
		if (paging != null) {
			prevMoviesLink = paging.getPrevious();

			if (prevMoviesLink != null && !prevMoviesLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(prevMoviesLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type MoviesType = new TypeToken<Movies>() {
					}.getType();
					return (Movies) gson.fromJson(json, MoviesType);
				}
			}
		}

		return null;
	}

	public List<MovieData> getData() {
		return data;
	}

	public void setData(List<MovieData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
