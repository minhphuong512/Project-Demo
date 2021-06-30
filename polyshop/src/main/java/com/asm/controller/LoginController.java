package com.asm.controller;

import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.DAO.accountDAO;
import com.asm.DAO.cartItemDAO;
import com.asm.entity.Account;

@Controller

public class LoginController {

	@Autowired
	accountDAO accDAO;
	
	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;
	
	@Autowired
	cartItemDAO itemDao;

	@GetMapping("/login")
	public String login() {
		return "/layout/form/login";
	}

	@PostMapping("/login")
	public String lg( @RequestParam("username") String username, @RequestParam("password") String password) {
		Account acc = accDAO.findByAcc(username, password);
		if (acc == null) {
			request.getSession().setAttribute("error", "Thông tin sai");
			return "redirect:/login";
		} else {
			request.getSession().setAttribute("acc", acc);
			if (acc.getAdmin() == 1) {
				return "redirect:/admin/index";
			} else {
				return "redirect:/user/product/page?p=0";
			}

		}

	}
	
	@GetMapping("/logout")
	public String lo() {
		itemDao.clean();
		request.getSession().setAttribute("acc",null);
		return "redirect:/login";
	}
}
