<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="UTF-8">
<head>
	<meta charset="utf-8" />
	<meta http-equiv="CACHE-CONTROL" content="NO-CACHE"/>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<meta http-equiv="Content-Script-Type" content="text/javascript" />
	<meta http-equiv="Content-Style-Type" content="text/css" />
	
	<script type="text/javascript" src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.2/jquery.min.js"></script>
	<script type="text/javascript">
		var ws = null;
		var url = "ws://localhost:8080/webChatServer";
	 
		function connect() {
			ws = new WebSocket(url);
	 
			ws.onopen = function () {
				// 서버에 접속한 후 이벤트 정의
				$("#display").append("<br/>")
				$("#display").append("connection ....");
			};
			ws.onmessage = function (event) {
				// 서버에서 Session.send를 이용해서 메시지 전송할 때 수신 이벤트 정의
				$("#display").append("<br/>")
				$("#display").append(event.data);
			};
			ws.onclose = function (event) {
				// 서버에서 접속 종료한 후 이벤트 정의
				$("#display").append("<br/>")
				$("#display").append("close ....");
			};
		}
	 
		function disconnect() {
			ws.close();
			ws = null;
		}
	 
		function echo() {
			// send 명령을 이용해서 전송을 한다.
			ws.send($("#message").val());
		}
		
		$(document).ready(function() {
			$("#btnConn").click(function(){
				connect();
			});
			
			$("#btnClose").click(function(){
				disconnect();
			});
			
			$("#btnSend").click(function(){
				echo();
			});
		});
	</script>
</head>
<body>
Chat 
<button id="btnConn">연결하기</button> 
<button id="btnClose">연결끊기</button>
<br/><br/><br/>
<input type="text" id="message" size="50"><button id="btnSend">발송</button>
<br/><br/><br/>
<div id="display" style="height: auto; width: 500px; border-top:1px solid gold; border-right:1px solid gold;border-left:1px solid gold;">
	
</div>
</body>
</html>