package com.laptrinhjavaweb.converter;

import org.springframework.stereotype.Component;

import com.laptrinhjavaweb.dto.CategoryDTO;
import com.laptrinhjavaweb.entity.CategoryEntity;
@Component	
public class CategoryConverter {
	
	public CategoryDTO toDto(CategoryEntity entity) {//sua
		CategoryDTO result = new CategoryDTO();
		result.setId(entity.getId());
		result.setName(entity.getName());
		result.setCode(entity.getCode());
		return result;
		
	}
	
	public CategoryDTO toEntity(CategoryDTO dto) {//chi them moi
		CategoryDTO result = new CategoryDTO();
		result.setName(dto.getName());
		result.setCode(dto.getCode());
		return result;
		
	}
	
	
}
