package com.product.dao;

import java.util.List;

import com.product.entity.Order;

public interface IOrderDao {
	Order findById(int id);
	List<Order> findAll();
	Order create(Order entity);
	void update(Order entity);
	Order delete(int id);
}
