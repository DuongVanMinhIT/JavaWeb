package com.product.Dao;

import java.util.List;

import com.product.entity.Customer;
import com.product.entity.Order;
import com.product.entity.OrderDetail;

public interface OrderDao {
	Order findByid(int id);
	List<Order> finAll();
	Order create(Order entity);
	void update(Order entity);
	Order detele(int id);
	void create(Order order, List<OrderDetail> details);
	List<Order> finByUser(Customer user);
}
