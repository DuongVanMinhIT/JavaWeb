package com.codejava.product.dao;

import java.util.List;

import com.codejava.product.entity.Product;

public interface ProductDao {
	Product findByid(int id);
	List<Product> finAll();
	Product create(Product entity);
	void update(Product entity);
	Product detele(int id);
}
