package com.estore.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
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

@Entity @Table(name="Product")
public class Product {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)//tu tang
	private int id;
	private String Name;
	private float UnitPrice;
	private String Image;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "MM/dd/yyyy")
	private Date ProductDate;
	private boolean Available;
	//private int CategoryId;
	private int Quantity;
	private String Desctiption;
	private double Discount;
	private int ViewCount;
	private boolean Special;
	
	@ManyToOne
	@JoinColumn(name="CategoryId")
	Category category;
	
	@OneToMany(mappedBy = "product", fetch = FetchType.EAGER)
 	List<OrderDetail> orderDetails;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public float getUnitPrice() {
		return UnitPrice;
	}

	public void setUnitPrice(float unitPrice) {
		UnitPrice = unitPrice;
	}

	public String getImage() {
		return Image;
	}

	public void setImage(String image) {
		Image = image;
	}

	public Date getProductDate() {
		return ProductDate;
	}

	public void setProductDate(Date productDate) {
		ProductDate = productDate;
	}

	public boolean isAvailable() {
		return Available;
	}

	public void setAvailable(boolean available) {
		Available = available;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public String getDesctiption() {
		return Desctiption;
	}

	public void setDesctiption(String desctiption) {
		Desctiption = desctiption;
	}

	public double getDiscount() {
		return Discount;
	}

	public void setDiscount(double discount) {
		Discount = discount;
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
