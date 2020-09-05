package com.estore.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity @Table(name="OrderDetail")
public class OrderDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)//tu tang
	int id;
	//private int OrderId;
	//private int ProductId;
	private double UnitPrce;
    private int Quantity;
    private double Discount;
    
    @ManyToOne
	@JoinColumn(name="OrderId")
    Order order;
    
    @ManyToOne
	@JoinColumn(name="ProductId")
    Product product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUnitPrce() {
		return UnitPrce;
	}

	public void setUnitPrce(double unitPrce) {
		UnitPrce = unitPrce;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
    
}
