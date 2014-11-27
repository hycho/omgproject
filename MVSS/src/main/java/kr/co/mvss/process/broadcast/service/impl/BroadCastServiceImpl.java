package kr.co.mvss.process.broadcast.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.co.mvss.process.broadcast.dao.impl.BroadCastDaoImpl;
import kr.co.mvss.process.broadcast.service.BroadCastService;

import org.springframework.stereotype.Service;

@Service("broadCastService")
public class BroadCastServiceImpl implements BroadCastService {
    
	@Resource(name="broadCastDao")
  private BroadCastDaoImpl broadCastDao;

  public List<Map<String, Object>> selectBest5BroadCast(Map<String, Object> params) throws Exception {
	  return broadCastDao.selectBest5BroadCast(params);
    }
          
}
