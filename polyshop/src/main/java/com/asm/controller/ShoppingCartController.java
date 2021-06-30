package com.asm.controller;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.DAO.cartItemDAO;
import com.asm.DAO.orderDAO;
import com.asm.DAO.orderDetailDAO;
import com.asm.DAO.productDAO;
import com.asm.entity.Account;
import com.asm.entity.Order;
import com.asm.entity.OrderDetail;
import com.asm.entity.Product;
import com.asm.model.CartItem;
import com.asm.model.orderDTO;
import com.asm.model.orderDetailDTO;

@Controller
public class ShoppingCartController {
	
	@Autowired
	productDAO proDAO;
	
	@Autowired
	cartItemDAO ItemDao;
	

	@Autowired
	orderDAO orderDAO;
	@Autowired
	orderDetailDAO orderDetailDAO;
	
	@Autowired
	HttpServletRequest request;
	
	
	
	
	
	
	
	
	@PostMapping("/item/shoppingCart/save")
	public String list2(Model model,@RequestParam("address") String address,@RequestParam("email") String email) {
		Account acc = (Account) request.getSession().getAttribute("acc");
		Order or =  new Order();
		or.setAccount(acc);
		or.setAddress(address);
		or.setAmount( ItemDao.getAmount());
		or.setStatus(1);
		orderDAO.save(or);
		for(CartItem i : ItemDao.getCartItem()) {
			OrderDetail del = new OrderDetail();
			Product p = new Product();
			BeanUtils.copyProperties(i, p);
			del.setPrice(p.getPrice());
			del.setQuantity(p.getQuantity());
			del.setOrder(or);
			del.setProduct(p);
			orderDetailDAO.save(del);
		}
		ItemDao.clean();
		
		return "user/shoppingCart";
	}
	
	@GetMapping("/item/shoppingCart")
	public String list(Model model) {
		model.addAttribute("cardItems", ItemDao.getCartItem());
		model.addAttribute("total",ItemDao.getAmount());
		model.addAttribute("NoOfItem",ItemDao.getCount());
		
		return "user/shoppingCart";
	}
	
	@GetMapping("/shoppingCart/add/{id}")
	public String shop( Integer ctID, Model model,@PathVariable(name = "id") Integer ProId) {	
		Optional<Product> pro = proDAO.findById(ProId);
		Product proEntity = pro.get();
		CartItem cart = new CartItem();
		BeanUtils.copyProperties(proEntity, cart);
		cart.setQuantity(1);
		ItemDao.add(cart);
		model.addAttribute("cartItem",cart);
		if(ctID == null) {
			return "redirect:/user/product/page?p=0";
		}else {
			return "redirect:/product/list-category/"+ctID;
		}
	}
	
	
	@GetMapping("/shoppingCart/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		ItemDao.remove(id);
		return "redirect:/item/shoppingCart";
	}
	
	@PostMapping("/shoppingCart/update")
	public String Plus(Model model,@RequestParam("id") Integer id,@RequestParam("qty")Integer qty) {
			ItemDao.update(id, qty);
		return "redirect:/item/shoppingCart";
	}
}
