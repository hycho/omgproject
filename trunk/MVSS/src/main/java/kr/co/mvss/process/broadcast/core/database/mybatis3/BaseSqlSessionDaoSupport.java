package kr.co.mvss.process.broadcast.core.database.mybatis3;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 
 * @author hycho
 * Spring-mybatis 1.2.0 issue, get out @autowired...
 * So create BaseSqlSessionDaoSupport class extends SqlSessionDaoSupport
 * You use Mybatis for use SqlSessionDaoSupport class 
 */

public abstract class BaseSqlSessionDaoSupport extends SqlSessionDaoSupport{
	@Autowired
    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        super.setSqlSessionTemplate(sqlSessionTemplate);
    }
}
