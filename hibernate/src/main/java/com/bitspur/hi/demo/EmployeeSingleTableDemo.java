package com.bitspur.hi.demo;


import com.bitspur.hi.entity.ContractEmployee;
import com.bitspur.hi.entity.PermanentEmployee;
import com.bitspur.hi.util.JpaUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.math.BigDecimal;

public class EmployeeSingleTableDemo {
	public static void main(String[] args) {
		PermanentEmployee permanentEmployee = new PermanentEmployee("Jim", new BigDecimal(80000), new BigDecimal
				(2000));

		ContractEmployee contractEmployee = new ContractEmployee("Tom", new BigDecimal(500), (short) 6);

		EntityManager em = JpaUtil.getEm();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(permanentEmployee);
		em.persist(contractEmployee);
		tx.commit();
		em.close();
		JpaUtil.close();
	}
}
