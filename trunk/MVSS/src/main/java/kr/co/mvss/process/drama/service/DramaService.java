package kr.co.mvss.process.drama.service;

import java.util.List;
import java.util.Map;

public interface DramaService {
	
	public List<Map<String, Object>> selectBest5Drama(Map<String, Object> params) throws Exception;
	
}
