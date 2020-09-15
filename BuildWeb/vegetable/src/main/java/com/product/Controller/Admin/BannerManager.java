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

import com.product.dao.IBannerDao;
import com.product.entity.Banner;

@Controller
public class BannerManager {
	@Autowired
	private IBannerDao bannerDao;
	@Autowired
	private ServletContext app;
	
	@RequestMapping("/admin/banner/index")
	public String index(Model model,
			@ModelAttribute("entity")Banner entity) {
		model.addAttribute("entity", entity);
		model.addAttribute("list", bannerDao.findAll());
		return "admin/banner/index";
	}
	
	@RequestMapping("/admin/banner/create")
	public String create(RedirectAttributes model,
			@ModelAttribute("entity")Banner entity,
			@RequestParam("image_banner")MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			entity.setLinkImage("noimage.png");
		}else {
			entity.setLinkImage(file.getOriginalFilename());
			String path = app.getRealPath("/static/product/image/" + entity.getLinkImage());
			file.transferTo(new File(path));
		}
		bannerDao.create(entity);
		model.addAttribute("message", "add successFully");
		return "redirect:/admin/banner/index";
	}
	@RequestMapping("/admin/banner/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Banner entity = bannerDao.findById(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", bannerDao.findAll());
		return "admin/banner/index";
	}
	@RequestMapping("/admin/banner/update")
	public String update(RedirectAttributes model,
			@ModelAttribute("entity")Banner entity,
			@RequestParam("image_banner")MultipartFile file) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			entity.setLinkImage(file.getOriginalFilename());
			String path = app.getRealPath("/static/product/image/" + entity.getLinkImage());
			file.transferTo(new File(path));
		}
		bannerDao.update(entity);
		model.addAttribute("message", "update successFully");
		return "redirect:/admin/banner/edit/"+ entity.getId();
	}
	@RequestMapping(value = {"/admin/banner/delete/{id}" , "/admin/banner/delete"})
	public String delete(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1,//RequestParam get id to form
			@PathVariable(value ="id", required = false)Integer id2) {//PathVariable get id to url
		Integer id = (id2 != null) ? id2 : id1;
		bannerDao.delete(id);
		model.addAttribute("message", "delete successFully");
		return "redirect:/admin/banner/index";
	}
	
	
	
}
