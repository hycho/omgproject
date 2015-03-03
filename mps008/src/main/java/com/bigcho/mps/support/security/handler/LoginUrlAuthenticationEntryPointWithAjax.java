package com.bigcho.mps.support.security.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.LoginUrlAuthenticationEntryPoint;

public class LoginUrlAuthenticationEntryPointWithAjax extends LoginUrlAuthenticationEntryPoint {
	
	// 세팅에서 넘겨줄 errorpage
	private String errorPage;
	
	public void setErrorPage(String errorPage) {
		if ((errorPage != null) && !errorPage.startsWith("/")) {
			throw new IllegalArgumentException("errorPage must begin with '/'");
		}
		this.errorPage = errorPage;
	}
	
	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

		String redirectUrl = null;
		String ajaxHeader = request.getHeader("X-Ajax-call"); // Ajax로 호출한 서비스인지 확인 한다.
		String result = "";
		
		response.setStatus(HttpServletResponse.SC_FORBIDDEN);
		response.setCharacterEncoding("UTF-8");
		redirectUrl = buildRedirectUrlToLoginPage(request, response, authException);
	
		if(ajaxHeader == null) { //만약 null일경우 ajax가 아닌 일반 Url호출을 통해 접근을 했다는 것을 의미 한다.
			request.getRequestDispatcher(errorPage).forward(request, response);
		} else { //Ajax호출일경우
			if("true".equals(ajaxHeader)) { //ajax접근
				result = "{\"result\" : \"fail\", \"message\" : \"" + authException.getMessage() + "\", \"redirectUrl\" : \""+redirectUrl+"\"}";
			} else { //X-Ajax-call해더 변수가 있지만 우리가 선언해서 호출한 ajax호출이 아니다.
				result = "{\"result\" : \"fail\", \"message\" : \"Access Denied(Header Value Mismatch)\", \"redirectUrl\" : \""+redirectUrl+"\"}";
			}
			response.getWriter().print(result);
			response.getWriter().flush();
		}
	}
}
