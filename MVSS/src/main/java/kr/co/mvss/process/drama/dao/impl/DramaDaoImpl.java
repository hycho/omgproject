package kr.co.mvss.process.drama.dao.impl;

import java.util.List;
import java.util.Map;

import kr.co.mvss.core.database.mybatis3.BaseSqlSessionDaoSupport;
import kr.co.mvss.process.drama.dao.DramaDao;

import org.springframework.stereotype.Repository;

@Repository("dramaDao")
public class DramaDaoImpl extends BaseSqlSessionDaoSupport implements DramaDao{

	@Override
	public List<Map<String, Object>> selectBest8Drama(Map<String, Object> params) throws Exception {
		return getSqlSession().selectList("dramaDao.selectBest8Drama", params);
	}

	@Override
	public List<Map<String, Object>> selectDramaById(Map<String, Object> params) throws Exception {
		return getSqlSession().selectList("dramaDao.selectDramaById", params);
	}
	
	@Override
	public List<Map<String, Object>> selectDramaTags(Map<String, Object> params) throws Exception {
		return getSqlSession().selectList("dramaDao.selectDramaTags", params);
	}

}
