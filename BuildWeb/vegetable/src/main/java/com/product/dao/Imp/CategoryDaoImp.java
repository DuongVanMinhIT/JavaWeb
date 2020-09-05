package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ICategoryDao;
import com.product.entity.Category;
@Transactional(rollbackFor = Exception.class)
@Repository
public class CategoryDaoImp implements ICategoryDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public Category findById(int id) {
		Session session = this.factory.getCurrentSession();
		Category entity = session.find(Category.class, id);
		return entity;
				
	}

	@Override
	public List<Category> findAll() {
		String sql = "FROM Category";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Category> query = session.createQuery(sql,Category.class);
		List<Category> list = query.getResultList();
		return list;
	}

	@Override
	public Category create(Category entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Category entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Category delete(int id) {
		Session session = this.factory.getCurrentSession();
		Category c = session.find(Category.class, id);
		session.delete(c);
		return c;
	}

}
