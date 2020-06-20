package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

public class CategoryDao extends AbtractDao<CategoryModel> implements ICategoryDao{


	@Override
	public List<CategoryModel> FindAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

}
