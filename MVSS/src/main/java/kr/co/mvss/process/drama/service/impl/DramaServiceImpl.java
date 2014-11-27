package kr.co.mvss.process.drama.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mvss.process.drama.dao.impl.DramaDaoImpl;
import kr.co.mvss.process.drama.service.DramaService;

import org.springframework.stereotype.Service;

@Service("dramaService")
public class DramaServiceImpl implements DramaService {
    
	@Resource(name="broadCastDao")
  private DramaDaoImpl dramaDao;

  public List<Map<String, Object>> selectBest5Drama(Map<String, Object> params) throws Exception {
	  return dramaDao.selectBest5Drama(params);
    }
          
}
