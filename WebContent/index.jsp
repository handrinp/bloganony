<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="description"
	content="Anonymous blog where anyone can post anything.">
<meta property="og:title" content="Bloganony">
<meta property="og:type" content="website">
<meta property="og:url" content="http://bloganony.com/">
<meta property="og:image"
	content="http://localhost:8080/bloganony/img/screenie.png">
<meta property="og:description"
	content="Anonymous blog where anyone can post anything.">
<meta name="keywords" content="blog,anonymous,yik yak">
<meta name="author" content="Nick Handrick">
<link href='https://fonts.googleapis.com/css?family=Roboto'
	rel='stylesheet' type='text/css'>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="css/styles-full.css">
<link rel="stylesheet" type="text/css" href="css/styles-mobile.css">
<link rel="stylesheet" type="text/css" href="css/imgur.css">
<link rel="shortcut icon" href="img/favicon.ico">
<title>Bloganony</title>
</head>
<body>
	<div id="wholePage">
		<div id="header">
			<h1>Bloganony.com</h1>
			<h2>Anonymous, user contributed blog</h2>
			<a id="postButtonFull" onclick="showPostArea()"><img
				src="img/post.png"></a>
		</div>
		<div id="postButtonMobile">
			<a onclick="showPostArea()">Submit New Post</a>
		</div>
		<div id="postArea">
			<button onclick="hidePostArea()" class="exitbtn">Cancel Post</button>
			<h3>Title</h3>
			<input type="text" maxlength="64" id="postTitle"> <br>
			<h3>Post</h3>
			<textarea maxlength="1024" id="postBody"></textarea>
			<br>
			<h3>Image URL</h3>
			<input type="text" maxlength="256" id="postImage"> <br>
			<br>
			<div class="dropzone"></div>
			<button class="btn" onclick="validatePost()">Submit</button>
		</div>
		<div id="mainBody" class="shadow"></div>
		<button onclick="loadMorePosts()" id="morePostsButton" class="btn">Load
			more posts</button>
		<div id="footer">
			<p>
				Last Update: June 26, 2016 | <a href="mailto:admin@bloganony.com">Question/Comment?</a>
			</p>
		</div>
	</div>
	<script src="js/jquery.js"></script>
	<script src="js/script.js"></script>
	<script src="js/imgur.min.js"></script>
</body>
</html>
