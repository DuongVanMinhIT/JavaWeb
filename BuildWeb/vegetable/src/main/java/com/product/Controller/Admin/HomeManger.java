package com.product.Controller.Admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeManger {
	
	@RequestMapping("/admin/home/index")
	public String index() {
		return "admin/home/index";
	}
}
