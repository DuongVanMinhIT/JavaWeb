package com.product.dao;

import java.util.List;

import com.product.entity.OrderDetail;

public interface IOrderDetailDao {
	OrderDetail findById(int id);
	List<OrderDetail> findAll();
	OrderDetail create(OrderDetail entity);
	void update(OrderDetail entity);
	OrderDetail delete(int id);
}
