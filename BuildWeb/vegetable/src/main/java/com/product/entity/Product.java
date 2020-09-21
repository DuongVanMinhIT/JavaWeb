package com.product.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Products")
public class Product {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private int id;
	  private String name;
	  private  float unitPrice;
	  private String image;
	  @Temporal(TemporalType.DATE)
	  @DateTimeFormat(pattern = "dd/MM/yyyy")
	  private Date productDate;
	  private boolean available;
	  private int quantity;
	  private String sizes;
	  private String desctiption;
	  private Double discount;
	  private int ViewCount;
	  private boolean Special;
	  @ManyToOne
	  @JoinColumn(name ="categoryId")
	  private Category category;
	  
	  @OneToMany(mappedBy = "product")
	  private List<OrderDetail>orderDetails;

	 
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public float getUnitPrice() {
			return unitPrice;
		}
		public void setUnitPrice(float unitPrice) {
			this.unitPrice = unitPrice;
		}
		public String getImage() {
			return image;
		}
		public void setImage(String image) {
			this.image = image;
		}
		public Date getProductDate() {
			return productDate;
		}
		public void setProductDate(Date productDate) {
			this.productDate = productDate;
		}
		public boolean isAvailable() {
			return available;
		}
		public void setAvailable(boolean available) {
			this.available = available;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		
		public String getSizes() {
			return sizes;
		}
		public void setSizes(String sizes) {
			this.sizes = sizes;
		}
		public String getDesctiption() {
			return desctiption;
		}
		public void setDesctiption(String desctiption) {
			this.desctiption = desctiption;
		}
		public Double getDiscount() {
			return discount;
		}
		public void setDiscount(Double discount) {
			this.discount = discount;
		}
		public int getViewCount() {
			return ViewCount;
		}
		public void setViewCount(int viewCount) {
			ViewCount = viewCount;
		}
		public boolean isSpecial() {
			return Special;
		}
		public void setSpecial(boolean special) {
			Special = special;
		}
		public Category getCategory() {
			return category;
		}
		public void setCategory(Category category) {
			this.category = category;
		}
		public List<OrderDetail> getOrderDetails() {
			return orderDetails;
		}
		public void setOrderDetails(List<OrderDetail> orderDetails) {
			this.orderDetails = orderDetails;
		}
		
		
	  
	  
}
