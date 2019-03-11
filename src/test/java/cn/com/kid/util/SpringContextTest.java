package cn.com.kid.util;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.com.kid.pojo.User;
import cn.com.kid.service.IUserModelService;
import cn.com.kid.service.IUserService;  

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml","classpath:spring-mvc.xml","classpath:mybatis-config.xml","classpath:applicationContext.xml"})
public class SpringContextTest {
	/*@Resource(name="userService")  
    private  IUserService userService = null;*/
	
	public static Logger logger = LoggerFactory.getLogger(SpringContextTest.class);
	
	@Autowired
    private  IUserService userService ;
	
	@Autowired
	private IUserModelService userModelService;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
 		/*System.out.println(userService.selectByPrimaryKey(26));
 		logger.info(userService.getUserById(26).toString());*/
 		//List<Map<String, Object>> userList = userModelService.selectAll();
 		//logger.info(userList.toString());
 		//logger.info(userList.size()+"");
 		Map<String, Object> params = new HashMap<String, Object>();
 		params.put("userName", "张三");//字段值
 		params.put("uid", 3);
 		params.put("username", "userName");//字段名
 		//System.out.println(userModelService.selectUser(params));
 		params.put("tableName", "students");
 		System.out.println(userModelService.selectTab(params));
 		User user = userService.getUserById(26);
 		//user.setPassWord("abc45");
 		//userService.updateUser(user);
 		//List<Map<String, Object>> users = new UserModel().getUserList();
 		//users = userList;
	}

	 
}
