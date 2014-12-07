package kr.co.mvss.process.drama.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mvss.process.drama.dao.impl.DramaDaoImpl;
import kr.co.mvss.process.drama.service.DramaService;

import org.springframework.stereotype.Service;

@Service("dramaService")
public class DramaServiceImpl implements DramaService {
    
	@Resource(name="dramaDao")
	private DramaDaoImpl dramaDao;

	public List<Map<String, Object>> selectBest8Drama(Map<String, Object> params) throws Exception {
		return dramaDao.selectBest8Drama(params);
	}

	@Override
	public List<Map<String, Object>> selectDramaById(Map<String, Object> params) throws Exception {
		return dramaDao.selectDramaById(params);
	}
	
	@Override
	public List<Map<String, Object>> selectDramaTags(Map<String, Object> params) throws Exception {
		return dramaDao.selectDramaTags(params);
	}
          
}
