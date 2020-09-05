package com.product.dao;

import java.util.List;

import com.product.entity.Category;

public interface ICategoryDao {
	Category findById(int id);
	List<Category> findAll();
	Category create(Category entity);
	void update(Category entity);
	Category delete(int id);
}
