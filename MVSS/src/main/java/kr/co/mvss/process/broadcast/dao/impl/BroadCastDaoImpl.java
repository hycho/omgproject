package kr.co.mvss.process.broadcast.dao.impl;

import java.util.List;
import java.util.Map;

import kr.co.mvss.core.database.mybatis3.BaseSqlSessionDaoSupport;
import kr.co.mvss.process.broadcast.dao.BroadCastDao;

import org.springframework.stereotype.Repository;

@Repository("broadCastDao")
public class BroadCastDaoImpl extends BaseSqlSessionDaoSupport implements BroadCastDao{

	@Override
	public List<Map<String, Object>> selectBest5BroadCast(Map<String, Object> params) throws Exception {
		return getSqlSession().selectList("broadCastDao.selectBest5BroadCast", params);
	}
    
}
