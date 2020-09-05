package com.product.Dao.imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.Dao.CustomerDao;
import com.product.entity.Customer;

@Transactional(rollbackFor = Exception.class)
@Repository
public class CustomerDaoImp implements CustomerDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Customer findByid(int id) {
		Session session = factory.getCurrentSession();
		Customer entity = session.find(Customer.class, id);
		return entity;
	}

	@Override
	public List<Customer> finAll() {
		String sql = "FROM Customer";
		Session session = factory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery(sql, Customer.class);
		List<Customer> list = query.getResultList();
		return list;
	}

	@Override
	public Customer create(Customer entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(Customer entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Customer detele(int id) {
		Session session = factory.getCurrentSession();
		Customer entity = session.find(Customer.class, id);
		session.delete(entity);
		return entity;
	}

	@Override
	public Customer findByName(String name) {
		return finAll().stream().filter(x -> x.getFullname().equals(name)).findAny().get();
	}

	@Override
	public long getPageCount(int pageSize) {
		String sql = "SELECT count(c) FROM Customer c";
		Session session = factory.getCurrentSession();
		TypedQuery<Long> query = session.createQuery(sql, Long.class);
		Long rowCount = query.getSingleResult();
		long pageCount = (long)Math.ceil(1.0*rowCount/pageSize);
		return pageCount;
	}

	@Override
	public List<Customer> getPage(int pageNo, int pageSize) {
		String sql = "FROM Customer";
		Session session = factory.getCurrentSession();
		TypedQuery<Customer> query = session.createQuery(sql, Customer.class);
		query.setFirstResult(pageNo * pageSize);
		query.setMaxResults(pageSize);
		List<Customer> list = query.getResultList();
		return list;
	}

}
