<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3c.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSE Demo</title>
<script src="assets/js/jquery.js" type="text/javascript"></script>
<script>
if (!!window.EventSource) {
    var source = new EventSource('push');
    s = '';
    source.addEventListener('message', function(e) {
        s += e.data + "</br>";
        $("#msgFromPush").html(s);
    });

    source.addEventListener('open', function(e) {
        console.log("open connection.");
    }, false);

    source.addEventListener('error', function(e) {
        if (e.readyState == EventSource.CLOSED) {
            console.log("connection closed.");
        } else {
            console.log(e.readyState);
        }
    });
} else {
    console.log("Your browser doesn't support SSE!");
}
</script>
</head>
<body>
    <div id="msgFromPush"></div>
</body>
</html>
