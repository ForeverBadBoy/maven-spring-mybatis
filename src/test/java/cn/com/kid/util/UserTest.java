package cn.com.kid.util;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import cn.com.kid.pojo.User;

public class UserTest {
	SqlSessionFactory sqlSessionFactory;
	@Before
	public void setUp() throws Exception {
		// 读取资源流
		InputStream in = Resources.getResourceAsStream("cn/com/kid/mapping/UserMapper.xml");
		//InputStream in =  ClassLoader.getSystemResourceAsStream("cn/com/kid/mapping/UserMapper.xml");
		// 初始化session工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
	}
 
	@Test
	public void selectUser() {
		// 创建一个sqlsession
		SqlSession session = sqlSessionFactory.openSession();
		try {
			User user = session.selectOne(
					"cn.com.kid.dao.IUserDao.selectByPrimaryKey",1);
			System.out.println(user);
		} finally {
			session.close();
		}
	}
	
 
}