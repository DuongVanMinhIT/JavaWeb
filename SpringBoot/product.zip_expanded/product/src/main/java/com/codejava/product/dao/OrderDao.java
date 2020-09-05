package com.codejava.product.dao;

import java.util.List;

import com.codejava.product.entity.Order;

public interface OrderDao {
	Order findByid(int id);
	List<Order> finAll();
	Order create(Order entity);
	void update(Order entity);
	Order detele(int id);
}
