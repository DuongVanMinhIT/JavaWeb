package com.estore.dao;

import java.util.List;

import com.estore.entity.Category;

public interface CategoryDao {
	Category findByid(int id);
	List<Category> finAll();
	Category create(Category entity);
	void update(Category entity);
	Category detele(int id);
}
