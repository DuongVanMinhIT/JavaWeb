package com.laptrinhjavaweb.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.laptrinhjavaweb.entity.CategoryEntity;
import com.laptrinhjavaweb.repository.CategoryRepository;
import com.laptrinhjavaweb.service.ICategoryService;

@Service
public class CategotyService implements ICategoryService {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
	@Override
	public Map<String, String>  findAll() {
		Map<String, String> result = new HashMap<>();
		List<CategoryEntity> entity = categoryRepository.findAll();
		
		for (CategoryEntity item : entity) {
			result.put(item.getCode(), item.getName());
		}
		return result;
	}
	
	
}
