package me.fishbowl.facebookSDK;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.facebookSDK.impl.Facebook;
import me.fishbowl.facebookSDK.objects.Books;
import me.fishbowl.facebookSDK.objects.Events;
import me.fishbowl.facebookSDK.objects.FacebookUser;
import me.fishbowl.facebookSDK.objects.FacebookUserData;
import me.fishbowl.facebookSDK.objects.FriendData;
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
import me.fishbowl.util.Const;

import org.junit.BeforeClass;
import org.junit.Test;

public class TestFacebook {

	private static FacebookSDKAPPAPI facebookAppAPI;
	private static FacebookSDKUSERAPI facebookUserAPI;

	// the properties to load from the properties file:
	private static final String facebookID_prop = "facebookSDK.facebookID";
	private static final String userAccessToken_prop = "facebookSDK.userAccessToken";
	private static final String expiresIn_prop = "facebookSDK.expiresIn";
	private static final String signedRequest_prop = "facebookSDK.signedRequest";
	private static final String appId_prop = "facebookSDK.appId";
	private static final String appSecret_prop = "facebookSDK.appSecret";
	private static final String user1_prop = "facebookSDK.user1";
	private static final String user2_prop = "facebookSDK.user2";
	private static final String user3_prop = "facebookSDK.user3";
	private static final String albumID1_prop = "facebookSDK.albumID1";

	// test variables:
	// some facebook user ids to run tests on.. (usually your friends :) )
	private static String test_userID1;
	private static String test_userID2;
	private static String test_userID3;
	// some facebook picture album id, usually yours..
	private static String test_albumID;

	@BeforeClass
	public static void setUp() throws Exception {

		// the parameters in facebookSDK.properties (in particular
		// userAccessToken)
		// expire after a period of time. go to
		// https://developers.facebook.com/tools/explorer/?method=GET&path=facebookID
		// and generate a new access token to run the tests.
		// where facebookID is some facebook user-id number i.e. your user id.

		// this test class serves as a sanity check to make sure facebook did
		// not change its REST API
		// in which case the translation from json to classes will fail.

		// load the properties file:
		Properties prop = new Properties();

		InputStream in = TestFacebook.class
				.getResourceAsStream("/facebookSDK.properties");

		prop.load(in);

		facebookAppAPI = Facebook.getFacebookSDKAPP(
				prop.getProperty(appId_prop), prop.getProperty(appSecret_prop));

		facebookUserAPI = Facebook.getFacebookSDKUSER(
				prop.getProperty(facebookID_prop),
				prop.getProperty(userAccessToken_prop),
				prop.getProperty(expiresIn_prop),
				prop.getProperty(signedRequest_prop));

		test_userID1 = prop.getProperty(user1_prop);
		test_userID2 = prop.getProperty(user2_prop);
		test_userID3 = prop.getProperty(user3_prop);
		test_albumID = prop.getProperty(albumID1_prop);
	}

