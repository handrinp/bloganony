function loadJsonAndPosts() {
	doGet(function(obj) {
		document.getElementById("editJson").value = JSON
				.stringify(obj, null, 2);

		var inner = "";

		if (obj.posts.length == 0) {
			inner += "<hr><h2 align='center'>No posts yet. Add one!</h2><br>";
		} else {
			obj.posts.sort(function(a, b) {
				return b.date - a.date
			});
		}

		for (i = 0; i < obj.posts.length; i++) {
			var post = obj.posts[i];
			var postDate = new Date(post.date);
			var prettyDate = postDate.toLocaleTimeString() + " - "
					+ postDate.toLocaleDateString();
			var imgURL = (post.img.length > 0 ? "<a target='_blank' href='"
					+ post.img + "'><img class='postImage' src='" + post.img
					+ "'" + "></a><br>" : "");
			inner += "<hr><button onclick='deletePost(\"" + post.id
					+ "\")' class='deletebtn'>X</button><br>";
			inner += "<h2 id='" + post.id + "'>" + post.title + "</h2><p>"
					+ prettyDate + "</p>";
			if (post.body.length > 0)
				inner += "<p>" + post.body + "</p>";
			inner += "<br>" + imgURL;

			if (post.comments.length > 0) {
				inner += "<h4>Comments:</h4>";
				for (j = 0; j < post.comments.length; j++) {
					inner += "<p class='comment'>-- " + post.comments[j]
							+ "</p>";
				}
			}

		}

		document.getElementById("mainBody").innerHTML = inner;
	});
}

function editJson() {
	doGet(function() {
		doPut(document.getElementById('editJson').value, loadJsonAndPosts);
	});
}

function deletePost(idToDelete) {
	doGet(function(obj) {
		obj.posts = obj.posts.filter(function(post) {
			post.id != idToDelete;
		});

		doPut(JSON.stringify(obj), loadJsonAndPosts);
	});
}

function failsafe() {
	var failSafeJson = '{"sticky": "<br><h2>User contributed?</h2><p>That\'s right. Anyone can post on here anonymously. Use the button above to begin a post.</p><br>","posts": []}';

	doGet(function() {
		doPut(failSafeJson, loadJsonAndPosts);
	});
}

$(loadJsonAndPosts);
