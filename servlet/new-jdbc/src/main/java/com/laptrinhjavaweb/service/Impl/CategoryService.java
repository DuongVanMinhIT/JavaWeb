package com.laptrinhjavaweb.service.Impl;

import java.util.List;

import javax.inject.Inject;

import com.laptrinhjavaweb.dao.ICategoryDao;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

public class CategoryService implements ICategoryService<CategoryModel, Long>{
	@Inject
	private ICategoryDao category;
	
	
	@Override
	public List<CategoryModel> FindAll() {
		
		return category.FindAll();	
	}
	
}
