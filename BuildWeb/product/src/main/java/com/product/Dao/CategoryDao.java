package com.product.Dao;

import java.util.List;

import com.product.entity.Category;

public interface CategoryDao {
	Category findByid(int id);
	List<Category> finAll();
	Category create(Category entity);
	void update(Category entity);
	Category detele(int id);
}
