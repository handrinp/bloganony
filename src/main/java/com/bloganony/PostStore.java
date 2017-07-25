package com.bloganony;

import java.util.HashMap;
import java.util.Map;

public class PostStore {
	private static PostStore instance;
	private Map<String, Post> posts;

	private PostStore() {
		posts = new HashMap<>();
	}

	public Post getPost(String postID) {
		return posts.get(postID);
	}

	public static PostStore getInstance() {
		if (instance == null) {
			instance = new PostStore();
		}

		return instance;
	}
}
