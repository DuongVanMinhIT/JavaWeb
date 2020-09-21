package com.product.Controller.Home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Serive.CartService;
import com.product.Serive.SizeService;
import com.product.dao.ISizeDao;
import com.product.entity.Size;

@Controller
public class ShoppingCartController {
	@Autowired
	CartService cartService;
	@Autowired
	ISizeDao sizeDao;
	@Autowired
	SizeService sizeService;
	
	@ResponseBody
	@RequestMapping("cart/add/{id}")
	public Object[] listByCategory(
			@PathVariable("id")Integer id,
			Model model) {
		cartService.add(id);
		sizeService.add(id, 1);
		Object[] info = {cartService.getCount(), cartService.getAmount()};
		return info;
	}
	@ResponseBody
	@RequestMapping("/cart/update/{id}/{qty}")
	public Object[] updateCart(@PathVariable("id")Integer id,
			@PathVariable("qty")Integer qty) {
			cartService.update(id, qty);		
		Object[] info = {cartService.getCount(), cartService.getAmount()};
		return info;
	}
	
	@ResponseBody
	@RequestMapping("/cart/updatePrice/{id}/{price}")
	public Object[] updateCartPrice(@PathVariable("id")Integer id,
			@PathVariable("price")Float price) {		
	    cartService.update(id, price);
		Object[] info = {cartService.getCount(), cartService.getAmount()};
		return info;
	}
	
	@RequestMapping("/cart/view")
	public String view(Model model) {
	    List<Size> listSize = sizeDao.findAll();
		model.addAttribute("listDao", listSize);	
		return "cart/view";
	}
	@ResponseBody
	@RequestMapping("/cart/remove/{id}")
	public Object[] removeId(@PathVariable("id")Integer id) {
		cartService.remove(id);
		Object[] info = {cartService.getCount(),cartService.getAmount()};
	 return info;
	}
	
	
	@ResponseBody
	@RequestMapping("/cart/clear")
	public void clear() {
		cartService.clear();
	}
	

}
