package com.product.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.Dao.CategoryDao;
import com.product.entity.Category;

@Controller
public class CategoryManager {
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping("/admin/category/index")
	public String index(Model model,@ModelAttribute("entity")Category entity) {
		//Category entity = new Category();
		
		model.addAttribute("entity", entity);
		model.addAttribute("list", categoryDao.finAll());
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Category entity = categoryDao.findByid(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", categoryDao.finAll());
		
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/create")
	public String create(RedirectAttributes model, @ModelAttribute("entity")Category category) {
		categoryDao.create(category);
		model.addAttribute("message", "them moi thanh cong!");
		return "redirect:/admin/category/index";
	}
	@RequestMapping("/admin/category/update")
	public String update(RedirectAttributes model, @ModelAttribute("entity")Category category) {
		categoryDao.update(category);
		model.addAttribute("message", "cap nhap thanh cong!");
		return "redirect:/admin/category/edit/"+category.getId();
	}
	@RequestMapping(value= {"/admin/category/delete","/admin/category/delete/{id}"})
	public String detele(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1, 
			@PathVariable(value = "id", required = false)Integer id2) {
		Integer id = (id1 != null) ? id1 : id2;
		categoryDao.detele(id);
		model.addAttribute("message", "xoa thanh cong!");
		return "redirect:/admin/category/index";
	}
}
