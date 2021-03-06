package net.code.oasa;
// Generated Aug 26, 2020 10:14:19 PM by Hibernate Tools 5.4.12.Final

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Product generated by hbm2java
 */
public class Product implements java.io.Serializable {

	private Integer id;
	private Category category;
	private String name;
	private Float unitPrice;
	private String image;
	private Date productDate;
	private boolean available;
	private int quantity;
	private String desctiption;
	private double discount;
	private int viewCount;
	private boolean special;
	private Set orderDetails = new HashSet(0);
	private Set orderDetails_1 = new HashSet(0);

	public Product() {
	}

	public Product(Category category, String name, String image, Date productDate, boolean available, int quantity,
			String desctiption, double discount, int viewCount, boolean special) {
		this.category = category;
		this.name = name;
		this.image = image;
		this.productDate = productDate;
		this.available = available;
		this.quantity = quantity;
		this.desctiption = desctiption;
		this.discount = discount;
		this.viewCount = viewCount;
		this.special = special;
	}

	public Product(Category category, String name, Float unitPrice, String image, Date productDate, boolean available,
			int quantity, String desctiption, double discount, int viewCount, boolean special, Set orderDetails,
			Set orderDetails_1) {
		this.category = category;
		this.name = name;
		this.unitPrice = unitPrice;
		this.image = image;
		this.productDate = productDate;
		this.available = available;
		this.quantity = quantity;
		this.desctiption = desctiption;
		this.discount = discount;
		this.viewCount = viewCount;
		this.special = special;
		this.orderDetails = orderDetails;
		this.orderDetails_1 = orderDetails_1;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Float getUnitPrice() {
		return this.unitPrice;
	}

	public void setUnitPrice(Float unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getImage() {
		return this.image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Date getProductDate() {
		return this.productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}

	public boolean isAvailable() {
		return this.available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getDesctiption() {
		return this.desctiption;
	}

	public void setDesctiption(String desctiption) {
		this.desctiption = desctiption;
	}

	public double getDiscount() {
		return this.discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public int getViewCount() {
		return this.viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public boolean isSpecial() {
		return this.special;
	}

	public void setSpecial(boolean special) {
		this.special = special;
	}

	public Set getOrderDetails() {
		return this.orderDetails;
	}

	public void setOrderDetails(Set orderDetails) {
		this.orderDetails = orderDetails;
	}

	public Set getOrderDetails_1() {
		return this.orderDetails_1;
	}

	public void setOrderDetails_1(Set orderDetails_1) {
		this.orderDetails_1 = orderDetails_1;
	}

}
