package cn.com.kid.service;

import java.util.List;

import cn.com.kid.pojo.User;

public interface IUserService {
	public User getUserById(int userId); 
	
	public User selectByPrimaryKey(int userId);
	
	public List<User> selectAll();
	
	public void updateUser(User user);
	
}
