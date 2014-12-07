package kr.co.mvss.process.drama.service;

import java.util.List;
import java.util.Map;

public interface DramaService {
	
	public List<Map<String, Object>> selectBest8Drama(Map<String, Object> params) throws Exception;
	public List<Map<String, Object>> selectDramaById(Map<String, Object> params) throws Exception;
	public List<Map<String, Object>> selectDramaTags(Map<String, Object> params) throws Exception;
	
}
