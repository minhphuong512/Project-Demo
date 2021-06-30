package com.asm.interceptors;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.asm.entity.Account;

@Component
public class AdminInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(
		HttpServletRequest request,
		HttpServletResponse response,
		Object handler
	) throws IOException {
		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		
		if (acc.getAdmin() != 1) {
			response.sendRedirect( request.getContextPath() + "/user/product/page?p=0" );
			return false;
		}
		
		return true;
	}
}
