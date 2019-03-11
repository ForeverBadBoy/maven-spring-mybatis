package cn.com.kid.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.com.kid.pojo.User;
import cn.com.kid.service.IUserService;

@Controller  
@RequestMapping("/user") 
public class UserController {
	public static Logger logger = LoggerFactory.getLogger(UserController.class);
			
	@Autowired  
	private IUserService userService;  

	
	@RequestMapping("/showUser")  
	public String showUser(HttpServletRequest request,Model model){  
		int userId = Integer.parseInt(request.getParameter("id"));  
		User user = this.userService.getUserById(userId);  
		if (user!=null) {
			model.addAttribute("user", user); 
			logger.info("user="+user);
		}
		logger.info("showUser success!!!");
		return "showUser";  
	}  
	
	@RequestMapping("/showAllUser")  
	public String showAllUser(HttpServletRequest request,Model model){  
 		List<User> users = this.userService.selectAll(); 
		if (users!=null) {
			model.addAttribute("Users", users); 
			logger.info("users="+users);
		}
		logger.info("showAllUser success!!!");
		return "showUser";  
	}  

}
