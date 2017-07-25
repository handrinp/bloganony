package com.bloganony;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class DataHandler {
	private static DataHandler instance;
	private static final String JSON_URL = "https://api.myjson.com/bins/1cme3";

	private DataHandler() {
	}

	public static DataHandler getInstance() {
		if (instance == null) {
			instance = new DataHandler();
		}

		return instance;
	}

	public String getSticky() {
		return new JSONObject(getJSON()).getString("sticky");
	}

	public List<Post> getAllPosts() {
		List<Post> posts = new ArrayList<>();
		JSONArray postsArray = new JSONObject(getJSON()).getJSONArray("posts");

		for (int i = 0; i < postsArray.length(); ++i) {
			posts.add(new Post(postsArray.getJSONObject(i)));
		}

		return posts;
	}

	private static String getJSON() {
		HttpURLConnection conn = null;
		StringBuilder json = new StringBuilder();

		try {
			URL url = new URL(JSON_URL);
			conn = (HttpURLConnection) url.openConnection();
			InputStreamReader in = new InputStreamReader(conn.getInputStream());

			int read;
			char[] buff = new char[1024];

			while ((read = in.read(buff)) != -1) {
				json.append(buff, 0, read);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.disconnect();
			}
		}

		return json.toString();
	}
}
