package com.asm.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.asm.DAO.accountDAO;
import com.asm.DAO.categoryDAO;
import com.asm.DAO.orderDAO;
import com.asm.DAO.orderDetailDAO;
import com.asm.DAO.productDAO;
import com.asm.entity.Account;
import com.asm.entity.Category;
import com.asm.entity.Order;
import com.asm.entity.OrderDetail;
import com.asm.entity.Product;
import com.asm.model.CategoryDTO;
import com.asm.model.ProductDTO;
import com.asm.model.accountDTO;

import lombok.experimental.PackagePrivate;

@Controller
public class AdminController {

	@Autowired
	categoryDAO cateDao;

	@Autowired
	accountDAO accDao;

	@Autowired
	productDAO proDao;
	
	@Autowired
	orderDAO orDao;
	
	@Autowired
	orderDetailDAO ordDao;

	@Autowired
	HttpServletRequest request;

	@Autowired
	HttpServletResponse response;

	// Category
	@GetMapping("/admin/category")
	public String AdCategoty(Model model) {
		List<Category> cate = cateDao.findAll();

		model.addAttribute("cate", cate);
		return "admin/homeAd/category";
	}

	@GetMapping("/admin/acc/infor")
	public String account(Model model) {

		HttpSession session = request.getSession();
		Account acc = (Account) session.getAttribute("acc");
		model.addAttribute("account", acc);
		return "admin/homeAd/inforAccount";
	}

	@GetMapping("/admin/edit/cates/{id}")
	public String editCate(@PathVariable("id") Integer id, Model model) {
		Optional<Category> cate = cateDao.findById(id);
		Category caEntity = cate.get();
		CategoryDTO dto = new CategoryDTO();
		BeanUtils.copyProperties(caEntity, dto);
		model.addAttribute("editcate", dto);
		return "admin/homeAd/category";
	}

	@PostMapping("admin/update/cates")
	public String update(Model model, @RequestParam(value = "CatesId", required = false) Integer id,
			@RequestParam("CatesName") String name) {
		CategoryDTO dto = new CategoryDTO();
		dto.setId(id);
		dto.setNameCa(name);
		Category category = new Category();
		BeanUtils.copyProperties(dto, category);

		cateDao.save(category);
		return "redirect:/admin/category";
	}

	@GetMapping("admin/del/cates/{id}")
	public String del(Model model, @PathVariable("id") Integer id) {
		List<Product> pro = proDao.findByCategoryId(id);
		Category category = new Category();
		category.setId(id);
		if (pro.isEmpty()) {
			cateDao.delete(category);
		} else {
			model.addAttribute("error", "Danh mục còn sản phẩm không thể xóa");
		}
		return "redirect:/admin/category";
	}

	// Product
	@GetMapping("/admin/productAdd")
	public String productAdd(Model model) {
		List<Category> proCategory = cateDao.findAll();
		model.addAttribute("proCa", proCategory);

		List<Product> pro = proDao.findAll();
		model.addAttribute("proStatus", pro);
		return "admin/homeAd/ProductAdd";
	}

	@GetMapping("/admin/product")
	public String pro(Model model) {
		List<Product> pro = proDao.findAll();
		model.addAttribute("pro", pro);

		return "admin/homeAd/productList";
	}

	@GetMapping("product/edit/{id}")
	public String editPro(Model model, @PathVariable("id") Integer id) {

		Optional<Product> pro = proDao.findById(id);
		Product proEntity = pro.get();
		model.addAttribute("product", proEntity);

		return "admin/homeAd/ProductAdd";
	}

	@PostMapping("/admin/product/update")
	public String updatePro(Model model, ProductDTO proDto) {
		Product p = new Product();
		if (proDto.getId() == null) {
			BeanUtils.copyProperties(proDto, p); 
			p.setCreateDate(new Date());
			p.setCategory(cateDao.findById(proDto.getCateId()).get());
			proDao.save(p);
		} else {
			BeanUtils.copyProperties(proDto, p);
			p.setCategory(cateDao.findById(proDto.getCateId()).get());
			proDao.save(p);
		}

		return "redirect:/admin/product";
	}
	
	@GetMapping("admin/del/pro/{id}")
	public String delPro(Model model, @PathVariable("id") Integer id) {
		Optional<Product> pro = proDao.findById(id);
		proDao.delete(pro.get());
		
		return "redirect:/admin/product";
	}

	@GetMapping("/product/infor/{id}")
	public String inforPro(Model model,@PathVariable("id") Integer id) {
		Optional<Product> pro = proDao.findById(id);
		Product entity = pro.get();
		
		model.addAttribute("infor", entity);
		
		return "admin/homeAd/infor";
	}
	
	// Account

	@GetMapping("admin/accountAdd")
	public String accAdd(Model model) {
		List<Account> accAdd = accDao.findAll();
		
		model.addAttribute("statusAcc", accAdd);
		return "admin/homeAd/accountAdd";
}
	
	
	@GetMapping("admin/account")
	public String acc(Model model) {
		List<Account> acc = accDao.findAll();

		model.addAttribute("acc", acc);

		return "admin/homeAd/accountList";
	}

	@GetMapping("account/edit/{id}")
	public String editAcc(@PathVariable("id") Integer id, Model model) {

		Optional<Account> acc = accDao.findById(id);
		Account accEntity = acc.get();
		accountDTO dto = new accountDTO();
		BeanUtils.copyProperties(accEntity, dto);
		model.addAttribute("account", dto);

		return "admin/homeAd/accountAdd";
	}
	
	@GetMapping("/account/delete/{id}")
	public String delAcc(Model model, @PathVariable("id") Integer id) {
		Optional<Account> acc = accDao.findById(id);
		accDao.delete(acc.get());
		
		return "redirect:/admin/account";
	}
	
	@PostMapping("account/update")
	public String updateAcc(Model model, accountDTO accDto) {
		Account acc = new Account();
			BeanUtils.copyProperties(accDto, acc);
			accDao.save(acc);
		return "redirect:/admin/account";
	}
	
	//Order
	
	@GetMapping("/admin/order")
	public String order(Model model) {
		List<Order> order = orDao.findAll();
		
		model.addAttribute("order", order);
		return"admin/homeAd/order";
	}
	
	@GetMapping("/admin/order/{id}")
	public String inforOr(@PathVariable("id")Integer id,Model model) {
		List<OrderDetail> orAd = ordDao.findByOrderId(id);
		model.addAttribute("orAd", orAd);
		return "admin/homeAd/inforOd";
	}
	
	@PostMapping("/order/updateStatus")
	public String updateStatus(Model model,@RequestParam("status") Integer status,@RequestParam("id") Integer id) {
		Optional<Order> or = orDao.findById(id);
		Order orEntity = or.get();
		orEntity.setStatus(status);
		orDao.save(orEntity);
		return"redirect:/admin/order";
	}
	
	@GetMapping("/admin/order/remove/{id}")
	public String removeOr(@PathVariable("id")Integer id,Model model) {
		orDao.deleteById(id);
		return "redirect:/admin/order";
	}
}
