package kr.co.mvss.process.broadcast.dao;

import java.util.List;
import java.util.Map;

public interface BroadCastDao {
	
	public List<Map<String, Object>> selectBest5BroadCast(Map<String, Object> params) throws Exception;
	
}
