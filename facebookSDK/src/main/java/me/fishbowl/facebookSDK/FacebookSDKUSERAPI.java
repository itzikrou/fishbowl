package me.fishbowl.facebookSDK;

import java.util.List;

import me.fishbowl.exceptions.UtilHTTPException;
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

/**
 * Java Implementation of Facebook's API (User API). Based on a simple Http Get
 * request to the Graph API, the parsing of the returned data, and the
 * conversion of the returned data into a Java Class.
 * 
 * @author Isaac Rousso
 * @version 1.0
 * @see https://developers.facebook.com/docs/reference/api/
 * 
 */
public interface FacebookSDKUSERAPI
{

	/**
	 * @param fqlQuery
	 * @return makes a general FQL query. (i.e: SELECT name FROM user WHERE uid
	 *         = me())</br> <b>Note: the response is a string containing the
	 *         response as it was received from facebook.</br> No parsing or
	 *         error checks were made.</b>
	 * @see https://developers.facebook.com/docs/reference/fql/
	 * @throws UtilHTTPException
	 */
	public String makeFQLRequest(String fqlQuery) throws UtilHTTPException;

	/**
	 * @param ids
	 * @return FriendsPublicUserDetails
	 * @throws UtilHTTPException
	 */
	public FriendsPublicUserDetails getFacebookUserFriendsDetails(List<String> ids) throws UtilHTTPException;

	/**
	 * @param userID
	 * @return the public information of the user with the UserID
	 * @throws UtilHTTPException
	 */
	public FacebookUserData getUserPublicDetails(String userID) throws UtilHTTPException;

	/**
	 * @return the User's Facebook ID (as entered to the getFacebookSDKUSER
	 *         function)
	 */
	public String getUserFacebookID();

	/**
	 * @return the User's access token (as entered to the getFacebookSDKUSER
	 *         function)
	 */
	public String getUserAccessToken();

	/**
	 * @return The expiration time of the User's access token (as entered to the
	 *         getFacebookSDKUSER function)
	 */
	public String getUserTokenExpiresIn();

	/**
	 * @return the User's signed request (as entered to the getFacebookSDKUSER
	 *         function)
	 */
	public String getUserTokenSignedRequest();

	/**
	 * @return FacebookUser Object that contains details about the user
	 * @see https://developers.facebook.com/docs/reference/api/user/
	 * @throws UtilHTTPException
	 */
	public FacebookUser getFacebookUserDetails() throws Exception;

	/**
	 * @param facebookId
	 * 
	 * @param width
	 *            - in px.
	 * @param hight
	 *            - in px.
	 * 
	 * @return a link to the user's profile picture of the given size.
	 * @throws UtilHTTPException
	 */
	public String getFacebookUserProfilePicture(String facebookId, int width, int hight) throws UtilHTTPException;

	/**
	 * @param width
	 *            - in px.
	 * @param hight
	 *            - in px.
	 * 
	 * @return a link to the user's profile picture of the given size.
	 * @throws UtilHTTPException
	 */
	public String getFacebookUserProfilePicture(int width, int hight) throws UtilHTTPException;

	/**
	 * @param size
	 *            : enum value.</br> one of the following:<br/>
	 *            thumbnail, small, normal, large, square.
	 * @return a link to the user's profile picture of the given size.
	 * @throws UtilHTTPException
	 */
	public String getFacebookUserProfilePicture(Const.ProfilePictureSize size) throws UtilHTTPException;

	/**
	 * @param userID
	 * @param size
	 *            : enum value.</br> one of the following:<br/>
	 *            thumbnail, small, normal, large, square.
	 * @return
	 * @throws UtilHTTPException
	 */
	public String getFacebookUserProfilePicture(String userID, Const.ProfilePictureSize size) throws UtilHTTPException;

	/**
	 * @return Pictures which the user is tagged in
	 * @throws UtilHTTPException
	 */
	public ProfilePictureTaggedPics getFacebookUserTaggedPics() throws UtilHTTPException;

	/**
	 * @return The user's Photo Albums (only album details, these objects do not
	 *         include the actual photos)
	 * @throws UtilHTTPException
	 */
	public PhotoAlbums getFacebookUserPhotoAlbums() throws UtilHTTPException;

	/**
	 * @param AlbumID
	 * @return The photos of a specific photo-album.
	 * @throws UtilHTTPException
	 */
	public Photos getFacebookUserPhotoAlbumsPhotos(String AlbumID) throws UtilHTTPException;

	/**
	 * @return A list of the user's friends.
	 * @throws UtilHTTPException
	 */
	public Friends getFacebookUserFriends() throws UtilHTTPException;

	/**
	 * @param userID
	 * @return The mutual friends (if there are any) of the current user and the
	 *         provided UserID.
	 * @throws UtilHTTPException
	 */
	public MutualFriends getFacebookUserMutualFriends(String userID) throws UtilHTTPException;

	/**
	 * @return A list of the user's likes.
	 * @throws UtilHTTPException
	 */
	public Likes getFacebookUserLikes() throws UtilHTTPException;

	/**
	 * @return A list of the user's liked movies.
	 * @throws UtilHTTPException
	 */
	public Movies getFacebookUserMovies() throws UtilHTTPException;

	/**
	 * @return A list of the user's liked music.
	 * @throws UtilHTTPException
	 */
	public Music getFacebookUserMusic() throws UtilHTTPException;

	/**
	 * @return A list of the user's liked books.
	 * @throws UtilHTTPException
	 */
	public Books getFacebookUserBooks() throws UtilHTTPException;

	/**
	 * @return A list of the user's notes.
	 * @throws UtilHTTPException
	 */
	public Notes getFacebookUserNotes() throws UtilHTTPException;

	/**
	 * @return A list of the user's events.
	 * @throws UtilHTTPException
	 */
	public Events getFacebookUserEvents() throws UtilHTTPException;

	/**
	 * @return A list of the user's groups.
	 * @throws UtilHTTPException
	 */
	public Groups getFacebookUserGroups() throws UtilHTTPException;

	/**
	 * @return A list of the user's permissions:</br> The permissions the user
	 *         gave to the App.
	 * @throws UtilHTTPException
	 */
	public Permissions getFacebookUserPermissions() throws UtilHTTPException;

	public Request getRequest(String request_id) throws UtilHTTPException;

	public String getPublicUserDetailsByEmail(String email) throws UtilHTTPException;

	void deleteFacebookRequest(String requestObjID, String userID) throws UtilHTTPException;

	/**
	 * @return ProfilePictureTaggedPics
	 * @throws UtilHTTPException
	 */
	public ProfilePicturePics getFacebookUserProfilePics() throws UtilHTTPException;
}
