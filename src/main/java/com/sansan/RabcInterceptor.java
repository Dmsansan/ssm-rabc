package com.sansan;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.security.rabc.authority.AuthorityDicede;
import com.neusoft.security.rabc.entity.UserDetailsInfo;
import com.sansan.service.UserResourceInterface;
import com.sansan.service.impl.NuesoftUserResource;


public class RabcInterceptor implements HandlerInterceptor{
	public String[] staticUrls;
	
	public void setStaticUrls(String[] staticUrls) {
		this.staticUrls = staticUrls;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		boolean arg = true;
		
		UserResourceInterface userResourceInterface = new NuesoftUserResource();
		//用户信息
		UserDetailsInfo userDetailsInfo = userResourceInterface.setUserInfo();
		
		//登录账号资源getUserResource
		List<HashMap<String, String>> userResource = userResourceInterface.setUserResource();
		
		AuthorityDicede authorityDicede  = new AuthorityDicede();
		
		arg  = authorityDicede.userAuthorityDicede(request, response, userResource, userDetailsInfo, staticUrls);

		return arg;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		
	}

}
