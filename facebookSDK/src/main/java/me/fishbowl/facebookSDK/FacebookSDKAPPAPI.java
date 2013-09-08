package me.fishbowl.facebookSDK;

import me.fishbowl.exceptions.UtilHTTPException;

/**
 * Java Implementation of Facebook's API (APP API). Based on a simple Http Get
 * request to the Graph API, the parsing of the returned data, and the
 * conversion of the returned data into a Java Class.
 * 
 * @author Isaac Rousso
 * @version 1.0
 * @see https://developers.facebook.com/docs/reference/api/
 * 
 */
public interface FacebookSDKAPPAPI {

	/**
	 * @return an access token that can be used to query Facebook for App
	 *         details.
	 * @throws UtilHTTPException
	 */
	public String getAppAccessToken() throws UtilHTTPException;

	/**
	 * @return the App secret (as entered into getFacebookSDKAPP)
	 */
	public String getAppSecret();

	/**
	 * @return the App ID (as entered into getFacebookSDKAPP)
	 */
	public String getAppID();
	
	

}
