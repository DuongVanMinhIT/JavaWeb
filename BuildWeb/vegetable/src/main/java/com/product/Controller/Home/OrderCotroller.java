package com.product.Controller.Home;

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

import com.product.Serive.CartService;
import com.product.Serive.SizeService;
import com.product.dao.IOrderDao;
import com.product.dao.IOrderDetailDao;
import com.product.entity.Customer;
import com.product.entity.Order;
import com.product.entity.OrderDetail;
import com.product.entity.Product;

@Controller
public class OrderCotroller {
	@Autowired
	HttpSession session;
	@Autowired
	CartService cartService;
	@Autowired
	IOrderDao orderDao;
	@Autowired
	IOrderDetailDao orderDetailDao;
	@Autowired 
	SizeService sizeService;
	
	
	
	
	
	@RequestMapping("/order/checkout")
	public String Show(@ModelAttribute("order")Order order) {
		Customer user = (Customer) session.getAttribute("user");
		order.setOrderDate(new Date());
		order.setCustomer(user);
		order.setAmount(cartService.getAmount());
		return "order/checkout";
	}
	@PostMapping("/order/checkout")
	public String puchase(Model model, @ModelAttribute("order")Order order) {
			Collection<Product> list = cartService.getItems();
			Collection<Product> listSize = sizeService.getItems();
			List<OrderDetail> details = new ArrayList<>();  
			for (Product p : list) {
				OrderDetail detail = new OrderDetail();				
				detail.setOrder(order);
				detail.setProduct(p);
				detail.setUnitPrice(p.getUnitPrice());
				detail.setQuantity(p.getQuantity());
				detail.setDiscount(p.getDiscount());
				for (Product product : listSize) {
					if(p.getId() == product.getId()) {
						detail.setSize(product.getSizes());
						break;
					}
				}
				details.add(detail);
			}
			orderDao.create(order, details);
		    cartService.clear();
		    sizeService.clear();
		    return "redirect:/order/list";
	}

	
	
	@RequestMapping("/order/list")
	public String List(Model model) {
		Customer user = (Customer) session.getAttribute("user");
		List<Order> list = orderDao.findByUser(user);
		model.addAttribute("orders", list);
		return "order/list";
	}
	@RequestMapping("/order/detail/{id}")
	public String list(Model model,
			@PathVariable("id")Integer id) {
		Order order = orderDao.findById(id);
		List<OrderDetail> details = orderDetailDao.findByOrder(order);
		model.addAttribute("order", order);
		model.addAttribute("details", details);
		return "order/detail";
	}
	
	
   
	
}
