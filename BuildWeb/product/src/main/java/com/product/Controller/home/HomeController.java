package com.product.Controller.home;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;



@Controller
public class HomeController {
//	@Autowired
//	private CategorySerice categorySerice;
	
	@RequestMapping("/home/index")
	public String index() {
		
		return "home/index";
	}
	@RequestMapping("/home/contact")
	public String contact( ) {
		
		return "home/contact";
	}
	@RequestMapping("/home/faq")
	public String faq() {
		
		return "home/faq";
	}
	@ResponseBody
	@RequestMapping("/home/language")
	public void languege() {
	}
	
}
