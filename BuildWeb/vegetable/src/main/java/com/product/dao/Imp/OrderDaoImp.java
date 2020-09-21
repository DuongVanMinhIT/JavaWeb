package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.IOrderDao;
import com.product.entity.Customer;
import com.product.entity.Order;
import com.product.entity.OrderDetail;
@Transactional(rollbackFor = Exception.class)
@Repository
public class OrderDaoImp implements IOrderDao{
	
	@Autowired
	SessionFactory factory;
	
	
	@Override
	public Order findById(int id) {
		Session session = this.factory.getCurrentSession();
		Order entity = session.find(Order.class, id);
		return entity;
				
	}

	@Override
	public List<Order> findAll() {
		String sql = "FROM Order";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Order> query = session.createQuery(sql,Order.class);
		List<Order> list = query.getResultList();
		return list;
	}

	@Override
	public Order create(Order entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Order entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Order delete(int id) {
		Session session = this.factory.getCurrentSession();
		Order c = session.find(Order.class, id);
		session.delete(c);
		return c;
	}

	@Override
	public void create(Order order, List<OrderDetail> details) {
		Session session = this.factory.getCurrentSession();
		session.save(order);
		
		for (OrderDetail oD : details) {
			session.save(oD);
		}
	}
	
	

	@Override
	public List<Order> findByUser(Customer user) {
		String sql = "FROM Order o where o.customer.id=:uid";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Order> query = session.createQuery(sql, Order.class);
		query.setParameter("uid", user.getId());
		List<Order> list = query.getResultList();
		return list;
	}

}
