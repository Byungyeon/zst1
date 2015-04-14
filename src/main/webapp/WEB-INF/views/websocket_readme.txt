// #########################
// 개발 환경
	JDK 1.7
	Spring 4.1.5
	Tomcat 7.0
	Servlet 3.0.1
// #########################

// #########################
// 설정 추가
xmlns:websocket="http://www.springframework.org/schema/websocket"
xsi:schemaLocation=" http://www.springframework.org/schema/websocket http://www.springframework.org/schema/websocket/spring-websocket-4.0.xsd"

<websocket:handlers>
	<websocket:mapping handler="webChatHandler" path="/webChatServer"/>
</websocket:handlers>		
<beans:bean id="webChatHandler" class="com.ncgn.zst2.WebChatHandler"/>
// #########################

// #########################
// pom.xml 추가

<java-version>1.7</java-version>
<org.springframework-version>4.1.5.RELEASE</org.springframework-version>

<dependency>
    <groupId>javax.servlet</groupId>
    <artifactId>javax.servlet-api</artifactId>
    <version>3.0.1</version>
    <scope>provided</scope>
</dependency>

<!-- websocket -->
<dependency>
    <groupId>javax.websocket</groupId>
    <artifactId>javax.websocket-api</artifactId>
    <version>1.0</version>
    <scope>provided</scope>
</dependency>

<!-- spring-websocket -->
<dependency>
    <groupId>org.springframework</groupId>
    <artifactId>spring-websocket</artifactId>
    <version>4.0.4.RELEASE</version>
</dependency>
// #########################


// #########################
// WebChatHandler.java

package com.ncgn.zst2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.handler.TextWebSocketHandler;

//@Component(value="webChatHandler")
@EnableWebSocket
public class WebChatHandler extends TextWebSocketHandler{

	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();
	
	@Override
	public void afterConnectionEstablished(WebSocketSession session)
			throws Exception {
		super.afterConnectionEstablished(session);
		System.out.println("session connection : "+session.getId());
		
		broadcast(session.getId()+" 님이 입장하셨습니다.");
		sessionList.add(session);
	}
	
	protected void handleTextMessage(WebSocketSession session,
			TextMessage message) throws Exception {
		
		String id = session.getId();
		String playload = message.getPayload();		
		System.out.println("handleTextMessage - ["+id+"] : "+playload);
		
		broadcast("["+id+"] : "+playload);
	}
	
	
	public void afterConnectionClosed(WebSocketSession session,
			CloseStatus status) throws Exception {
		super.afterConnectionClosed(session, status);
		System.out.println("session close : "+session.getId()+" - "+status.getCode());
		sessionList.remove(session);
		
		broadcast(session.getId()+" 님이 퇴장하셨습니다.");
	}
	
	private void broadcast(String message) throws IOException{
		for(WebSocketSession client : sessionList){
			System.out.println("client : "+client.getId());
			if(client.isOpen()){
				System.out.println(message);
				client.sendMessage(new TextMessage(message));
			}
		}
	}
}

// #########################


// #########################
// webChat.jsp

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

// #########################
