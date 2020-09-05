package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.IOrderDetailDao;
import com.product.entity.OrderDetail;
@Transactional(rollbackFor = Exception.class)
@Repository
public class OrderDetailDaoImp2 implements IOrderDetailDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public OrderDetail findById(int id) {
		Session session = this.factory.getCurrentSession();
		OrderDetail entity = session.find(OrderDetail.class, id);
		return entity;
				
	}

	@Override
	public List<OrderDetail> findAll() {
		String sql = "FROM OrderDetail";
		Session session = this.factory.getCurrentSession();
		TypedQuery<OrderDetail> query = session.createQuery(sql,OrderDetail.class);
		List<OrderDetail> list = query.getResultList();
		return list;
	}

	@Override
	public OrderDetail create(OrderDetail entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(OrderDetail entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public OrderDetail delete(int id) {
		Session session = this.factory.getCurrentSession();
		OrderDetail c = session.find(OrderDetail.class, id);
		session.delete(c);
		return c;
	}

}
