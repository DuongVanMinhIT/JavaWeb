package com.estore.dao;

import java.util.List;

import com.estore.entity.Product;

public interface ProductDao {
	Product findByid(int id);
	List<Product> finAll();
	Product create(Product entity);
	void update(Product entity);
	Product detele(int id);
}