	@Test
	public void testFacebookSDK_APP_getAppAccessToken()
			throws UtilHTTPException {
		String appAccessToken = facebookAppAPI.getAppAccessToken();
		assertNotNull(appAccessToken);
	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserDetails() throws Exception {
		FacebookUser user;

		user = facebookUserAPI.getFacebookUserDetails();
		assertNotNull(user);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserProfilePicture()
			throws UtilHTTPException {
		String profilePicLink;

		profilePicLink = facebookUserAPI
				.getFacebookUserProfilePicture(Const.ProfilePictureSize.large);
		assertNotNull(profilePicLink);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserProfilePictureBySize()
			throws UtilHTTPException {
		String profilePicLink;

		profilePicLink = facebookUserAPI
				.getFacebookUserProfilePicture(200, 200);
		assertNotNull(profilePicLink);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserProfilePictureOtherUserID()
			throws UtilHTTPException {
		String profilePicLink;

		profilePicLink = facebookUserAPI.getFacebookUserProfilePicture(
				test_userID1, Const.ProfilePictureSize.large);
		assertNotNull(profilePicLink);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserTaggedPhotos()
			throws UtilHTTPException {
		ProfilePictureTaggedPics TaggedPic;

		// this test might change depending on the users tagged pics album..
		// your user-id might not have a next/prev tagged pics object.

		// the 1st group
		TaggedPic = facebookUserAPI.getFacebookUserTaggedPics();
		assertNotNull(TaggedPic);
		// the 2nd group
		TaggedPic = TaggedPic.getNextProfilePictureTaggedPics();
		assertNotNull(TaggedPic);
		// the 1st group
		TaggedPic = TaggedPic.getPrevProfilePictureTaggedPics();
		assertNotNull(TaggedPic);
		// return an empty data set :
		TaggedPic = TaggedPic.getPrevProfilePictureTaggedPics();
		assertNotNull(TaggedPic);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserPhotoAlbums()
			throws UtilHTTPException {
		PhotoAlbums album;

		// the 1st group
		album = facebookUserAPI.getFacebookUserPhotoAlbums();
		assertNotNull(album);
	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserPhotoAlbumsPhotos()
			throws UtilHTTPException {
		Photos photo;

		// the 1st group
		photo = facebookUserAPI.getFacebookUserPhotoAlbumsPhotos(test_albumID);
		assertNotNull(photo);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserFriends()
			throws UtilHTTPException {
		Friends friend;

		// this test might change depending on the users friends list..
		// your user-id might not have a next/prev object.

		// the 1st group
		friend = facebookUserAPI.getFacebookUserFriends();
		assertNotNull(friend);
		// the 2nd group: should be empty
		friend = friend.getNextFriends();
		assertTrue(friend.getData().isEmpty());
		// the 1st group
		friend = friend.getPrevFriends();
		assertNotNull(friend);
		// no previous results, should return as null
		friend = friend.getPrevFriends();
		assertNull(friend);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserLikes()
			throws UtilHTTPException {
		Likes like;

		// this test might change depending on the users likes list..
		// your user-id might not have a next/prev object.

		// the 1st group
		like = facebookUserAPI.getFacebookUserLikes();
		assertNotNull(like);
		// the 2nd group: should be empty
		like = like.getNextLikes();
		assertTrue(like.getData().isEmpty());
		// the 1st group
		like = like.getPrevLikes();
		assertNotNull(like);
		// no previous results, should return as null
		like = like.getPrevLikes();
		assertNull(like);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserMovies()
			throws UtilHTTPException {
		Movies movie;

		// this test might change depending on the users movies list..
		// your user-id might not have a next/prev object.

		// the 1st group
		movie = facebookUserAPI.getFacebookUserMovies();
		assertNotNull(movie);
		// the 2nd group: should be empty
		movie = movie.getNextMovies();
		assertTrue(movie.getData().isEmpty());
		// the 1st group
		movie = movie.getPrevMovies();
		assertNotNull(movie);
		// no previous results, should return as null
		movie = movie.getPrevMovies();
		assertNull(movie);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserMusic()
			throws UtilHTTPException {
		Music music;

		// this test might change depending on the users music list..
		// your user-id might not have a next/prev object.

		// the 1st group
		music = facebookUserAPI.getFacebookUserMusic();
		assertNotNull(music);
		// the 2nd group: should be empty
		music = music.getNextMusic();
		assertTrue(music.getData().isEmpty());
		// the 1st group
		music = music.getPrevMusic();
		assertNotNull(music);
		// no previous results, should return as null
		music = music.getPrevMusic();
		assertNull(music);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserBooks()
			throws UtilHTTPException {
		Books book;

		// this test might change depending on the users books list..
		// your user-id might not have a next/prev object.

		// the 1st group
		book = facebookUserAPI.getFacebookUserBooks();
		assertNotNull(book);
		// the 2nd group: should be empty
		book = book.getNextBooks();
		assertTrue(book.getData().isEmpty());
		// the 1st group
		book = book.getPrevBooks();
		assertNotNull(book);
		// no previous results, should return as null
		book = book.getPrevBooks();
		assertNull(book);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserNotes()
			throws UtilHTTPException {
		Notes note;

		// the 1st group
		note = facebookUserAPI.getFacebookUserNotes();
		assertNotNull(note);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserEvents()
			throws UtilHTTPException {
		Events event;

		// the 1st group
		event = facebookUserAPI.getFacebookUserEvents();
		assertNotNull(event);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserGroups()
			throws UtilHTTPException {
		Groups group;

		// the 1st group
		group = facebookUserAPI.getFacebookUserGroups();
		assertNotNull(group);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserPermissions()
			throws UtilHTTPException {
		Permissions permissions;

		// the 1st group
		permissions = facebookUserAPI.getFacebookUserPermissions();
		assertNotNull(permissions);

	}

	@Test
	public void testFacebookSDK_USER_getFacebookUserMutualFriends()
			throws UtilHTTPException {
		MutualFriends mutialFriends;

		// the 1st group
		mutialFriends = facebookUserAPI
				.getFacebookUserMutualFriends(test_userID2);
		assertNotNull(mutialFriends);

	}

	@Test
	public void testFacebookSDK_USER_makeFQLRequest() throws UtilHTTPException {
		String response;
		String fqlQuery = "SELECT name FROM user WHERE uid = me()";

		// the 1st group
		response = facebookUserAPI.makeFQLRequest(fqlQuery);
		assertNotNull(response);

	}

	@Test
	public void testFacebookSDK_USER_getUserPublicDetails()
			throws UtilHTTPException {
		FacebookUserData publicUserDetails;

		// the 1st group
		publicUserDetails = facebookUserAPI.getUserPublicDetails(test_userID3);
		assertNotNull(publicUserDetails);

	}

	@Test
	public void testGetFacebookUserFriendsDetails() throws UtilHTTPException {

		List<String> ids = new ArrayList<String>();

		Friends friends = facebookUserAPI.getFacebookUserFriends();
		do {
			List<FriendData> friendList = friends.getData();
			if (friendList != null && friendList.size() > 0) {
				for (FriendData friendData : friendList) {

					ids.add(friendData.getId());

				}

			}

		} while ((friends = friends.getNextFriends()) != null);
		FriendsPublicUserDetails friendsDetails = facebookUserAPI
				.getFacebookUserFriendsDetails(ids);
		assertNotNull(friendsDetails);

	}

	@Test
	public void testGetFacebookUserProfilePics() throws UtilHTTPException {
		ProfilePicturePics response;

		response = facebookUserAPI.getFacebookUserProfilePics();
		assertNotNull(response);

	}

}
