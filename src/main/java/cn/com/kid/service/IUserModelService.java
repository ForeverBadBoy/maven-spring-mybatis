package cn.com.kid.service;

import java.util.List;
import java.util.Map;

public interface IUserModelService {
	public List<Map<String, Object>> selectAll();
	
	public Map<String, Object> selectUser(Map<String, Object> params);
	
	public List<Map<String, Object>> selectTab(Map<String, Object> params);
}
