package inters;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.neusoft.security.rabc.ResorceBean.ResourceBean;
import com.neusoft.security.rabc.implents.NeusoftRabc;

public class RabcInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		boolean arg = true;
		ResourceBean resourceBean = new ResourceBean();
		NeusoftRabc neusoftRabc   = new NeusoftRabc();
		//用户访问资源从数据库获取
		List<ResourceBean> userResource = new ArrayList<>(); 
		resourceBean.setUrl("/rabc/resourceTest");
		resourceBean.setMethod("ALL");
		userResource.add(resourceBean);
		
		arg = neusoftRabc.hasPermission(request,userResource);

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
