package cn.com.kid.webSocket;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.websocket.StreamInbound;
import org.apache.catalina.websocket.WebSocketServlet;

/**
 * Servlet implementation class WebSocketTest
 * @WebServlet(urlPatterns = { "/message"})  
 * 如果要接收浏览器的ws://协议的请求就必须实现WebSocketServlet这个类
 */
@SuppressWarnings("deprecation")
@WebServlet(urlPatterns = { "/message"})
public class WebSocketTest extends WebSocketServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1446555993504704824L;
	
	public static int ONLINE_USER_COUNT = 1;
	
	//跟平常Servlet不同的是，需要实现createWebSocketInbound，在这里初始化自定义的WebSocket连接对象  
	@Override
	protected StreamInbound createWebSocketInbound(String arg0, HttpServletRequest request) {
		return new WebSocketMessageInbound(this.getUser(request));
	}
	
	public String getUser(HttpServletRequest request){
		System.out.println("getUser:"+request.getSession().getAttribute("user"));
        return (String) request.getSession().getAttribute("user");  
    } 
}
