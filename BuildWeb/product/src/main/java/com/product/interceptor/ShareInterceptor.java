package com.product.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.product.Dao.CategoryDao;
import com.product.entity.Category;

@Component
public class ShareInterceptor extends HandlerInterceptorAdapter{
	@Autowired
	CategoryDao dao;
	
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		List<Category> listCategory = dao.finAll();
		request.setAttribute("cates", listCategory);
	}
}
