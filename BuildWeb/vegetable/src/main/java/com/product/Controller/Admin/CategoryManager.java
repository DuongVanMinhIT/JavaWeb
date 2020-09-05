package com.product.Controller.Admin;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.dao.ICategoryDao;
import com.product.entity.Category;

@Controller
public class CategoryManager {
	@Autowired
	private ICategoryDao caoCategoryDao;
	
	@RequestMapping("/admin/category/index")
	public String index(Model model,
			@ModelAttribute("entity")Category entity) {
		model.addAttribute("entity", entity);
		model.addAttribute("list", caoCategoryDao.findAll());
		return "admin/category/index";
	}
	
	@RequestMapping("/admin/category/create")
	public String create(RedirectAttributes model,
			@ModelAttribute("entity")Category entity) {
		caoCategoryDao.create(entity);
		model.addAttribute("message", "add successFully");
		return "redirect:/admin/category/index";
	}
	@RequestMapping("/admin/category/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Category entity = caoCategoryDao.findById(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", caoCategoryDao.findAll());
		return "admin/category/index";
	}
	@RequestMapping("/admin/category/update")
	public String update(RedirectAttributes model,
			@ModelAttribute("entity")Category entity) {
		caoCategoryDao.update(entity);
		model.addAttribute("message", "update successFully");
		return "redirect:/admin/category/edit/"+ entity.getId();
	}
	@RequestMapping(value = {"/admin/category/delete/{id}" , "/admin/category/delete"})
	public String delete(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1,
			@PathVariable(value ="id", required = false)Integer id2) {
		Integer id = (id1 != null) ? id1 : id2;
		caoCategoryDao.delete(id);
		model.addAttribute("message", "delete successFully");
		return "redirect:/admin/category/index";
	}
	
	
	
}
