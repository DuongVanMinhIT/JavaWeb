package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.ISizeDao;
import com.product.entity.Size;
@Transactional(rollbackFor = Exception.class)
@Repository
public class SizeDaoImp implements ISizeDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public Size findById(int id) {
		Session session = this.factory.getCurrentSession();
		Size entity = session.find(Size.class, id);
		return entity;
				
	}

	@Override
	public List<Size> findAll() {
		String sql = "FROM Size";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Size> query = session.createQuery(sql,Size.class);
		List<Size> list = query.getResultList();
		return list;
	}

	@Override
	public Size create(Size entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Size entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Size delete(int id) {
		Session session = this.factory.getCurrentSession();
		Size c = session.find(Size.class, id);
		session.delete(c);
		return c;
	}

}
