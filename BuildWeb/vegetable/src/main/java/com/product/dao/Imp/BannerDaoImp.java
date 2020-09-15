package com.product.dao.Imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.dao.IBannerDao;
import com.product.entity.Banner;
@Transactional(rollbackFor = Exception.class)
@Repository
public class BannerDaoImp implements IBannerDao{
	
	@Autowired
	private SessionFactory factory;
	
	@Override
	public Banner findById(int id) {
		Session session = this.factory.getCurrentSession();
		Banner entity = session.find(Banner.class, id);
		return entity;
				
	}

	@Override
	public List<Banner> findAll() {
		String sql = "FROM Banner";
		Session session = this.factory.getCurrentSession();
		TypedQuery<Banner> query = session.createQuery(sql,Banner.class);
		List<Banner> list = query.getResultList();
		return list;
	}

	@Override
	public Banner create(Banner entity) {
		Session session = this.factory.getCurrentSession();
		session.save(entity);
		return  entity;
	}

	@Override
	public void update(Banner entity) {
		Session session = this.factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Banner delete(int id) {
		Session session = this.factory.getCurrentSession();
		Banner c = session.find(Banner.class, id);
		session.delete(c);
		return c;
	}

}
