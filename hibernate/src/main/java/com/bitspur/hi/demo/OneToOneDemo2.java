package com.bitspur.hi.demo;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.bitspur.hi.entity.Department;
import com.bitspur.hi.entity.Department2;
import com.bitspur.hi.entity.Manger;
import com.bitspur.hi.entity.Manger2;
import com.bitspur.hi.util.JpaUtil;

public class OneToOneDemo2 {
	public static void main(String[] args) {
		Department2 department = new Department2("HR");
		Manger2 manger = new Manger2("Jim","Green",30,"0421011111");
		department.setManger(manger);
		manger.setDepartment(department);
	
		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		
		
		em.persist(department);
		tx.commit();

		tx.begin();
		manger.setId(department.getId());
		em.persist(manger);
		
		tx.commit();
		JpaUtil.close(em);
	}
}
