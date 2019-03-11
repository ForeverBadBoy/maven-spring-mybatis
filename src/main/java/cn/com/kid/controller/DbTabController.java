package cn.com.kid.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.com.kid.pojo.User;
import cn.com.kid.service.IUserModelService;

@Controller  
@RequestMapping("/") 
public class DbTabController {
	public static Logger logger = LoggerFactory.getLogger(DbTabController.class);
	
	@Autowired  
	private IUserModelService userModelService;  

	
	@RequestMapping("/showTab")
	@ResponseBody
	public Map<String, Object> showTab(HttpServletRequest request,Model model){
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tableName", request.getParameter("tableName"));
			map.put("data", userModelService.selectTab(params));
			logger.info("showTab success!!!");
		} catch (Exception e) {
			logger.error("查询异常", e);
		}
		return map;  
	}  
	
	@RequestMapping("/showTabToPage")  
	public String showTabToPage(HttpServletRequest request,Model model){  
		try {
			Map<String, Object> params = new HashMap<String, Object>();
			params.put("tableName", request.getParameter("tableName"));
			model.addAttribute("tabInfo", userModelService.selectTab(params));
 			logger.info("showTab success!!!");
		} catch (Exception e) {
			logger.error("查询异常", e);
		}
		return "showTab";  
	}  

}
