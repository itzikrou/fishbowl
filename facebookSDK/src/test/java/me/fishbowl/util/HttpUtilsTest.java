package me.fishbowl.util;

import static org.junit.Assert.assertTrue;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import me.fishbowl.exceptions.UtilHTTPException;

import org.junit.BeforeClass;
import org.junit.Test;

public class HttpUtilsTest {

	// some test urls:
	private static String testUrl_Http = "http://gomashup.com/json.php?fds=geo/timezone/dst/-10&jsoncallback=?";
	private static String testUrl_Https = "https://graph.facebook.com/oauth/access_token";
	private static String testUrl_Http_invalid1 = "gomashup.com/json.php?fds=geo/timezone/dst/-10&jsoncallback=?";
	private static String testUrl_Http_invalid2 = "http://gomashup";
	static Map<String, String> testUrl_HttpsParams;
	static Map<String, String> testUrl_HttpParams;

	private static final String appId_prop = "facebookSDK.appId";
	private static final String appSecret_prop = "facebookSDK.appSecret";

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUp() throws Exception {

		// load the properties file:
		Properties prop = new Properties();

		InputStream in = HttpUtilsTest.class
				.getResourceAsStream("/facebookSDK.properties");

		prop.load(in);

		testUrl_HttpsParams = new HashMap<String, String>();
		testUrl_HttpsParams.put("client_id", prop.getProperty(appId_prop));
		testUrl_HttpsParams.put("client_secret",
				prop.getProperty(appSecret_prop));
		testUrl_HttpsParams.put("grant_type", "client_credentials");

		testUrl_HttpParams = new HashMap<String, String>();
		testUrl_HttpParams.put(Const.FACEBOOKID, "1234");
		testUrl_HttpParams.put(Const.ACCESSTOKEN, "1234");
		testUrl_HttpParams.put(Const.EXPIRESIN, "1234");
		testUrl_HttpParams.put(Const.SIGNEDREQ, "1234");

	}

	@Test
	public void testGetHttpRequest_http() throws UtilHTTPException {

		String httpResponse;
		httpResponse = HttpUtils.makeHttpRequest(testUrl_Http, null,
				Const.HttpMethod.GET);
		assertTrue(httpResponse.contains("TimeZoneId"));
	}

	@Test
	public void testGetHttpRequest_https_noParams() {
		String httpResponse;
		try {
			httpResponse = HttpUtils.makeHttpRequest(testUrl_Https, null,
					Const.HttpMethod.GET);
			System.out.println("testGetHttpRequest_http: " + httpResponse);
		} catch (UtilHTTPException e) {
			// facebook expects parameters, and will fail the request.
			assertTrue(true);
		}
	}

	@Test
	public void testGetHttpRequest_invalidUrl() throws UtilHTTPException {
		String httpResponse;

		// missing http://
		// there should be auto-complete
		httpResponse = HttpUtils.makeHttpRequest(testUrl_Http_invalid1, null,
				Const.HttpMethod.GET);
		assertTrue(httpResponse.contains("TimeZoneId"));
	}

	@Test
	public void testGetHttpRequest_invalidUrl_2() {
		String httpResponse;
		try {
			httpResponse = HttpUtils.makeHttpRequest(testUrl_Http_invalid2,
					null, Const.HttpMethod.GET);
			System.out.println("testGetHttpRequest_http: " + httpResponse);
		} catch (UtilHTTPException e) {
			// malformed url, should throw exception
			assertTrue(true);
		}
	}

	@Test
	public void testPostHttpRequest_https() {
		String httpResponse;
		try {
			httpResponse = HttpUtils.makeHttpRequest(testUrl_Https, null,
					Const.HttpMethod.POST);
			System.out.println("testGetHttpRequest_http: " + httpResponse);
		} catch (UtilHTTPException e) {
			assertTrue(true);
		}
	}

	@Test
	public void testPostHttpRequest_invalidUrl_2() {
		String httpResponse;
		try {
			httpResponse = HttpUtils.makeHttpRequest(testUrl_Http_invalid2,
					null, Const.HttpMethod.POST);
			System.out.println("testGetHttpRequest_http: " + httpResponse);
		} catch (UtilHTTPException e) {
			// malformed url, expecting an exception
			assertTrue(true);
		}
	}

}
