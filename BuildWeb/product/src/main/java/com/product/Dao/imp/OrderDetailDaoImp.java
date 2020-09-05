package com.product.Dao.imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.Dao.OrderDetailDao;
import com.product.entity.Order;
import com.product.entity.OrderDetail;

@Transactional(rollbackFor = Exception.class)
@Repository
public class OrderDetailDaoImp implements OrderDetailDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public OrderDetail findByid(int id) {
		Session session = factory.getCurrentSession();
		OrderDetail entity = session.find(OrderDetail.class, id);
		return entity;
	}

	@Override
	public List<OrderDetail> finAll() {
		String sql = "FROM OrderDetail";
		Session session = factory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery(sql, OrderDetail.class);
		List<OrderDetail> list = query.getResultList();
		return list;
	}

	@Override
	public OrderDetail create(OrderDetail entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(OrderDetail entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public OrderDetail detele(int id) {
		Session session = factory.getCurrentSession();
		OrderDetail entity = session.find(OrderDetail.class, id);
		session.delete(entity);
		return entity;
	}

	@Override
	public List<OrderDetail> findByOrder(Order order) {
		String sql = "FROM OrderDetail d where d.order.id=:oid";
		Session session = factory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery(sql, OrderDetail.class);
		query.setParameter("oid", order.getId());
		List<OrderDetail> list = query.getResultList();
		return list;
	}

}
