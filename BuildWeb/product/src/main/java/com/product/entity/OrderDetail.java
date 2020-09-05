package com.product.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity 
@Table(name="OrderDetails")
public class OrderDetail {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)//tu tang
	private int id;
	private double unitPrce;
    private int quantity;	
    private double discount;
    
    @ManyToOne
	@JoinColumn(name="orderId")
    private Order order;
    	
    @ManyToOne
	@JoinColumn(name="productId")
    private Product product;

    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getUnitPrce() {
		return unitPrce;
	}

	public void setUnitPrce(double unitPrce) {
		this.unitPrce = unitPrce;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	

	public Order getOrders() {
		return order;
	}

	public void setOrders(Order orders) {
		this.order = orders;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
}