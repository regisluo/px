package com.bitspur.hi.demo;

import com.bitspur.hi.entity.ContractEmployee3;
import com.bitspur.hi.entity.Employee3;
import com.bitspur.hi.entity.PermanentEmployee3;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;


public class EmployeeTablePerClassDemo {
	public static void main(String[] args) {
		Employee3 employee3 = new Employee3();

		PermanentEmployee3 permanentEmployee3 = new PermanentEmployee3("Jim",new BigDecimal(80000), new BigDecimal
				(2000));

		ContractEmployee3 contractEmployee3 = new ContractEmployee3("Tom", new BigDecimal(500), (short)6);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(permanentEmployee3);
		em.persist(contractEmployee3);
		tx.commit();
		em.close();
		JpaUtil.close();

	}
}
