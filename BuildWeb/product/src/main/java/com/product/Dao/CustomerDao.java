package com.product.Dao;

import java.util.List;

import com.product.entity.Customer;

public interface CustomerDao {
	Customer findByid(int id);
	Customer findByName(String name);
	List<Customer> finAll();
	Customer create(Customer entity);
	void update(Customer entity);
	Customer detele(int id);
	long getPageCount(int pageSize);
	List<Customer> getPage(int pageNo, int pageSize);
}
