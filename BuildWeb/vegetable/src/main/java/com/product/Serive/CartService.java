package com.product.Serive;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.SessionScope;

import com.product.dao.IProductDao;
import com.product.entity.Product;
@SessionScope// Name: scopeTarget.cartService
@Service
public class CartService {
	@Autowired
	private IProductDao productDao;

	private Map<Integer, Product> map = new HashMap<Integer, Product>();

	public void add(Integer id) {
		Product p = map.get(id);
		if (p == null) {
			p = productDao.findById(id);
			p.setQuantity(1);
			map.put(id, p);
		} else {
			p.setQuantity(p.getQuantity() + 1);
		}

	}

	public void remove(Integer id) {
		map.remove(id);
	}

	public void update(Integer id, Integer qty) {
		Product p = map.get(id);
		p.setQuantity(qty);
	}
	public void update(Integer id, float unitPrice) {
		Product p = map.get(id);
		p.setUnitPrice(unitPrice);
	}

	public void clear() {
		map.clear();
	}

	public int getCount() {
		Collection<Product> ps = this.getItems();
		int count = 0;
		for (Product p : ps) {
			count += p.getQuantity();
		}
		return count;
	}

	// tong tien
	public double getAmount() {
		Collection<Product> ps = this.getItems();
		Double amount = (double) 0;
		for (Product p : ps) {
			amount += (p.getQuantity() * p.getUnitPrice() * (1 - p.getDiscount()));
		}
		return amount;
	}

	public Collection<Product> getItems() {
		return map.values();
	}

}
