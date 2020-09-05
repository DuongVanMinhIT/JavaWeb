package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ICustomerDao;
import com.product.entity.Customer;
@Transactional(rollbackFor = Exception.class)
@Repository
public class CustomeDaoImp implements ICustomerDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Customer findById(int id) {
		Session session = this.factory.getCurrentSession();
		Customer entity = session.find(Customer.class, id);
		return entity;
				
	}

	@Override
	public List<Customer> findAll() {
		String sql = "FROM Customer";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery(sql,Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public Customer create(Customer entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Customer entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Customer delete(int id) {
		Session session = this.factory.getCurrentSession();
		Customer c = session.find(Customer.class, id);
		session.delete(c);
		return c;
	}

}
