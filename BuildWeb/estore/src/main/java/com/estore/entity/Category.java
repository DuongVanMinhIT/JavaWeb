package com.estore.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity @Table(name="Category")
public class Category {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)//tu tang
	private int id;
	private String Name;
	private String NameVN;
	
	@OneToMany(mappedBy = "category", fetch = FetchType.EAGER)
	List<Product> products;

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

	public String getNameVN() {
		return NameVN;
	}

	public void setNameVN(String nameVN) {
		NameVN = nameVN;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
}
