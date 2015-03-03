<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<%@ page import="org.springframework.security.core.context.SecurityContextHolder" %>
<%@ page import="org.springframework.security.core.Authentication" %>
<%@ page import="com.bigcho.mps.support.security.entity.User" %>

<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Object principal = auth.getPrincipal();
String name = "";
String userId = "";
if(principal != null && principal instanceof User){
	name = ((User)principal).getName();
	userId = ((User)principal).getUserId();
}
%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<c:set var="resourcePath" value="${pageContext.request.contextPath}/resources" />

<!-- init Script -->
<script type="text/javascript">
	if (!window.mps) {
 		window.mps = {
 			contextPath : '${contextPath}',
 			resourcePath : '${resourcePath}'
 		}
 	}
</script>