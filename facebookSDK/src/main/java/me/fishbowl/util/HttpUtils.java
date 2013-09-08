package me.fishbowl.util;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import me.fishbowl.exceptions.UtilHTTPException;
import me.fishbowl.util.Const.HttpMethod;

public class HttpUtils {

	public static String makeHttpRequest(String urlString,
			Map<String, String> requestParams, Const.HttpMethod requestMethod)
			throws UtilHTTPException {

		if (urlString == null || urlString.equals("")) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"the url string was null or empty.");
			throw httpExeption;
		}

		if (!urlString.contains("http")) {
			// by default we will communicate via http, if not specified.
			urlString = "http://" + urlString;
		}

		StringBuilder params = new StringBuilder();

		try {
			// parse the request params:
			if (requestParams != null && requestParams.keySet().size() > 0) {
				boolean isFirstParam = true;
				for (Iterator<String> paramIter = requestParams.keySet()
						.iterator(); paramIter.hasNext();) {
					String paramStr = paramIter.next();
					if (isFirstParam) {
						if (requestMethod == HttpMethod.GET) {
							params.append("?" + paramStr);
						} else {
							params.append(paramStr);
						}
						isFirstParam = false;

					} else {
						params.append("&" + paramStr);
					}
					if (requestParams.get(paramStr) != null) {
						params.append("="
								+ URLEncoder.encode(
										requestParams.get(paramStr), "UTF-8"));
					} else {
						params.append("=" + URLEncoder.encode("", "UTF-8"));
					}
				}
			}

			// Create a URL for the desired page
			URL url;
			if (requestMethod == HttpMethod.GET) {
				url = new URL(urlString + params.toString());
			} else {
				url = new URL(urlString);
			}

			// open the connection
			URLConnection urlconn = url.openConnection();

			if (requestMethod == HttpMethod.POST) {
				urlconn.setDoOutput(true);
				// getting the streams:
				OutputStream raw = urlconn.getOutputStream();
				OutputStream buffered = new BufferedOutputStream(raw);
				OutputStreamWriter out = new OutputStreamWriter(buffered,
						"UTF-8");

				// Preparing the POST data for delivery:
				String stringParams = params.toString();
				if (!stringParams.equals("")) {
					out.write(stringParams);
				}
				// flushing the data to the server
				out.flush();
				out.close();
			}

			// getting the server's response :

			// first we need to check the http header response, if there has
			// been some kind of error
			// it would appear in the http header response and not in the
			// inputStream:

			Map<String, List<String>> headerResponse = urlconn
					.getHeaderFields();
			boolean hasErrors = false;
			boolean isPicture = false;
			Iterator<String> headerResponseItr = headerResponse.keySet()
					.iterator();

			if (headerResponse != null && headerResponse.keySet().size() > 0) {
				String currHeader;
				while (headerResponseItr.hasNext()) {
					currHeader = headerResponseItr.next();
					List<String> currHeaderValue = headerResponse
							.get(currHeader);
					// check for header errors:
					for (String currVal : currHeaderValue) {
						if (currVal.contains(Const.HTTP400)
								|| currVal.contains(Const.HTTP401)
								|| currVal.contains(Const.HTTP402)
								|| currVal.contains(Const.HTTP403)
								|| currVal.contains(Const.HTTP404)
								|| currVal.contains(Const.HTTP405)
								|| currVal.contains(Const.HTTP406)
								|| currVal.contains(Const.HTTP407)
								|| currVal.contains(Const.HTTP408)
								|| currVal.contains(Const.HTTP409)
								|| currVal.contains(Const.HTTP410)
								|| currVal.contains(Const.HTTP411)
								|| currVal.contains(Const.HTTP412)
								|| currVal.contains(Const.HTTP413)
								|| currVal.contains(Const.HTTP414)
								|| currVal.contains(Const.HTTP415)
								|| currVal.contains(Const.HTTP416)
								|| currVal.contains(Const.HTTP417)) {
							hasErrors = true;
						}
						if (currVal.contains("image/jpeg")
								|| currVal.contains("image/gif")) {
							isPicture = true;
						}
					}
				}

			} else {
				UtilHTTPException httpExeption = new UtilHTTPException(
						"Some unknown error has occurred. the header response returned empty.\n check the url and parameters");
				throw httpExeption;
			}

			if (hasErrors) {

				String headerRsp = headerResponse.toString();
				if (headerRsp.equals("{}")) {
					headerRsp = "Some unknown error has occurred. the header response returned empty.\n check the url and parameters";
				}
				UtilHTTPException httpExeption = new UtilHTTPException(
						headerRsp);
				throw httpExeption;
			}

			if (isPicture) {

				return urlconn.getURL().toString();
			}

			// there are no errors, get the server's response:
			InputStream in_str = urlconn.getInputStream();
			InputStreamReader reader = new InputStreamReader(in_str);
			int bits;
			StringBuilder sb = new StringBuilder();
			while ((bits = reader.read()) != -1) {
				// creating a String from the stream of bits via
				// a String builder:
				sb.append((char) bits);
			}
			// closing the stream
			in_str.close();
			// return the server's response:
			return sb.toString();
		} catch (MalformedURLException e) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"There was a problem with the URL, Check that it's valid.",
					e);
			throw httpExeption;
		} catch (IOException e) {
			UtilHTTPException httpExeption = new UtilHTTPException(
					"There was a problem with the server's streams", e);
			throw httpExeption;
		}

	}

}
