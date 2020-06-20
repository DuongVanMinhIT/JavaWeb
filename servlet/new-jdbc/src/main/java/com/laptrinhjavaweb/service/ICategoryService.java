package com.laptrinhjavaweb.service;

import java.util.List;

public interface ICategoryService<T, Tkey> {
	List<T> FindAll();
}
