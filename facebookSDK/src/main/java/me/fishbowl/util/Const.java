package me.fishbowl.util;

public class Const {

	/*
	 * Http Methods
	 */

	public static enum HttpMethod {
		GET, POST, DELETE;

		public static HttpMethod toHttpMethod(String str) {
			try {
				return valueOf(str);
			} catch (Exception ex) {
				return GET;
			}
		}
	}

	public static final String FACEBOOKID = "facebookId";
	public static final String ACCESSTOKEN = "accessToken";
	public static final String EXPIRESIN = "expiresIn";
	public static final String SIGNEDREQ = "signedRequest";

	/*
	 * Facebook Profile Picture size:
	 */

	public enum ProfilePictureSize {
		// don't change this to upper case! this is the way Facebook expects it.
		thumbnail, small, normal, large, square;

		public static ProfilePictureSize toProfilePictureSize(String str) {
			try {
				return valueOf(str);
			} catch (Exception ex) {
				return square;
			}
		}

	}

	/*
	 * json responses
	 */
	public static final String JSON_OK_RSP = "{\"status\": \"ok\"}";
	public static final String JSON_AUTH_RSP = "{\"status\": \"Authorized\"}";
	public static final String JSON_NOT_AUTH_RSP = "{\"status\": \"NOT-Authorized\"}";
	public static final String JSON_ERR_RSP_GET_NOT_POST = "{\"status\": \"error\", "
			+ " \"reason\" : \"Sorry, the Fix Me Up server does not support GET requests. Please use a POST request.\""
			+ "}";
	public static final String JSON_ERR_RSP_MISSING_PARAM = "{\"status\": \"error\" ,"
			+ " \"reason\" : \"missing parameter\" ,"
			+ "\"parameterName\" : \"~paramName~\"}";
	public static final String JSON_ERR_RSP_UNKNOWN = "{\"status\": \"error\" ,"
			+ " \"reason\" : \"unknown: \"  + \"~paramName~\"}";
	public static final String JSON_ERR_RSP_SESSION_ALLREADY_EXISTS = "{\"status\": \"error\", "
			+ " \"reason\" : \"session allready exists\"" + "}";
	public static final String JSON_OK_RDRCT_RSP = "{\"status\": \"ok\", "
			+ " \"redirectLink\" : \"~link~\"" + "}";
	public static final String JSON_OK_NO_RDRCT_RSP = "{\"status\": \"ok\", "
			+ " \"redirectLink\" : \"do not redirect\"" + "}";

	/*
	 * Http responses
	 */

	public static final String HTTP200 = "200 OK";
	public static final String HTTP400 = "400 Bad Request";
	public static final String HTTP401 = "401 Unauthorized";
	public static final String HTTP402 = "402 Payment Required";
	public static final String HTTP403 = "403 Forbidden";
	public static final String HTTP404 = "404 Not Found";
	public static final String HTTP405 = "405 Method Not Allowed";
	public static final String HTTP406 = "406 Not Acceptable";
	public static final String HTTP407 = "407 Proxy Authentication Required";
	public static final String HTTP408 = "408 Request Timeout";
	public static final String HTTP409 = "409 Conflict";
	public static final String HTTP410 = "410 Gone";
	public static final String HTTP411 = "411 Length Required";
	public static final String HTTP412 = "412 Precondition Failed";
	public static final String HTTP413 = "413 Request Entity Too Large";
	public static final String HTTP414 = "414 Request-URI Too Long";
	public static final String HTTP415 = "415 Unsupported Media Type";
	public static final String HTTP416 = "416 Requested Range Not Satisfiable";
	public static final String HTTP417 = "417 Expectation Failed";

	public enum BooleanType {
		TRUE, FALSE;

		public static BooleanType toAction(String str) {
			try {
				return valueOf(str);
			} catch (Exception ex) {
				return FALSE;
			}
		}
	}

}
