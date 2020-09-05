package com.product.Controller.Admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.product.Dao.ReportDao;

@Controller
public class inventoryReport {
	@Autowired
	ReportDao reportDao;
	
	@RequestMapping("/admin/inventoty/index")
	public String index(Model model) {
		model.addAttribute("data", reportDao.inventory());
		return "/admin/report/inventory";
	}
	@RequestMapping("/admin/revenue/category")
	public String revenueByCategory(Model model) {	
		model.addAttribute("data", reportDao.revenueByCategory());
		return "admin/report/revenue-category";
	}
	@RequestMapping("/admin/revenue/customer")
	public String revenueByCustomer(Model model) {	
		model.addAttribute("data", reportDao.revenueByCustomer());
		return "admin/report/revenue-customer";
	}
	@RequestMapping("/admin/revenue/year")
	public String revenueByYear(Model model) {	
		model.addAttribute("data", reportDao.revenueByYear());
		return "admin/report/revenue-year";
	}
	@RequestMapping("/admin/revenue/quarter")
	public String revenueByQuarter(Model model) {	
		model.addAttribute("data", reportDao.revenueByQuarter());
		return "admin/report/revenue-quarter";
	}
	@RequestMapping("/admin/revenue/month")
	public String revenueByMonth(Model model) {	
		model.addAttribute("data", reportDao.revenueByMonth());
		return "admin/report/revenue-month";
	}
	
}
