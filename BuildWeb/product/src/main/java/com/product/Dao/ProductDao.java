package com.product.Dao;

import java.util.List;

import com.product.entity.Product;

public interface ProductDao {
	Product findByid(int id);
	List<Product> finAll();
	Product create(Product entity);
	void update(Product entity);
	Product detele(int id);
	List<Product> findByCategoryId(int CategoryId);
	List<Product> findByKeyWords(String keywords);
	List<Product> findByIds(String ids);
	List<Product> findBySpecial(int id);
	
}
