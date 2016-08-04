package org.springframework.samples.websocket.config;

import org.springframework.samples.websocket.SessionFactory;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.io.IOException;
import java.util.Map;
import java.util.Set;

/**
 * Created by 宗祥 on 2016/8/4.
 */
public class WebsocketEndPoint extends TextWebSocketHandler {

    @Override
    protected void handleTextMessage(WebSocketSession session,
                                     TextMessage message) throws Exception {
        super.handleTextMessage(session, message);
        TextMessage returnMessage = new TextMessage(message.getPayload()+" received at server");
//        session.sendMessage(returnMessage);
        sendMessageToUsers(session, message);
    }

    /**
     * 给所有在线用户发送消息
     * @param message
     */
    public void sendMessageToUsers(WebSocketSession sourceSession, TextMessage message) {
        Map<String, WebSocketSession> sessions = SessionFactory.sessions;
        if(null == sessions && sessions.isEmpty()){
            return;
        }
        Set<String> keys = sessions.keySet();
        WebSocketSession toSession = null;
        for (String key : keys) {
            try {
                if(key.equals(sourceSession.getId())){
                    continue;
                }
                if(toSession.isOpen()){
                    System.out.println("发送信息成功。");
                    toSession.sendMessage(message);
                }else{
                    System.out.println("发送信息失败，对方已经关闭");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
