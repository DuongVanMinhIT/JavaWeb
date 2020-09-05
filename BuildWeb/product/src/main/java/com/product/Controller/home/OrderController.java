package com.product.Controller.home;



import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.Dao.OrderDao;
import com.product.Dao.OrderDetailDao;
import com.product.Serive.CartService;
import com.product.entity.Customer;
import com.product.entity.Order;
import com.product.entity.OrderDetail;
import com.product.entity.Product;

@Controller
public class OrderController {
	@Autowired
	HttpSession session;
	@Autowired
	CartService cartService;
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	
	
	@RequestMapping("/order/checkout")
	public String Show(@ModelAttribute("order")Order order) {
		Customer user = (Customer) session.getAttribute("user");
		order.setOrderDate(new Date());
		order.setCustomer(user);
		order.setAmount(cartService.getAmount());
		return "order/checkout";
	}
	@PostMapping("/order/checkout")
	public String purchase(
			Model model,
			@ModelAttribute("order")Order order) {
		//lay list tu cart session
		Collection<Product> list = cartService.getItmes();
		List<OrderDetail> details = new ArrayList<>();
		for (Product p : list) {
			OrderDetail detail = new OrderDetail();
			detail.setOrders(order);
			detail.setProduct(p);
			detail.setUnitPrce(p.getUnitPrice());
			detail.setQuantity(p.getQuantity());
			detail.setDiscount(p.getDiscount());
			details.add(detail);
		}
		orderDao.create(order, details);
		cartService.clear();
		
		return "redirect:/order/list";
	}
	
	@RequestMapping("/order/list")
	public String list(Model model) {
		Customer user = (Customer) session.getAttribute("user");
		List<Order> list = orderDao.finByUser(user);
		model.addAttribute("orders", list);
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String list(Model model,
			@PathVariable("id")Integer id) {
		Order order = orderDao.findByid(id);
		List<OrderDetail> details = orderDetailDao.findByOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("details", details);
		return "order/detail";
	}
	
	
}
