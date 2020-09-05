package com.product.Controller.Admin;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.Dao.ProductDao;
import com.product.entity.Product;

@Controller
public class ProductManager {
	@Autowired
	ProductDao productDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("/admin/product/index")
	public String index(Model model) {
		Product entity = new Product();
		
		model.addAttribute("entity", entity);
		model.addAttribute("list", productDao.finAll());
		return "admin/product/index";
	}
	@RequestMapping("/admin/product/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Product entity = productDao.findByid(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", productDao.finAll());
		
		return "admin/product/index";
	}
	
	@RequestMapping("/admin/product/create")
	public String create(RedirectAttributes model,
			@ModelAttribute("entity")Product product,
			@RequestParam("image_file")MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			product.setImage("person-img.png");
		}else {
			product.setImage(file.getOriginalFilename());
			String path = app.getRealPath("/static/images/products/"+ product.getImage());
			file.transferTo(new File(path));
		}
		productDao.create(product);
		model.addAttribute("message", "them moi thanh cong!");
		return "redirect:/admin/product/index";
	}
	@RequestMapping("/admin/product/update")
	public String update(RedirectAttributes model, 
			@ModelAttribute("entity")Product product,
			@RequestParam("image_file")MultipartFile file) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			product.setImage(file.getOriginalFilename());
			String path = app.getRealPath("/static/images/products/"+ product.getImage());
			file.transferTo(new File(path));
		}
		productDao.update(product);
		model.addAttribute("message", "cap nhap thanh cong!");
		return "redirect:/admin/product/edit/"+product.getId();
	}
	@RequestMapping(value= {"/admin/product/delete","/admin/product/delete/{id}"})
	public String detele(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1, 
			@PathVariable(value = "id", required = false)Integer id2) {
		Integer id = (id1 != null) ? id1 : id2;
		productDao.detele(id);
		model.addAttribute("message", "xoa thanh cong!");
		return "redirect:/admin/product/index";
	}
}
