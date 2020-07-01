package com.laptrinhjavaweb.dao.impl;

import java.util.List;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.mapper.NewMapper;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.model.NewsModel;

public class CategoryDao extends AbtractDao<CategoryModel> implements ICategoryDao{


	@Override
	public List<CategoryModel> FindAll() {
		String sql = "select * from category";
		return query(sql, new CategoryMapper());
	}

	@Override
	public CategoryModel findOne(Long id) {
		
		String sql = "select * from category where id = ?";
		List<CategoryModel> dataCategory = query(sql, new CategoryMapper(), id);
		return dataCategory.isEmpty() ? null : dataCategory.get(0);
	}

	@Override
	public CategoryModel findOneByCode(String code) {
		String sql = "select * from category where code = ?";
		List<CategoryModel> dataCategory = query(sql, new CategoryMapper(), code);
		return dataCategory.isEmpty() ? null : dataCategory.get(0);
	}

}
