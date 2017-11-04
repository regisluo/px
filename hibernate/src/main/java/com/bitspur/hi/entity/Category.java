package com.bitspur.hi.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="TCategory")
public class Category implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String name;
	
	@ManyToMany
	@JoinTable(name="category_product", 
	joinColumns={@JoinColumn(name="category_id",referencedColumnName="id")},
	inverseJoinColumns={@JoinColumn(name="product_id", referencedColumnName="id")})
	private List<Product> products;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Category() {
		// TODO Auto-generated constructor stub
	}

	public Category(String name, List<Product> products) {
		super();
		this.name = name;
		this.products = products;
	}

}
