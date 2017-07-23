var jsonUrl = "https://api.myjson.com/bins/1cme3";

function doPut(putData, callback) {
	$.ajax({
		url : jsonUrl,
		type : "PUT",
		data : putData,
		contentType : "application/json; charset=utf-8",
		dataType : "json",
		success : callback
	});
}

function doGet(callback) {
	$.get(jsonUrl, callback);
}
