package kr.co.mvss.process.drama.dao;

import java.util.List;
import java.util.Map;

public interface DramaDao {
	
	public List<Map<String, Object>> selectBest5Drama(Map<String, Object> params) throws Exception;
	
}