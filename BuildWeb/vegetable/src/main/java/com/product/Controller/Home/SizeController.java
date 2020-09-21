package com.product.Controller.Home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Serive.SizeService;

@Controller
public class SizeController {
	@Autowired
	SizeService sizeService;

	@ResponseBody
	@RequestMapping("/cart/add-size/{id}/{size}")
	public void addBySize(@PathVariable("id")Integer id,
			@PathVariable("size")Integer size) {
		sizeService.add(id,size);
	}

}
