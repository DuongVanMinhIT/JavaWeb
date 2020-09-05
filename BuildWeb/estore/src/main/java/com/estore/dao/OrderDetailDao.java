package com.estore.dao;

import java.util.List;

import com.estore.entity.OrderDetail;

public interface OrderDetailDao {
	OrderDetail findByid(int id);
	List<OrderDetail> finAll();
	OrderDetail create(OrderDetail entity);
	void update(OrderDetail entity);
	OrderDetail detele(int id);
}
