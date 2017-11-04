package com.bitspur.hi.demo;


import com.bitspur.hi.entity.ContractEmployee2;
import com.bitspur.hi.entity.Employee2;
import com.bitspur.hi.entity.PermanentEmployee2;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class EmployeeJointTableDemo {
	public static void main(String[] args) {
		Employee2 employee2 = new Employee2();
		PermanentEmployee2 permanentEmployee2 = new PermanentEmployee2("Jim", new BigDecimal(80000),new BigDecimal
				(2000));

		ContractEmployee2 contractEmployee2 = new ContractEmployee2("Tom", new BigDecimal(500), (short)12);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(permanentEmployee2);
		em.persist(contractEmployee2);
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
