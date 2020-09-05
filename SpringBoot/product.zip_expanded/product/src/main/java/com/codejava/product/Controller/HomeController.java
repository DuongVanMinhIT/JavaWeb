package com.codejava.product.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;



@Controller(value = "homeController")
public class HomeController {
	
	@RequestMapping(value = "/home/index", method = RequestMethod.GET)
	public String index() {
		return "home/index";
	}
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String indexH() {
		return "index";
	}
	
}
