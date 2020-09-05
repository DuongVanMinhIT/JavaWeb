package com.product.Controller.Admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.product.Dao.CustomerDao;
import com.product.entity.Customer;

@Controller
public class CustomerManager {
	@Autowired
	CustomerDao customerDao;
	@Autowired
	ServletContext app;
	
	@RequestMapping("/admin/customer/index")
	public String index(Model model) {
		Customer entity = new Customer();
		
		model.addAttribute("entity", entity);
		model.addAttribute("list", customerDao.finAll());
		return "admin/customer/index";
	}
	@RequestMapping("/admin/customer/edit/{id}")
	public String edit(Model model,
			@PathVariable("id")Integer id) {
		Customer entity = customerDao.findByid(id);
		model.addAttribute("entity", entity);
		model.addAttribute("list", customerDao.finAll());
		
		return "admin/customer/index";
	}
	
	@RequestMapping("/admin/customer/create")
	public String create(RedirectAttributes model,
			@ModelAttribute("entity")Customer customer,
			@RequestParam("photo_file")MultipartFile file) throws IllegalStateException, IOException {
		if(file.isEmpty()) {
			customer.setPhoto("person-img.png");
		}else {
			customer.setPhoto(file.getOriginalFilename());
			String path = app.getRealPath("/static/images/customers/"+ customer.getPhoto());
			file.transferTo(new File(path));
		}
		customerDao.create(customer);
		model.addAttribute("message", "them moi thanh cong!");
		return "redirect:/admin/customer/index";
	}
	@RequestMapping("/admin/customer/update")
	public String update(RedirectAttributes model, 
			@ModelAttribute("entity")Customer customer,
			@RequestParam("photo_file")MultipartFile file) throws IllegalStateException, IOException {
		if(!file.isEmpty()) {
			customer.setPhoto(file.getOriginalFilename());
			String path = app.getRealPath("/static/images/customers/"+ customer.getPhoto());
			file.transferTo(new File(path));
		}
		customerDao.update(customer);
		model.addAttribute("message", "cap nhap thanh cong!");
		return "redirect:/admin/customer/edit/"+customer.getId();
	}
	@RequestMapping(value= {"/admin/customer/delete","/admin/customer/delete/{id}"})
	public String detele(RedirectAttributes model,
			@RequestParam(value = "id", required = false)Integer id1, 
			@PathVariable(value = "id", required = false)Integer id2) {
		Integer id = (id1 != null) ? id1 : id2;
		customerDao.detele(id);
		model.addAttribute("message", "xoa thanh cong!");
		return "redirect:/admin/customer/index";
	}
	@ResponseBody
	@RequestMapping("/pager/customer/page-count")
	public long pageCount() {
		int pageSize = 10;
		return customerDao.getPageCount(pageSize);
	}
	@ResponseBody
	@RequestMapping("/pager/customer/page/{pageNo}")
	public List<Customer> getPage(@PathVariable("pageNo")int pageNo) {
		int pageSize = 10;
		List<Customer> list = customerDao.getPage(pageNo, pageSize);
		return list;
	}
}
