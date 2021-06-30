package com.asm.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.asm.DAO.categoryDAO;
import com.asm.DAO.productDAO;
import com.asm.entity.Account;
import com.asm.entity.Category;
import com.asm.entity.Product;
import com.asm.model.ProductDTO;





@Controller
public class ProductController {
	
	@Autowired
		productDAO productDAO;
	
	@Autowired
	categoryDAO catesDAO;
	
	@GetMapping("/product/list-category/{id}")
	public String listByCategory(@PathVariable(name = "id") Integer CatesId,Model model,@RequestParam("p") Optional<Integer> p) {
		Pageable pageable = PageRequest.of(p.orElse(0),5);
		Page<Product> list = productDAO.findByCaIdOrPage(CatesId, pageable);
		model.addAttribute("list",list);
		model.addAttribute("ctID",CatesId);
		return "user/product";
	}
	
	@GetMapping("/user/search/{name}")
	public String search(Model model,@PathVariable("name")String name) {
		List<Product> list = productDAO.findByName(name);
		model.addAttribute("list",list);
		
		return "user/Search";
	}
	
	@GetMapping("/user/product/infor/{id}")
	public String inforPro(Model model,@PathVariable("id") Integer id) {
		Optional<Product> pro = productDAO.findById(id);
		Product entity = pro.get();
		
		model.addAttribute("infor", entity);
		
		return "user/inforUsPr";
	}
	
	
}
