package com.bigcho.mps.support.security.securedobject;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import com.bigcho.mps.support.security.securedobject.SecuredObjectService;

public class SecuredObjectServiceImpl implements SecuredObjectService {

	private SecuredObjectDao securedObjectDao;
	
	public void setSecuredObjectDao(SecuredObjectDao securedObjectDAO) {
		this.securedObjectDao = securedObjectDAO;
	}

	public LinkedHashMap<RequestMatcher, List<ConfigAttribute>> getRolesAndUrl() throws Exception {
		LinkedHashMap<RequestMatcher, List<ConfigAttribute>> ret = new LinkedHashMap<RequestMatcher, List<ConfigAttribute>>();
		
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getRolesAndUrl();
		
		Set<Object> keys = data.keySet();
		
		for (Object key : keys) {
			ret.put((AntPathRequestMatcher)key, data.get(key));
		}
		
		return ret;
		
	}

	public LinkedHashMap<String, List<ConfigAttribute>> getRolesAndMethod() throws Exception {
		LinkedHashMap<String, List<ConfigAttribute>> ret = new LinkedHashMap<String, List<ConfigAttribute>>();
		
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getRolesAndMethod();
		
		Set<Object> keys = data.keySet();
		
		for (Object key : keys) {
			ret.put((String)key, data.get(key));
		}
		
		return ret;
	}

	public LinkedHashMap<String, List<ConfigAttribute>> getRolesAndPointcut() throws Exception {
		LinkedHashMap<String, List<ConfigAttribute>> ret = new LinkedHashMap<String, List<ConfigAttribute>>();
		
		LinkedHashMap<Object, List<ConfigAttribute>> data = securedObjectDao.getRolesAndPointcut();
		
		Set<Object> keys = data.keySet();
		
		for (Object key : keys) {
			ret.put((String)key, data.get(key));
		}
		
		return ret;
	}

	public List<ConfigAttribute> getMatchedRequestMapping(String url) throws Exception {
		return securedObjectDao.getRegexMatchedRequestMapping(url);
	}

	public String getHierarchicalRoles() throws Exception {
		return securedObjectDao.getHierarchicalRoles();
	}
}
