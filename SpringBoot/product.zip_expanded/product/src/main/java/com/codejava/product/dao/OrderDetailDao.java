package com.codejava.product.dao;

import java.util.List;

import com.codejava.product.entity.OrderDetail;

public interface OrderDetailDao {
	OrderDetail findByid(int id);
	List<OrderDetail> finAll();
	OrderDetail create(OrderDetail entity);
	void update(OrderDetail entity);
	OrderDetail detele(int id);
}
