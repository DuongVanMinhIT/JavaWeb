package com.product.Dao.imp;

import java.util.List;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.product.Dao.ReportDao;
@Transactional
@Repository
public class ReportDaoImpl implements ReportDao{
	@Autowired
	SessionFactory factory;
	
	
	@Override
	public List<Object[]> inventory() {
		String sql = "SELECT p.category.nameVN,"+
				" SUM(p.quantity),"+
				" SUM(p.quantity * p.unitPrice),"+
				" MIN(p.unitPrice)," 
				+" MAX(p.unitPrice),"+
				" AVG(p.unitPrice)"+
				" FROM Product p" +
				" GROUP BY p.category.nameVN";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByCategory() {
		String sql = "SELECT d.product.category.nameVN,"+
				" SUM(d.quantity),"+
				" SUM(d.quantity * d.unitPrce),"+
				" MIN(d.unitPrce)," 
				+" MAX(d.unitPrce),"+
				" AVG(d.unitPrce)"+
				" FROM OrderDetail d" +
				" GROUP BY d.product.category.nameVN";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByCustomer() {
		String sql = "SELECT d.order.customer.id,"+
				" SUM(d.quantity),"+
				" SUM(d.quantity * d.unitPrce),"+
				" MIN(d.unitPrce)," 
				+" MAX(d.unitPrce),"+
				" AVG(d.unitPrce)"+
				" FROM OrderDetail d" +
				" GROUP BY d.order.customer.id";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByYear() {
		String sql = "SELECT YEAR(d.order.orderDate),"+
				" SUM(d.quantity),"+
				" SUM(d.quantity * d.unitPrce),"+
				" MIN(d.unitPrce)," +
				" MAX(d.unitPrce),"+
				" AVG(d.unitPrce)"+
				" FROM OrderDetail d" +
				" GROUP BY YEAR(d.order.orderDate)"+
				"ORDER BY YEAR(d.order.orderDate) DESC";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByQuarter() {
		String sql = "SELECT CEILING(MONTH(d.order.orderDate /3.0)),"+
				" SUM(d.quantity),"+
				" SUM(d.quantity * d.unitPrce),"+
				" MIN(d.unitPrce)," +
				" MAX(d.unitPrce),"+
				" AVG(d.unitPrce)"+
				" FROM OrderDetail d" +
				" GROUP BY CEILING(MONTH(d.order.orderDate /3.0))"+
				"ORDER BY CEILING(MONTH(d.order.orderDate /3.0))";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

	@Override
	public List<Object[]> revenueByMonth() {
		String sql = "SELECT MONTH(d.order.orderDate),"+
				" SUM(d.quantity),"+
				" SUM(d.quantity * d.unitPrce),"+
				" MIN(d.unitPrce)," +
				" MAX(d.unitPrce),"+
				" AVG(d.unitPrce)"+
				" FROM OrderDetail d" +
				" GROUP BY MONTH(d.order.orderDate)"+
				"ORDER BY MONTH(d.order.orderDate) DESC";
		Session session = factory.getCurrentSession();
		TypedQuery<Object[]> query = session.createQuery(sql, Object[].class);
		List<Object[]> list = query.getResultList();
		return list;
	}

}
