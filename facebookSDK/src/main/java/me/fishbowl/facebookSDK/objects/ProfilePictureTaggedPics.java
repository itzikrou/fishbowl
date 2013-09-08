package me.fishbowl.facebookSDK.objects;

import java.lang.reflect.Type;
import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class ProfilePictureTaggedPics {

	@Override
	public String toString() {
		return "ProfilePictureTaggedPics [data=" + data + ", paging=" + paging
				+ "]";
	}

	private List<ProfilePictureTaggedPicData> data;

	private Paging paging;

	public ProfilePictureTaggedPics getNextProfilePictureTaggedPics()
			throws UtilHTTPException {

		String nextTaggedPicsLink;
		if (paging != null) {
			nextTaggedPicsLink = paging.getNext();

			if (nextTaggedPicsLink != null && !nextTaggedPicsLink.equals("")) {
				String response;
				response = HttpUtils.makeHttpRequest(nextTaggedPicsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type ProfilePictureTaggedPicType = new TypeToken<ProfilePictureTaggedPics>() {
					}.getType();
					return (ProfilePictureTaggedPics) gson.fromJson(json,
							ProfilePictureTaggedPicType);
				}
			}
		}

		return null;

	}

	public ProfilePictureTaggedPics getPrevProfilePictureTaggedPics()
			throws UtilHTTPException {

		String prevTaggedPicsLink;
		if (paging != null) {
			prevTaggedPicsLink = paging.getPrevious();

			if (prevTaggedPicsLink != null && !prevTaggedPicsLink.equals("")) {

				String response;
				response = HttpUtils.makeHttpRequest(prevTaggedPicsLink, null,
						Const.HttpMethod.GET);

				if (response != null) {
					String json = HTMLEntities.unhtmlentities(response);
					Gson gson = new Gson();
					Type ProfilePictureTaggedPicType = new TypeToken<ProfilePictureTaggedPics>() {
					}.getType();
					return (ProfilePictureTaggedPics) gson.fromJson(json,
							ProfilePictureTaggedPicType);
				}
			}
		}
		return null;

	}

	public List<ProfilePictureTaggedPicData> getData() {
		return data;
	}

	public void setData(List<ProfilePictureTaggedPicData> data) {
		this.data = data;
	}

	public Paging getPaging() {
		return paging;
	}

	public void setPaging(Paging paging) {
		this.paging = paging;
	}

}
