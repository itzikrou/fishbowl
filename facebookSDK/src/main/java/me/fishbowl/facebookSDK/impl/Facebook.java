package me.fishbowl.facebookSDK.impl;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.facebookSDK.FacebookSDKAPPAPI;
import me.fishbowl.facebookSDK.FacebookSDKUSERAPI;
import me.fishbowl.facebookSDK.objects.Books;
import me.fishbowl.facebookSDK.objects.Events;
import me.fishbowl.facebookSDK.objects.FacebookUser;
import me.fishbowl.facebookSDK.objects.FacebookUserData;
import me.fishbowl.facebookSDK.objects.Friends;
import me.fishbowl.facebookSDK.objects.FriendsPublicUserDetails;
import me.fishbowl.facebookSDK.objects.Groups;
import me.fishbowl.facebookSDK.objects.Likes;
import me.fishbowl.facebookSDK.objects.Movies;
import me.fishbowl.facebookSDK.objects.Music;
import me.fishbowl.facebookSDK.objects.MutualFriends;
import me.fishbowl.facebookSDK.objects.Notes;
import me.fishbowl.facebookSDK.objects.Permissions;
import me.fishbowl.facebookSDK.objects.PhotoAlbums;
import me.fishbowl.facebookSDK.objects.Photos;
import me.fishbowl.facebookSDK.objects.ProfilePicturePics;
import me.fishbowl.facebookSDK.objects.ProfilePictureTaggedPics;
import me.fishbowl.facebookSDK.objects.Request;
import me.fishbowl.util.Const;
import me.fishbowl.util.Const.ProfilePictureSize;
import me.fishbowl.util.HttpUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.tecnick.htmlutils.htmlentities.HTMLEntities;

public class Facebook implements FacebookSDKUSERAPI, FacebookSDKAPPAPI {

	// user API related members:
	private String facebookID;
	private String userAccessToken;
	private String expiresIn;
	private String signedRequest;

	// app API related members:
	private String appSecret;
	private String appID;
	private String appAccessToken;

	private static FacebookSDKUSERAPI facebookSDKUSER;
	private static FacebookSDKAPPAPI facebookSDKAPP;

	// Private contractors:

	// facebook user apis:
	private Facebook(String facebookID, String userAccessToken,
			String expiresIn, String signedRequest) {

		this.facebookID = facebookID;
		this.userAccessToken = userAccessToken;
		this.expiresIn = expiresIn;
		this.signedRequest = signedRequest;
	}

	// facebook app apis:
	private Facebook(String appID, String appSecret) {
		this.appID = appID;
		this.appSecret = appSecret;
	}

	// these functions return an facebookSDK instance:

	public static FacebookSDKAPPAPI getFacebookSDKAPP(String appID,
			String appSecret) {

		if (facebookSDKAPP == null) {
			facebookSDKAPP = new Facebook(appID, appSecret);
		}

		return facebookSDKAPP;
	}

	public static FacebookSDKUSERAPI getFacebookSDKUSER(String facebookID,
			String userAccessToken, String expiresIn, String signedRequest) {

		if (facebookSDKUSER == null) {
			facebookSDKUSER = new Facebook(facebookID, userAccessToken,
					expiresIn, signedRequest);
		}

		return facebookSDKUSER;
	}

	// FacebookSDK App API:

	private String generateAppAccessToken() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("client_id", appID);
		getVars.put("client_secret", appSecret);
		getVars.put("grant_type", "client_credentials");

		String response;

		response = HttpUtils.makeHttpRequest(
				"https://graph.facebook.com/oauth/access_token", getVars,
				Const.HttpMethod.GET);
		if (response != null) {
			String[] responseArr = response.split("=");
			return responseArr[1];
		}

