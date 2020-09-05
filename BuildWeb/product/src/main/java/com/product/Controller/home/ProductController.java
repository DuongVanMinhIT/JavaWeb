package com.product.Controller.home;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Bean.MailInfo;
import com.product.Dao.ProductDao;
import com.product.Serive.CookieService;
import com.product.Serive.MailService;
import com.product.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CookieService cookie;
	@Autowired
	MailService mail;
	
	@RequestMapping("/product/list-by-category/{cid}")
	public String ListByCategory(
			@PathVariable("cid")Integer categoryId, 
			Model model) {
		List<Product> listProduct = productDao.findByCategoryId(categoryId);
		model.addAttribute("list", listProduct);
		return "product/list";
		
	}
	@RequestMapping("/product/list-by-keywords")
	public String ListByKeyWords(
			@RequestParam("keywords")String keyWords, 
			Model model) {
		List<Product> listProduct = productDao.findByKeyWords(keyWords);
		model.addAttribute("list", listProduct);
		return "product/list";
		
	}
	@RequestMapping("/product/detail/{id}")
	public String detail(
			@PathVariable("id")Integer id, Model model) {
		Product product = productDao.findByid(id);
		
		model.addAttribute("product", product);
		
		//tang so lan xem
		product.setViewCount(product.getViewCount() + 1);
		productDao.update(product);
		//hang cung loai
		List<Product> listProduct = productDao.findByCategoryId(product.getCategory().getId());
		//hang yeu thich
		model.addAttribute("list", listProduct);
		Cookie favo = cookie.read("favo");
		if(favo != null) {
			String ids = favo.getValue();
			
			List<Product> favoList = productDao.findByIds(ids);
			model.addAttribute("favoList", favoList);
		}
		//hang da xem
		Cookie viewed = cookie.read("viewed");
		String value = id.toString();
		if(viewed != null) {
			 value = viewed.getValue();
			value +=","+id.toString();
		}
		cookie.create("viewed", value, 10);
		List<Product> viewed_list = productDao.findByIds(value);
		model.addAttribute("viewed_list", viewed_list);
		
		return "product/detail";
		
	}
	@ResponseBody
	@RequestMapping("/product/add-to-favo/{id}")
	public boolean addToFavorite(
			@PathVariable("id")Integer id) {
		Cookie favo = cookie.read("favo");
		String value = id.toString();
		if(favo != null) {
			 value = favo.getValue();
			if(!value.contains(id.toString())) {
				value += "," + id.toString();
			}else {
				return false;
			}
		}
		favo = cookie.create("favo", value, 30);
		return true;
		
	}
	
	@RequestMapping("/product/list-by-special/{id}")
	public String ListBySpecial(
			@RequestParam("keywords")Integer id, 
			Model model) {
		List<Product> listProduct = productDao.findBySpecial(id);
		model.addAttribute("list", listProduct);
		return "product/list";
		
	}
	
	@ResponseBody
	@RequestMapping("/product/send-to-friend")
	public boolean sendTofriend(MailInfo info,HttpServletRequest req) {
		//send Mail
		info.setSubject("thong tin hang hoa");
		try {
			String id = req.getParameter("id");
			String link = req.getRequestURL().toString().replace("send-to-friend", "detail/" + id);
			info.setBody(info.getBody() +"<hr><a href='"+link+"'>xem chi tiet...</a>");
			mail.send(info);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}
	
	
}
