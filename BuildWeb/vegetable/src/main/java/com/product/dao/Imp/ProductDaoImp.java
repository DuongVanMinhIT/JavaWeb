package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.IProductDao;
import com.product.entity.Product;
@Transactional(rollbackFor = Exception.class)
@Repository
public class ProductDaoImp implements IProductDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Product findById(int id) {
		Session session = this.factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		return entity;
				
	}

	@Override
	public List<Product> findAll() {
		String sql = "FROM Product";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(sql,Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public Product create(Product entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Product entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Product delete(int id) {
		Session session = this.factory.getCurrentSession();
		Product c = session.find(Product.class, id);
		session.delete(c);
		return c;
	}

}
