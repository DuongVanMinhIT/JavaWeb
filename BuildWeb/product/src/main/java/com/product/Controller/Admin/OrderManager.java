package com.product.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.Dao.OrderDao;
import com.product.Dao.OrderDetailDao;
import com.product.entity.Order;;

@Controller
public class OrderManager {
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
	@RequestMapping("/admin/Order/index")
	public String index(Model model) {
		Order entity = new Order();
		
		model.addAttribute("entity", entity);
		model.addAttribute("details", orderDetailDao.findByOrder(entity));
		model.addAttribute("list", orderDao.finAll());
		return "admin/Order/index";
	}
	
	@RequestMapping("/admin/Order/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Order entity = orderDao.findByid(id);
		model.addAttribute("entity", entity);
		model.addAttribute("details", orderDetailDao.findByOrder(entity));
		model.addAttribute("list", orderDao.finAll());
		
		return "admin/Order/index";
	}
	
	@RequestMapping("/admin/Order/create")
	public String create(RedirectAttributes model, @ModelAttribute("entity")Order Order) {
		orderDao.create(Order);
		model.addAttribute("message", "them moi thanh cong!");
		return "redirect:/admin/Order/index";
	}
	@RequestMapping("/admin/Order/update")
	public String update(RedirectAttributes model, @ModelAttribute("entity")Order Order) {
		orderDao.update(Order);
		model.addAttribute("message", "cap nhap thanh cong!");
		return "redirect:/admin/Order/edit/"+Order.getId();
	}
	@RequestMapping(value= {"/admin/Order/delete","/admin/Order/delete/{id}"})
	public String detele(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1, 
			@PathVariable(value = "id", required = false)Integer id2) {
		Integer id = (id1 != null) ? id1 : id2;
		orderDao.detele(id);
		model.addAttribute("message", "xoa thanh cong!");
		return "redirect:/admin/Order/index";
	}
}
