package cn.com.kid.servlet;


import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;

import cn.com.kid.pojo.User;
import cn.com.kid.service.IUserService;

/**
 * Servlet implementation class ServletDemo
 */
public class ServletDemo extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public static Logger logger = LoggerFactory.getLogger(ServletDemo.class);
	
	@Autowired
	IUserService service;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletDemo() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");  
        response.setContentType("text/html;charset=utf-8");
        String name = request.getParameter("name");  
        String password = request.getParameter("password");  
        System.out.println("name->" + name + ",password->" + password);
        request.setAttribute("name", name);
        request.setAttribute("password", password);
        for (User user : service.selectAll()) {
			System.out.println(user);
		}
        request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		/*Filter和Servlet使用autowire注解来进行注入会有问题，下面语句可查
		看 ApplicationContext 有那些已經注入(inject) 的 Spring beans*/
		SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, config.getServletContext());
	}
}
