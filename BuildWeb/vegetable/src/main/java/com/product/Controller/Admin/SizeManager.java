package com.product.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.dao.ISizeDao;
import com.product.entity.Size;

@Controller
public class SizeManager {
	@Autowired
	private ISizeDao sizeDao;
	
	@RequestMapping("/admin/size/index")
	public String index(Model model,
			@ModelAttribute("entity")Size entity) {
		model.addAttribute("entity", entity);
		model.addAttribute("list", sizeDao.findAll());
		return "admin/size/index";
	}
	
	@RequestMapping("/admin/size/create")
	public String create(RedirectAttributes model,
			@ModelAttribute("entity")Size entity) {
		sizeDao.create(entity);
		model.addAttribute("message", "add successFully");
		return "redirect:/admin/size/index";
	}
	@RequestMapping("/admin/size/edit/{id}")
	public String Size(Model model,
			@PathVariable("id")Integer id) {
		Size entity = sizeDao.findById(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", sizeDao.findAll());
		return "admin/size/index";
	}
	@RequestMapping("/admin/size/update")
	public String update(RedirectAttributes model,
			@ModelAttribute("entity")Size entity) {
		sizeDao.update(entity);
		model.addAttribute("message", "update successFully");
		return "redirect:/admin/size/edit/"+ entity.getId();
	}
	@RequestMapping(value = {"/admin/size/delete/{id}" , "/admin/Size/delete"})
	public String delete(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1,//RequestParam get id to form
			@PathVariable(value ="id", required = false)Integer id2) {//PathVariable get id to url
		Integer id = (id2 != null) ? id2 : id1;
		sizeDao.delete(id);
		model.addAttribute("message", "delete successFully");
		return "redirect:/admin/size/index";
	}
	
	
	
}
