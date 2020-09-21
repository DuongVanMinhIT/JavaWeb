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
	   @Id
	   @GeneratedValue(strategy = GenerationType.IDENTITY)
	   private int id;
	   private Float unitPrice;
	   private int quantity;
	   private Double discount;
	   private String size;
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
	
		public Float getUnitPrice() {
			return unitPrice;
		}
	
		public void setUnitPrice(Float unitPrice) {
			this.unitPrice = unitPrice;
		}
	
		public int getQuantity() {
			return quantity;
		}
	
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
	
		public Double getDiscount() {
			return discount;
		}
	
		public void setDiscount(Double discount) {
			this.discount = discount;
		}
	
		public String getSize() {
			return size;
		}
	
		public void setSize(String size) {
			this.size = size;
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
