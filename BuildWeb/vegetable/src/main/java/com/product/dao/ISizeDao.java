package com.product.dao;

import java.util.List;

import com.product.entity.Size;

public interface ISizeDao {
	Size findById(int id);
	List<Size> findAll();
	Size create(Size entity);
	void update(Size entity);
	Size delete(int id);
}
