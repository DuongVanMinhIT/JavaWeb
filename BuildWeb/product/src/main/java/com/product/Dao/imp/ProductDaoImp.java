package com.product.Dao.imp;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.product.Dao.ProductDao;
import com.product.entity.Product;

@Transactional(rollbackFor = Exception.class)
@Repository
public class ProductDaoImp implements ProductDao{
	
	@Autowired
	SessionFactory factory;
	
	@Override
	public Product findByid(int id) {
		Session session = factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		return entity;
	}

	@Override
	public List<Product> finAll() {
		String sql = "FROM Product";
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(sql, Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public Product create(Product entity) {
		Session session = factory.getCurrentSession();
		session.save(entity);
		return entity;
	}

	@Override
	public void update(Product entity) {
		Session session = factory.getCurrentSession();
		session.update(entity);
		
	}

	@Override
	public Product detele(int id) {
		Session session = factory.getCurrentSession();
		Product entity = session.find(Product.class, id);
		session.delete(entity);
		return entity;
	}

	@Override
	public List<Product> findByCategoryId(int CategoryId) {
		String sql = "FROM Product p where p.category.id=:cid";
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(sql, Product.class);
		query.setParameter("cid", CategoryId);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> findByKeyWords(String keywords) {
		String sql = "FROM Product p where p.name LIKE :kw OR p.category.name LIKE :kw OR p.category.nameVN LIKE :kw";
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(sql, Product.class);
		query.setParameter("kw", "%"+keywords+"%");
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> findByIds(String ids) {
		String sql = "FROM Product p where p.id IN ("+ids+")";
		Session session = factory.getCurrentSession();
		TypedQuery<Product> query = session.createQuery(sql, Product.class);
		List<Product> list = query.getResultList();
		return list;
	}

	@Override
	public List<Product> findBySpecial(int id) {
		Session session = factory.getCurrentSession();
		String sql = "FROM Product p";
		TypedQuery<Product> query = session.createQuery(sql, Product.class);
		switch (id) {
		case 0://moi
			sql = "FROM Product p ORDER BY p.productDate DESC";
			break;
		case 1://ban chay
			sql = "FROM Product p ORDER BY size(p.orderDetails) DESC";
			break;
        case 2://xem nhieu
        	sql = "FROM Product p ORDER BY p.viewCount DESC";
			break;	
        case 3://giam gia
        	sql = "FROM Product p ORDER BY p.discount DESC";
			break;	
		}
		query = session.createQuery(sql,Product.class);
		query.setMaxResults(12);
		
		
		List<Product> list = query.getResultList();
		return list;
	}

}
