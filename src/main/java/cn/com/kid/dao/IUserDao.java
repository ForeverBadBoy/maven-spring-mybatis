package cn.com.kid.dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.com.kid.pojo.User;

public interface IUserDao {
	//@Select("select * from users where id = #{id}")
	public User selectByPrimaryKey(int userId);
	
	public User getUserById(int userId);
	
	public List<User> selectAll();
	
	public void updateUser(User user);
}
