package com.product.Serive;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.product.Dao.ProductDao;
import com.product.entity.Product;
@SessionScope// Name: scopeTarget.cartService
@Service
public class CartService {
	@Autowired
	private ProductDao productDao;
	
	private Map<Integer, Product> map = new HashMap<>();
	
	public void add(Integer id) {
		//biet id truy vat san pham ,con neu dung list thi phia dung for
		Product p = map.get(id);
		if( p == null) {
			p = productDao.findByid(id);
			p.setQuantity(1);
			map.put(id, p);
		}else {
			p.setQuantity(p.getQuantity() +1);
		}
	}
	public void remove(Integer id) {
		map.remove(id);
	}
	public void update(Integer id, int qty) {
		Product p = map.get(id);
		p.setQuantity(qty);
	}
	public void clear() {
		map.clear();
	}
	public int getCount() {
		Collection<Product> ps = this.getItmes();
		int count = 0;
		for (Product p : ps) {
			count += p.getQuantity();
		}
		return count;
	}
	//tong so tien
	public double getAmount() {
		Collection<Product> ps = this.getItmes();
		double amount = 0;
		for (Product p : ps) {
			amount += (p.getQuantity() * p.getUnitPrice() *(1-p.getDiscount()));
		}
		return amount;
	}
	public Collection<Product> getItmes(){
		return map.values();
	}
}
