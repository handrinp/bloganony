package com.bloganony;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class Post {
	private String id;
	private long date;
	private String title;
	private String body;
	private String imgURL;
	private List<String> commentIDs;

	@SuppressWarnings("unused")
	private Post() {
	}

	public Post(String id, long date, String title, String body, String imgURL) {
		this.id = id;
		this.date = date;
		this.title = title;
		this.body = body;
		this.imgURL = imgURL;
		this.commentIDs = new ArrayList<>();
	}

	public Post(JSONObject po) {
		this(po.getString("id"), po.getLong("date"), po.getString("title"), po.getString("body"), po.getString("img"));
		JSONArray jsonCommentsArray = po.getJSONArray("comments");

		for (int i = 0; i < jsonCommentsArray.length(); ++i) {
			addComment(jsonCommentsArray.getString(i));
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getDate() {
		return date;
	}

	public void setDate(long date) {
		this.date = date;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public List<String> getCommentIDs() {
		return commentIDs;
	}

	public void removeComment(String commentID) {
		commentIDs.remove(commentID);
	}

	public void addComment(String commentID) {
		commentIDs.add(commentID);
	}
}
