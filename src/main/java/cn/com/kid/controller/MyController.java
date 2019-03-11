package cn.com.kid.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller  
@RequestMapping("/") 
public class MyController {
	public static Logger logger = LoggerFactory.getLogger(MyController.class);
	
	@RequestMapping("/ws.htm")  
	public String ws(HttpServletRequest request,Model model){  
		return "ws";  
	}  
	
	@RequestMapping("/MyWebSocket.htm")  
	public String MyWebSocket(HttpServletRequest request,Model model){  
		return "MyWebSocket";  
	}  
}
