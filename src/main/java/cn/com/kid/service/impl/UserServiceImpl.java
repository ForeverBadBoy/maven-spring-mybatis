package cn.com.kid.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.kid.dao.IUserDao;
import cn.com.kid.pojo.User;
import cn.com.kid.service.IUserService;

@Service("userService")  
public class UserServiceImpl implements IUserService{

	@Autowired
	public IUserDao userDao; 
 
	public List<User> selectAll() {
		return userDao.selectAll();
	}
	
	public User getUserById(int userId) {
		return userDao.getUserById(userId); 
	}
	
	public User selectByPrimaryKey(int userId){
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}
}
