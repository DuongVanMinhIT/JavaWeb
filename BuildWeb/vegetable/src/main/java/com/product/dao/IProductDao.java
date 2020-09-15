package com.product.dao;

import java.util.List;

import com.product.entity.Product;

public interface IProductDao {
	Product findById(int id);
	List<Product> findAll();
	Product create(Product entity);
	void update(Product entity);
	Product delete(int id);
	List<Product> findByIds(String value);
	List<Product> findByCategoryId(int id);
}
