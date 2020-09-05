package com.product.dao;

import java.util.List;

import com.product.entity.Customer;

public interface ICustomerDao {
	Customer findById(int id);
	List<Customer> findAll();
	Customer create(Customer entity);
	void update(Customer entity);
	Customer delete(int id);
}
