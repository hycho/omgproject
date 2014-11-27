package kr.co.mvss.process.broadcast.service;

import java.util.List;
import java.util.Map;

public interface BroadCastService {
	
	/**
	 * 5개의 BroadCast 정보를 recomment와 updateDate순서를 통해서 가져온다.  
	 * @param params
	 * @return
	 * @throws Exception
	 */
	public List<Map<String, Object>> selectBest5BroadCast(Map<String, Object> params) throws Exception;
	
}
