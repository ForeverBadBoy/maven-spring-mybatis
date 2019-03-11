package cn.com.kid.dao;

import java.util.List;
import java.util.Map;

public interface IUserModelDao {
	public List<Map<String, Object>> selectAll();
	
	public Map<String, Object> selectUser(Map<String, Object> params);
	
	public List<Map<String, Object>> selectTab(Map<String, Object> params);
 }