		return null;
	}	

	public String getAppAccessToken() throws UtilHTTPException {
		appAccessToken = generateAppAccessToken();
		return appAccessToken;
	}

	public String getAppSecret() {
		return appSecret;
	}

	public String getAppID() {
		return appID;
	}

	// FacebookSDK User API:

	public String getUserFacebookID() {
		return facebookID;
	}

	public String getUserAccessToken() {
		return userAccessToken;
	}

	public String getUserTokenExpiresIn() {
		return expiresIn;
	}

	public String getUserTokenSignedRequest() {
		return signedRequest;
	}
	
	public String getPublicUserDetailsByEmail(String email)
			throws UtilHTTPException {

		String response;

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("q", email);
		getVars.put("type", "user");
		getVars.put("access_token", userAccessToken);

		// https://graph.facebook.com/search?q=mailbox@example.com&type=user

		response = HttpUtils.makeHttpRequest(
				"https://graph.facebook.com/search", getVars,
				Const.HttpMethod.GET);

		return response;
	}

	public FacebookUser getFacebookUserDetails() throws Exception {

		String query = "SELECT "
				+ "uid, username, first_name, middle_name, last_name, name, pic_small, pic_big, pic_square, pic, affiliations, "
				+ "profile_update_time, timezone, religion, birthday, birthday_date, devices, sex, hometown_location, "
				+ "relationship_status, significant_other_id, political, current_location, activities, interests, is_app_user, music, tv, movies, "
				+ "books, quotes, about_me, notes_count, wall_count, status, online_presence, locale, "
				+ "proxied_email, profile_url, pic_small_with_logo, pic_big_with_logo, pic_square_with_logo, pic_with_logo, pic_cover, "
				+ "allowed_restrictions, verified, profile_blurb, family, website, is_blocked, contact_email, email, third_party_id, name_format, "
				+ "games, work, education, sports, favorite_athletes, favorite_teams, inspirational_people, languages, likes_count,"
				+ "friend_count, mutual_friend_count, can_post "
				+ "FROM user WHERE uid in (~PARAMS~)";

		query = query.replace("~PARAMS~", facebookID);

		String response = makeFQLRequest(query);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type FacebookUserType = new TypeToken<FacebookUser>() {
			}.getType();

			FacebookUser facebookUser = null;

			facebookUser = (FacebookUser) gson.fromJson(json, FacebookUserType);

			return facebookUser;
		}

		return null;
	}

	public String getFacebookUserProfilePicture(String facebookId, int width,
			int hight) throws UtilHTTPException {

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("width", String.valueOf(width));
		getVars.put("hight", String.valueOf(hight));
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookId + "/picture", getVars, Const.HttpMethod.GET);
		return response;

	}

	public String getFacebookUserProfilePicture(int width, int hight)
			throws UtilHTTPException {

		return getFacebookUserProfilePicture(facebookID, width, hight);

	}

	public String getFacebookUserProfilePicture(Const.ProfilePictureSize size)
			throws UtilHTTPException {

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("type", size.toString());
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/picture", getVars, Const.HttpMethod.GET);
		return response;

	}

	public String getFacebookUserProfilePicture(String userID,
			ProfilePictureSize size) throws UtilHTTPException {
		if (userID == null || userID.equals("")) {
			return null;
		}

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("type", size.toString());
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ userID + "/picture", getVars, Const.HttpMethod.GET);
		return response;
	}

	public ProfilePictureTaggedPics getFacebookUserTaggedPics()
			throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/photos", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type ProfilePictureTaggedPicType = new TypeToken<ProfilePictureTaggedPics>() {
			}.getType();
			return (ProfilePictureTaggedPics) gson.fromJson(json,
					ProfilePictureTaggedPicType);
		}

		return null;

	}

	public ProfilePicturePics getFacebookUserProfilePics()
			throws UtilHTTPException {
		String query = "SELECT pid, src,src_height,src_width,images,link,created,modified FROM photo WHERE aid IN (SELECT aid FROM album WHERE owner = '~FACEBOOKID~' AND type = 'profile')";
		query = query.replace("~FACEBOOKID~", this.facebookID);
		String response = makeFQLRequest(query);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type ProfilePicturePicType = new TypeToken<ProfilePicturePics>() {
			}.getType();
			return (ProfilePicturePics) gson.fromJson(json,
					ProfilePicturePicType);
		}

		return null;

	}

	public PhotoAlbums getFacebookUserPhotoAlbums() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/albums", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type PhotoAlbumType = new TypeToken<PhotoAlbums>() {
			}.getType();
			return (PhotoAlbums) gson.fromJson(json, PhotoAlbumType);
		}

		return null;
	}

	public Photos getFacebookUserPhotoAlbumsPhotos(String AlbumID)
			throws UtilHTTPException {

		if (AlbumID == null || AlbumID.equals("")) {
			// no album id was sent.
			return null;
		}
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ AlbumID + "/photos", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type PhotosType = new TypeToken<Photos>() {
			}.getType();
			return (Photos) gson.fromJson(json, PhotosType);
		}

		return null;
	}

	public Friends getFacebookUserFriends() throws UtilHTTPException {

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/friends", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type FriendsType = new TypeToken<Friends>() {
			}.getType();
			return (Friends) gson.fromJson(json, FriendsType);
		}

		return null;
	}

	public Likes getFacebookUserLikes() throws UtilHTTPException {

		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/likes", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type LikesType = new TypeToken<Likes>() {
			}.getType();
			return (Likes) gson.fromJson(json, LikesType);
		}

		return null;
	}

	public Movies getFacebookUserMovies() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/movies", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type MoviesType = new TypeToken<Movies>() {
			}.getType();
			return (Movies) gson.fromJson(json, MoviesType);
		}

		return null;
	}

	public Music getFacebookUserMusic() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/music", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type MusicType = new TypeToken<Music>() {
			}.getType();
			return (Music) gson.fromJson(json, MusicType);
		}

		return null;
	}

	public Books getFacebookUserBooks() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/books", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type BooksType = new TypeToken<Books>() {
			}.getType();
			return (Books) gson.fromJson(json, BooksType);
		}

		return null;
	}

	public Notes getFacebookUserNotes() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/notes", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type NotesType = new TypeToken<Notes>() {
			}.getType();
			return (Notes) gson.fromJson(json, NotesType);
		}

		return null;
	}

	public Events getFacebookUserEvents() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/events", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type EventsType = new TypeToken<Events>() {
			}.getType();
			return (Events) gson.fromJson(json, EventsType);
		}

		return null;
	}

	public Groups getFacebookUserGroups() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/groups", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type GroupsType = new TypeToken<Groups>() {
			}.getType();
			return (Groups) gson.fromJson(json, GroupsType);
		}

		return null;
	}

	public Permissions getFacebookUserPermissions() throws UtilHTTPException {
		Map<String, String> getVars = new HashMap<String, String>();
		getVars.put("access_token", userAccessToken);
		String response;

		response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
				+ facebookID + "/permissions", getVars, Const.HttpMethod.GET);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type PermissionsType = new TypeToken<Permissions>() {
			}.getType();
			return (Permissions) gson.fromJson(json, PermissionsType);
		}

		return null;
	}

	public MutualFriends getFacebookUserMutualFriends(String userID)
			throws UtilHTTPException {

		if (userID != null && !userID.equals("")) {

			Map<String, String> getVars = new HashMap<String, String>();
			getVars.put("user", userID);
			getVars.put("access_token", userAccessToken);
			String response;

			response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
					+ facebookID + "/mutualfriends", getVars,
					Const.HttpMethod.GET);

			if (response != null) {
				String json = HTMLEntities.unhtmlentities(response);
				Gson gson = new Gson();
				Type MutualFriendsType = new TypeToken<MutualFriends>() {
				}.getType();
				return (MutualFriends) gson.fromJson(json, MutualFriendsType);
			}
		}

		return null;
	}

	public String makeFQLRequest(String fqlQuery) throws UtilHTTPException {

		if (fqlQuery != null && !fqlQuery.equals("")) {
			Map<String, String> getVars = new HashMap<String, String>();
			getVars.put("q", fqlQuery);
			getVars.put("access_token", userAccessToken);
			String response;

			response = HttpUtils.makeHttpRequest("https://graph.facebook.com/"
					+ "/fql", getVars, Const.HttpMethod.GET);

			return response;
		}
		return null;

	}

	public FacebookUserData getUserPublicDetails(String userID)
			throws UtilHTTPException {
		if (userID != null && !userID.equals("")) {
			List<String> input = new LinkedList<String>();
			input.add(userID);
			FriendsPublicUserDetails publicUserDetails = getFacebookUserFriendsDetails(input);
			if (publicUserDetails.getData() != null
					&& publicUserDetails.getData().size() > 0) {
				return publicUserDetails.getData().get(0);
			}
		}
		return null;
	}

	public FriendsPublicUserDetails getFacebookUserFriendsDetails(
			List<String> ids) throws UtilHTTPException {
		// String query =
		// "select uid, name, first_name, middle_name, last_name, sex, locale, pic_small, pic_big, pic_square, pic, username from user where uid in (~PARAMS~)";
		String query = "SELECT "
				+ "uid, username, first_name, middle_name, last_name, name, pic_small, pic_big, pic_square, pic, locale, birthday, birthday_date, sex, hometown_location, "
				+ "relationship_status, significant_other_id, current_location, education "
				+ "FROM user WHERE uid in (~PARAMS~)";

		StringBuffer params = new StringBuffer();

		for (int i = 0; i < ids.size() - 1; i++) {
			params.append(ids.get(i));
			params.append(",");
		}
		if (ids.size() > 0) {
			params.append(ids.get(ids.size() - 1));
		}

		query = query.replace("~PARAMS~", params.toString());

		String response = makeFQLRequest(query);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type FriendsPublicUserDetailsType = new TypeToken<FriendsPublicUserDetails>() {
			}.getType();

			FriendsPublicUserDetails friendsPublicUserDetails;

			friendsPublicUserDetails = (FriendsPublicUserDetails) gson
					.fromJson(json, FriendsPublicUserDetailsType);

			return friendsPublicUserDetails;
		}

		return null;
	}

	public Request getRequest(String request_id) throws UtilHTTPException {
		String query = "SELECT request_id, app_id, recipient_uid, sender_uid, message, data, created_time FROM apprequest WHERE request_id = ~PARAMS~";

		query = query.replace("~PARAMS~", request_id);

		String response = makeFQLRequest(query);

		if (response != null) {
			String json = HTMLEntities.unhtmlentities(response);
			Gson gson = new Gson();
			Type RequestType = new TypeToken<Request>() {
			}.getType();

			Request request;

			request = (Request) gson.fromJson(json, RequestType);

			return request;
		}

		return null;
	}

	public void deleteFacebookRequest(String requestObjID, String userID)
			throws UtilHTTPException {
		try {
			/*
			 * DELETE
			 * https://graph.facebook.com/[<REQUEST_OBJECT_ID>_<USER_ID>]?
			 * access_token=[USER or APP ACCESS TOKEN]
			 */

			URL url = new URL("https://graph.facebook.com/" + requestObjID
					+ "_" + userID + "?access_token=" + userAccessToken);
			HttpURLConnection connection = (HttpURLConnection) url
					.openConnection();
			connection.setRequestMethod("DELETE");
			int responseCode = connection.getResponseCode();
			if (responseCode != 200) {
				// there has been some kind of error
				Map<String, List<String>> headerResponse = connection
						.getHeaderFields();
				UtilHTTPException httpExeption = new UtilHTTPException(
						"Facebook returned an error code: " + responseCode
								+ "\n, the header response is : "
								+ headerResponse.toString());
				throw httpExeption;
			}

		} catch (MalformedURLException e) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"There was a problem with the URL, Check that it's valid.",
					e);
			throw httpExeption;

		} catch (ProtocolException e) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"There was a problem with the protocol, Check that it's valid.",
					e);
			throw httpExeption;

		} catch (IOException e) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"There was a problem with the server's streams", e);
			throw httpExeption;
		}

	}

}
