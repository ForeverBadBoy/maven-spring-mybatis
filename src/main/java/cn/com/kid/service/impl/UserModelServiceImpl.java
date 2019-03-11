package cn.com.kid.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.com.kid.dao.IUserModelDao;
import cn.com.kid.service.IUserModelService;
@Service("userModelService")  
public class UserModelServiceImpl implements IUserModelService{
	@Autowired
	public IUserModelDao userModelDao;
 
	@Override
	public List<Map<String, Object>> selectAll() {
 		return userModelDao.selectAll();
	}

	@Override
	public Map<String, Object> selectUser(Map<String, Object> params) {
		return userModelDao.selectUser(params);
	}

	@Override
	public List<Map<String, Object>> selectTab(Map<String, Object> params) {
 		return userModelDao.selectTab(params);
	}

}
