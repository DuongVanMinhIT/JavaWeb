package com.laptrinhjavaweb.service;

import java.util.List;

import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.paging.Pageble;

//return funtion Dao
public interface INewsService<T, Tkey> {
	List<T> findByCategoryId(Tkey id);
	T Insert(T entity);
	T update(T entity);
	void delete(Long[] ids);
	List<T> findall(Pageble pageble);
	int getTotalItem();
	NewsModel findOne(Long id);
}
