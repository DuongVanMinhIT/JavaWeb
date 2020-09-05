package com.codejava.product.dao;

import java.util.List;

import com.codejava.product.entity.Category;

public interface CategoryDao {
	Category findByid(int id);
	List<Category> finAll();
	Category create(Category entity);
	void update(Category entity);
	Category detele(int id);
}
