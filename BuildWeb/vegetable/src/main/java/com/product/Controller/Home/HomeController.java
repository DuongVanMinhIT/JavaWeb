package com.product.Controller.Home;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.dao.IProductDao;
import com.product.entity.Product;

@Controller
public class HomeController {
	@Autowired
	IProductDao productDao;
	
	@RequestMapping("/home/index")
	public String index(Model model) {
		List<Product> listProduct = productDao.findAll();
		model.addAttribute("listProduct", listProduct);
		return "home/index";
	}
	
	
}
