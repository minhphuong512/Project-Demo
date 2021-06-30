package com.asm.controller;



import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.DAO.categoryDAO;
import com.asm.DAO.orderDetailDAO;
import com.asm.DAO.productDAO;
import com.asm.entity.Account;
import com.asm.entity.Product;


@Controller
public class HomeController {

	@Autowired
	categoryDAO cateDao;
	
	@Autowired
	productDAO proDAO;
	
	@Autowired
	orderDetailDAO orDao;
	
	@Autowired
	HttpServletRequest request;
	
	
	@GetMapping("/user/home")
	public String Home(Model model) {

		List<Product> pro = proDAO.findAll();
		model.addAttribute("list",pro);
		
		return "user/product";
	}
	
	@GetMapping("user/product/page")
	public String page(Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),5);
		Page<Product> page = proDAO.findAll(pageable);
		model.addAttribute("list", page);
		return "user/product";
	}
	
	@GetMapping("/admin/index")
	public String Admin(Model model) {
		
		
		return "admin/homeAd/index";
	}
	
	@PostMapping("/user/search")
	public String Searh( @RequestParam("search") String search,Model model) {
		List<Product> proSr = proDAO.findByName(search);
		
		model.addAttribute("proSr", proSr);
		return "user/search";
	}
	
	@GetMapping("/user/acc/infor")
	public String AccUser(Model model) {
		Account acc = (Account) request.getSession().getAttribute("acc");
		model.addAttribute("account", acc);
		return "user/inforAccUser";
	}
	
}
