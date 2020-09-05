package com.estore.dao;

import java.util.List;

import com.estore.entity.Customer;

public interface CustomerDao {
	Customer findByid(int id);
	List<Customer> finAll();
	Customer create(Customer entity);
	void update(Customer entity);
	Customer detele(int id);
}
