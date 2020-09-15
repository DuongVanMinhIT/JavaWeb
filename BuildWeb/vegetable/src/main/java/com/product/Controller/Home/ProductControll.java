package com.product.Controller.Home;
import java.util.List;

import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.product.Bean.MailInfo;
import com.product.Serive.CookieService;
import com.product.Serive.MailService;
import com.product.dao.IProductDao;
import com.product.entity.Product;

@Controller
public class ProductControll {
	@Autowired
	IProductDao productDao;
	@Autowired
	CookieService cookieService;
	@Autowired
	MailService mail;
	
	@RequestMapping("/home/shop")
	public String ShowShop() {
		return "shop/product";
	}
	
	@RequestMapping("/product/list-by-category/{id}")
	public  String listBycategoty(Model model,
			@PathVariable("id")int categoryId) {
		List<Product> listProduct = productDao.findByCategoryId(categoryId);
		model.addAttribute("listProduct", listProduct);
		return "shop/product";
	}
	
	@RequestMapping("/product/detail/{id}")
	public  String listByProduct(Model model,
			@PathVariable("id")Integer ProductId) {
		Product product = productDao.findById(ProductId);
		model.addAttribute("product", product);
		product.setViewCount(product.getViewCount());
		productDao.update(product);
		//goods of the same type
		List<Product> listProducts = productDao.findByCategoryId(product.getCategory().getId());
		model.addAttribute("listSameType", listProducts);
		// favorite goods
		Cookie favo = cookieService.Read("favo");
		if(favo != null) {
			String ids = favo.getValue();
			
			List<Product> favoList = productDao.findByIds(ids);
			model.addAttribute("favoList", favoList);
			
		}
		//goods viewed
		Cookie viewed = cookieService.Read("viewed");
		String value = ProductId.toString();
		if(viewed != null) {
			value += viewed.getValue();
			value +=","+ProductId.toString();
		}
		cookieService.Create("viewed", value, 10);
		List<Product> viewed_list = productDao.findByIds(value);
		model.addAttribute("viewed_list", viewed_list);
		return "shop/productDetail";
	}
	
	@ResponseBody
	@RequestMapping("/product/send-to-friend")
	public boolean sendTofriend(MailInfo info,HttpServletRequest req) {
		info.setSubject("thong tin hang hoa");
		
		try {
			String id = req.getParameter("id");
			String link = req.getRequestURL().toString().replace("send-to-friend", "detail/"+id);
			info.setBody(info.getBody() +"<hr><a href='"+link+"'>xem chi tiet...</a>");
			mail.send(info);
			return true;
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
		
		
	}
	@ResponseBody
	@RequestMapping("/product/add-to-favo/{id}")
	public boolean addToFavorite(
			@PathVariable("id")Integer id) {
		Cookie favo = cookieService.Read("favo");
		String value = id.toString();
		if(favo != null) {
			value = favo.getValue();
			if(!value.contains(id.toString())) {
				value += "," + id.toString();
			}else {
				return false;
			}
		}
		favo = cookieService.Create("favo", value, 30);
		return true;
		
	}
	
	
	
}
