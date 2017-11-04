package com.bitspur.hi.demo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Department;
import com.bitspur.hi.entity.Manger;
import com.bitspur.hi.util.JpaUtil;

public class OneToOneDemo {
	public static void main(String[] args) {
		Department department = new Department("HR");
		Manger manger = new Manger("Jim","Green",30,"0421011111");
		department.setManger(manger);
		manger.setDepartment(department);
	
		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		em.persist(manger);
		em.persist(department);
		
		tx.commit();
		JpaUtil.close(em);
	}
}
