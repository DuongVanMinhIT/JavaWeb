package com.product.Controller.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Serive.CartService;

@Controller
public class ShoppingCartController {
	@Autowired
	CartService cartService;
	@ResponseBody
	@RequestMapping("/cart/add/{id}")
	public Object[] ListByCategory(
			@PathVariable("id")Integer id, 
			Model model) {
		cartService.add(id);
		Object[] info = {cartService.getCount(),cartService.getAmount()};
		return info;
		
	}
	@ResponseBody
	@RequestMapping("/cart/remove/{id}")
	public Object[] remove(
			@PathVariable("id")Integer id, 
			Model model) {
		cartService.remove(id);
		Object[] info = {cartService.getCount(),cartService.getAmount()};
		return info;
		
	}
	@ResponseBody
	@RequestMapping("/cart/update/{id}/{qty}")
	public Object[] update(
			@PathVariable("id")Integer id,
			@PathVariable("qty")Integer qty,
			Model model) {
		cartService.update(id, qty);;
		Object[] info = {cartService.getCount(),cartService.getAmount()};
		return info;
		
	}
	
	
	@RequestMapping("/cart/view")
	public String view() {
		return "cart/view";
	}
	@ResponseBody
	@RequestMapping("/cart/clear")
	public void clear() {
		cartService.clear();
	}
	
}
