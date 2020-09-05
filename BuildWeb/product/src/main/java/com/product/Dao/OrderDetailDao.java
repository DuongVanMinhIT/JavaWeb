package com.product.Dao;

import java.util.List;

import com.product.entity.Order;
import com.product.entity.OrderDetail;

public interface OrderDetailDao {
	OrderDetail findByid(int id);
	List<OrderDetail> finAll();
	OrderDetail create(OrderDetail entity);
	void update(OrderDetail entity);
	OrderDetail detele(int id);
	List<OrderDetail> findByOrder(Order order);
}
