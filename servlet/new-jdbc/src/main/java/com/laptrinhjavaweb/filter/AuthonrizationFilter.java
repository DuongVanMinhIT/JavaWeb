package com.laptrinhjavaweb.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.laptrinhjavaweb.controller.constant.SystemConstant;
import com.laptrinhjavaweb.model.UserModel;
import com.laptrinhjavaweb.utils.SessionUtil;

public class AuthonrizationFilter implements Filter{
	
	private ServletContext context;
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		this.context = filterConfig.getServletContext();
	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) servletRequest;
		HttpServletResponse resp = (HttpServletResponse) servletResponse;
		String url = req.getRequestURI();//lay link 
		if(url.startsWith("/admin")) {
			System.out.println("true");
		}else {
			System.out.println("fale");
		}
		
		if(url.startsWith("/admin")) {
			UserModel model = (UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL");
		
			if(model != null ) {
				if(model.getRoleModel().getCode().equals(SystemConstant.ADMIN)) {
					chain.doFilter(servletRequest, servletResponse);
				}else if(model.getRoleModel().getCode().equals(SystemConstant.USER)){
					resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_permission&alter=danger");
				}
			} else {
				resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=not_login&alter=danger");
			}
		}else {
			chain.doFilter(servletRequest, servletResponse);
		}
		
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
