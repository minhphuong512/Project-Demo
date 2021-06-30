package com.asm.interceptors;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.asm.DAO.categoryDAO;
import com.asm.DAO.productDAO;
import com.asm.entity.Category;


@Component
public class ShareInterceptor implements HandlerInterceptor {

	@Autowired
	categoryDAO caDao;
	
	@Autowired
	productDAO productDAO;
	
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws IOException {
		
		try {
			
			List<Category> cate = caDao.findAll();
			modelAndView.addObject("cate", cate);
		} catch (Exception e) {
			System.out.println("Bug Interceptor Model and views null");
		}
		
			
	}
	
}
