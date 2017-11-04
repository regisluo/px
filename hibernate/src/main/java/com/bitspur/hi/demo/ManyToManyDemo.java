package com.bitspur.hi.demo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Category;
import com.bitspur.hi.entity.Product;
import com.bitspur.hi.util.JpaUtil;

public class ManyToManyDemo {
	public static void main(String[] args) {
		Category category1 = new Category("Table", null);
		Category category2 = new Category("OfficeWork", null);

		List<Category> categories = new ArrayList<Category>();
		categories.add(category1);
		categories.add(category2);

		Product table1 = new Product("table1", categories);
		Product table2 = new Product("table2", categories);

		List<Product> products = new ArrayList<Product>();
		products.add(table1);
		products.add(table2);

		category1.setProducts(products);
		category2.setProducts(products);

		table1.setCategories(categories);
		table2.setCategories(categories);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();

		em.persist(category1);
		em.persist(category2);
		em.persist(table1);
		em.persist(table2);

		tx.commit();
		JpaUtil.close(em);

	}
}
