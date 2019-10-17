package com.example.demo.utils;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.RemoteEndpoint;
import javax.websocket.Session;
/**
 * @author kyoxue
 * @date 2019年10月17日
 */

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
public class WebSocketUtils {
	private final static Logger LOG = LoggerFactory.getLogger(WebSocketUtils.class);
	//定义全局变量ONLINE_USER_SESSIONS用来存储在线用户，使用ConcurrentHashMap提升并发时效率。
	public static final Map<String,Session> ONLINE_USER_SESSIONS=new ConcurrentHashMap<>();
	//消息发送方法
	public static void send(Session session,String content) {
		if (StringUtils.isEmpty(content)) {
			return;
		}
		if (null == session) {
			LOG.warn("session is null..");
			return;
		}
		//获取终端
		final RemoteEndpoint.Basic basic=session.getBasicRemote();
		if (null == basic) {
			LOG.warn("remote endpoint basic is null..");
			return;
		}
		try {
			basic.sendText(content);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			LOG.error("send text exception..",e);
		}
	}
	public static void sendAll(String content) {
		ONLINE_USER_SESSIONS.forEach((sessionId,session)->send(session,content));
	}
}
