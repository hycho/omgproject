package kr.co.mvss.util;

import java.io.Reader;
import java.sql.Clob;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author jwin
 *
 */
public class CommonUtility {
	
    public static Class<?> loadClass(String className) throws Exception {
		ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
		classLoader = (classLoader == null) ? ClassLoader.getSystemClassLoader() : classLoader;
		
    	Class<?> clazz = classLoader.loadClass(className);
        return (clazz == null) ? Class.forName(className) : clazz;
    }

    /*
	 *map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents list (
	 * 			map (
	 * 				String : 컬럼명,
	 * 				Object : 컬럼값
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasList(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Collection<Map<String, Object>> contents = new ArrayList<Map<String, Object>>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	
            	contents.add(m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}
	
	public static Map<String, Object> transMapToResultSet(ResultSet rs) throws Exception {
		ResultSetMetaData rsmd = null;
	  Collection<String> titles = new ArrayList<String>();
	  Map<String, Object> m = new HashMap<String, Object>();
	  
	  try {
		  rsmd = rs.getMetaData();
	    for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++){
	 			titles.add(rsmd.getColumnName(colIdx).toLowerCase());
	    	}
	    for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++){
	    	if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
					StringBuffer output = new StringBuffer();
					Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
					char[] buffer = new char[1024];
					int byteRead;
					while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
						output.append(buffer, 0, byteRead);
					}
					input.close();
					m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
				} else {
					m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
				}
	    	}
	    return m;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}
	
	/*
	 *map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents map (
	 * 			String : 키 컬럼값,
	 * 			map (
	 * 				String : 컬럼명,
	 * 				Object : 컬럼값
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasMap(ResultSet rs, String key_field) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	
            	contents.put(String.valueOf(m.get(key_field)), m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *		titles list (
	 * 			String : 키 컬럼값
	 * 		),
	 *		map (
	 *			String : 키  컬럼값,
	 *			Object : 값  컬럼값
	 * 		)
	 *)
	 */
	public static Map<String, Object> transDatasMap(ResultSet rs, String key_field, String value_field, boolean returnTitles) throws Exception {
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            while(rs.next()) {
            	contents.put(String.valueOf(rs.getObject(key_field)), rs.getObject(value_field));
            }
            
            titles.addAll(contents.keySet());
            
            data.put("titles", titles);
            data.put("contents", contents);

            return (returnTitles) ? data : contents;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *Map (
	 *		titles List (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents Map (
	 * 			String : 분류키  컬럼값,
	 * 			classified_data List (
	 * 				Map (
	 * 					String : 컬럼명,
	 * 					Object : 컬럼값
	 * 				)
	 * 			)
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDatasClassifiedList(ResultSet rs, String classify_key_field) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<Object, Object> contents = new HashMap<Object, Object>();

        try {
            rsmd = rs.getMetaData();

            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());
            
            while(rs.next()) {
            	Map<String, Object> m = new HashMap<String, Object>();

            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						m.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		m.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            	if(!contents.containsKey(m.get(classify_key_field)))
            		contents.put(m.get(classify_key_field), new ArrayList<Map<String, Object>>());
            	
            	((Collection<Object>) contents.get(m.get(classify_key_field))).add(m);
            }
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *		titles list (
	 * 			String : 컬럼명
	 * 		),
	 * 		contents map (
	 *			String : 컬럼명,
	 *			Object : 컬럼값
	 * 		)
	 * )
	 */
	public static Map<String, Object> transDataMap(ResultSet rs) throws Exception {
        ResultSetMetaData rsmd = null;
        
        Map<String, Object> data = new HashMap<String, Object>();
        Collection<String> titles = new ArrayList<String>();
        Map<String, Object> contents = new HashMap<String, Object>();

        try {
            rsmd = rs.getMetaData();
            
            for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
        		titles.add(rsmd.getColumnName(colIdx).toLowerCase());

            if(rs.next())
            	for (int colIdx = 1; colIdx <= rsmd.getColumnCount(); colIdx++)
            		if (rs.getObject(rsmd.getColumnName(colIdx)) instanceof Clob) {
						StringBuffer output = new StringBuffer();
						Reader input = rs.getCharacterStream(rsmd.getColumnName(colIdx));
						char[] buffer = new char[1024];
						int byteRead;
						while ((byteRead = input.read(buffer, 0, 1024)) != -1) {
							output.append(buffer, 0, byteRead);
						}
						input.close();

						/*
						BufferedReader reader = new BufferedReader(rs.getCharacterStream(rsmd.getColumnName(colIdx)));
						String line = null;
						StringBuffer text = new StringBuffer();
						while ((line = reader.readLine()) != null)
							text.append(line).append("\r\n");

						cf)
						Reader reader = new StringReader(data.getContent());
						pstmt.setCharacterStream(2, reader, data.getContent().length());
						*/
						
						contents.put(rsmd.getColumnName(colIdx).toLowerCase(), output.toString());
					} else {
	            		contents.put(rsmd.getColumnName(colIdx).toLowerCase(), rs.getObject(rsmd.getColumnName(colIdx)));
					}
            
            data.put("titles", titles);
            data.put("contents", contents);
            
            return data;
		} catch (SQLException e) {
			throw e;
		} finally {
		}
	}

	/*
	 *map (
	 *	String : 파라미터명,
	 *	Object : 파라미터값
	 * )
	 */
	public static Map<String, Object> transDataMap(HttpServletRequest request) throws Exception {
        Map<String, Object> parameters = new HashMap<String, Object>();

        try {
        	//java.lang.IllegalStateException: No modifications are allowed to a locked ParameterMap
        	/*
            Map<String, String[]> parameterMap = request.getParameterMap();
            for(String name : parameterMap.keySet()) {
            	String[] values = parameterMap.get(name);
            	parameters.put(name, values.length > 1 ? values : values[0]);
            }
        	 */
            for(Enumeration enumeration = request.getParameterNames(); enumeration.hasMoreElements();) {
            	String name = (String) enumeration.nextElement();
            	String[] values = request.getParameterValues(name); 
            	parameters.put(name, values.length > 1 ? values : values[0]);
            }
            return parameters;
		} catch (Exception e) {
			throw e;
		} finally {
		}
	}

	public static void setCookie(HttpServletResponse response, String name, String value) throws Exception {
		value = java.net.URLEncoder.encode(value.toString(),"UTF-8");
		Cookie cookie = new Cookie(name, value);
		cookie.setDomain("skylove.com"); 
		cookie.setPath("/");
		response.addCookie(cookie);
	}
	
	public static String getCookie(HttpServletRequest request, String CookieName) throws Exception {
		Cookie [] cookies = request.getCookies();
		if(cookies==null) return null;
		String value = "";
		for(int i=0;i<cookies.length;i++) {
			if(CookieName.equals(cookies[i].getName())) {
				value = java.net.URLDecoder.decode(cookies[i].getValue(),"UTF-8");
				break;
			}
		}
		return value;
	}
}
