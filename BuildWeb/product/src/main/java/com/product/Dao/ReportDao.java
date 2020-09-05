package com.product.Dao;

import java.util.List;

public interface ReportDao {
	 List<Object[]> inventory();
	 List<Object[]> revenueByCategory();
	 List<Object[]> revenueByCustomer();
	 List<Object[]> revenueByYear();
	 List<Object[]> revenueByQuarter();
	 List<Object[]> revenueByMonth();
}
