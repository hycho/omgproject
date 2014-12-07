package kr.co.mvss.process.drama.dao;

import java.util.List;
import java.util.Map;

public interface DramaDao {
	
	public List<Map<String, Object>> selectBest8Drama(Map<String, Object> params) throws Exception;
	public List<Map<String, Object>> selectDramaById(Map<String, Object> params) throws Exception;
	public List<Map<String, Object>> selectDramaTags(Map<String, Object> params) throws Exception;
	
}
