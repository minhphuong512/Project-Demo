package com.asm.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.asm.DAO.orderDAO;
import com.asm.DAO.orderDetailDAO;
import com.asm.entity.Account;
import com.asm.entity.Order;
import com.asm.entity.OrderDetail;

@Controller
public class historyController {
	
	@Autowired
	orderDAO orDao;
	
	@Autowired
	HttpServletRequest request;
	
	@Autowired
	orderDetailDAO ordDao;
	
	@GetMapping("/user/history")
	public String history(Model model) {
		Account acc = (Account) request.getSession().getAttribute("acc");
		List<Order> order = orDao.findByOrder(acc.getId());
		
		model.addAttribute("order", order);
		return"user/history";
	}
	
	@GetMapping("/user/pro/order/{id}")
	public String inforOr(@PathVariable("id")Integer id,Model model) {
		List<OrderDetail> ord = ordDao.findByOrderId(id);
		model.addAttribute("ord", ord);
		return "user/inforHistory";
	}
	
	@GetMapping("/user/history/remove/{id}")
	public String removeOr(@PathVariable("id")Integer id,Model model) {
		orDao.deleteById(id);
		return "redirect:/user/history";
	}
}
