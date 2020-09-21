package com.product.dao;

import java.util.List;

import com.product.entity.Customer;
import com.product.entity.Order;
import com.product.entity.OrderDetail;

public interface IOrderDao {
	Order findById(int id);
	List<Order> findAll();
	Order create(Order entity);
	void update(Order entity);
	Order delete(int id);
	void create(Order order, List<OrderDetail> details);
	List<Order> findByUser(Customer user);
}
