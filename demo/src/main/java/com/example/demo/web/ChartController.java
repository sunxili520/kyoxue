package com.example.demo.web;
import static com.example.demo.utils.WebSocketUtils.ONLINE_USER_SESSIONS;
import static com.example.demo.utils.WebSocketUtils.sendAll;
import java.io.IOException;
import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/**
 * 聊天室接收服务
 * @author kyoxue
 * @date 2019年10月17日
 */
@Controller
@ServerEndpoint("/chart/{username}")
public class ChartController {
	private final static Logger LOG = LoggerFactory.getLogger(ChartController.class);
	@GetMapping
	public String toChart() {
		return "chat";
	}
	//新用户登录聊天室时，将用户信息添加到ONLINE_USER_SESSIONS中，同时通知聊天室中的所有人。
	//@OnOpen注解和前端的onopen事件一致，表示用户建立连接时触发。
	@OnOpen 
	public void newSessionUser(@PathParam("username") String username,Session session){
		//新用户添加到全局Map中
		if (ONLINE_USER_SESSIONS.containsKey(username)) {
			LOG.info(username+"用户名已经存在！");
			return;
		}
		ONLINE_USER_SESSIONS.put(username,session);
		String public_notice = "新用户["+username+"]加入了聊天...";
		LOG.info(public_notice);
		//将新进用户信息发给当前加入的所有用户，ONLINE_USER_SESSIONS中所有人。
		sendAll(public_notice);
	}
	//某个用户在前端发送了消息，显示给所有人
	//@OnMessage 监听发送消息的事件。
	@OnMessage 
	public void newMessage(@PathParam("username") String username,String message){
		String public_notice = "用户["+username+"]发送消息："+message;
		LOG.info(public_notice);
		//将用户发送的信息发给当前加入的所有用户，ONLINE_USER_SESSIONS中所有人。
		sendAll(public_notice);
	}
	//某个用户退出聊天，ONLINE_USER_SESSIONS全局Map要剔除，关闭session，同时通知到所有人
	//@OnClose监听用户断开连接事件。
	@OnClose 
	public void exit(@PathParam("username") String username,Session session){
		//全局Map剔除该用户	
		ONLINE_USER_SESSIONS.remove(username);
		String public_notice = "用户["+username+"]退出了聊天...";
		//通知其他用户
		sendAll(public_notice);
		try{
			session.close();
		}catch(IOException e){
			LOG.error("退出聊天，关闭session异常！",e);
		}
	}
	//当WebSocket连接出现异常时，触发@OnError事件，可以在此方法内记录下错误的异常信息，并关闭用户连接。
	@OnError 
	public void error(Session session,Throwable throwable){
		try{
			session.close();
		}catch(IOException e){
			LOG.error("onError close session excepiton...",e);
		}
		LOG.info("onError throwable msg:"+throwable.getMessage());
	}
}
