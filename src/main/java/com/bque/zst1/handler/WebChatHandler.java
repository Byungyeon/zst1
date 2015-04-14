package com.bque.zst1.handler;

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
