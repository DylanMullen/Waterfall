package me.dylanmullen.waterfall.util;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class DiscordOAuth
{

	private static final String OAUTH = "https://discord.com/api/oauth2/token";
	private static final String USERURL = "https://discord.com/api/users/@me";

	public static JSONObject sendUserGet(String accessToken)
	{
		try
		{
			HttpURLConnection httpClient = getConnection(USERURL, "GET");
			httpClient.addRequestProperty("Authorization", "Bearer " + accessToken);

			JSONObject data = new JSONObject();
			try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream())))
			{

				String line;
				StringBuilder response = new StringBuilder();

				while ((line = in.readLine()) != null)
					response.append(line);
				data = (JSONObject) new JSONParser().parse(response.toString());
			}
			httpClient.disconnect();
			return data;
		} catch (IOException | ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	public static JSONObject sendAuthPost(String clientID, String clientSecret, String auth)
	{
		try
		{
			HttpURLConnection httpClient = getConnection(OAUTH, "POST");
			String urlParameters = "&client_id=" + clientID + "&client_secret=" + clientSecret
					+ "&grant_type=authorization_code&code=" + auth
					+ "&redirect_uri=http%3A%2F%2Flocalhost%3A8080%2Fapi%2Fauth%2Fdiscord%2Flogin";
			httpClient.setFixedLengthStreamingMode(urlParameters.length());
			httpClient.setDoOutput(true);
			try (DataOutputStream wr = new DataOutputStream(httpClient.getOutputStream()))
			{
				wr.writeBytes(urlParameters);
				wr.flush();
			}

			JSONObject data = new JSONObject();
			try (BufferedReader in = new BufferedReader(new InputStreamReader(httpClient.getInputStream())))
			{

				String line;
				StringBuilder response = new StringBuilder();

				while ((line = in.readLine()) != null)
					response.append(line);
				data = (JSONObject) new JSONParser().parse(response.toString());
			}
			httpClient.disconnect();
			return data;
		} catch (IOException | ParseException e)
		{
			e.printStackTrace();
			return null;
		}
	}

	private static HttpURLConnection getConnection(String url, String method) throws MalformedURLException, IOException
	{
		HttpURLConnection httpClient = (HttpURLConnection) new URL(url).openConnection();
		httpClient.setRequestMethod(method);
		httpClient.setRequestProperty("User-Agent", "Mozilla/5.0");
		httpClient.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
		return httpClient;
	}
}
