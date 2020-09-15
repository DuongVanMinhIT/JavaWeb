package com.product.dao;

import java.util.List;

import com.product.entity.Banner;

public interface IBannerDao {
	Banner findById(int id);
	List<Banner> findAll();
	Banner create(Banner entity);
	void update(Banner entity);
	Banner delete(int id);
}
