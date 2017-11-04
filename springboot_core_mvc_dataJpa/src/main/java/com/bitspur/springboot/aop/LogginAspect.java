package com.bitspur.springboot.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LogginAspect {
	/*
	 * // before advice
	 * 
	 * @Before("execution(* com.bitspur.springboot.service.Calculator.*(..))")
	 * public void beforeLog(JoinPoint joinPoint) {
	 * System.out.println(joinPoint.getSignature().getName() +
	 * " before advice from aop..."); }
	 * 
	 * // after advice
	 * 
	 * @After("execution(* com.bitspur.springboot.service.Calculator.*(..))")
	 * public void afterLog(JoinPoint joinPoint) {
	 * System.out.println(joinPoint.getSignature().getName() +
	 * " after advice from aop..."); }
	 * 
	 * // afterReturning advice
	 * 
	 * @AfterReturning(pointcut =
	 * "execution(* com.bitspur.springboot.service.Calculator.*(..))", returning
	 * = "result") public void afterReturningLog(JoinPoint joinPoint, Object
	 * result) { System.out.println(joinPoint.getSignature().getName() +
	 * " afterReturning advice from aop, " + "and the calculated value is: " +
	 * result); }
	 * 
	 * @AfterThrowing(pointcut =
	 * "execution(* com.bitspur.springboot.service.Calculator.*(..))", throwing
	 * = "e") public void afterThrowingLog(JoinPoint joinPoint, Exception e) {
	 * System.out.println(joinPoint.getSignature().getName() +
	 * " afterThrowing advice from aop, and exception is " + e.getMessage()); }
	 */

	// around advice
	@Around("execution(* com.bitspur.springboot.service.Calculator.*(..))")
	public Object around(ProceedingJoinPoint point) {

		Object result = null;
		System.out.println("before from around aspect...");
		try {
			result = point.proceed();
			System.out.println("Got result is: " + result);
		} catch (Throwable e) {
			System.out.println("exception from around aspect...");
			e.printStackTrace();
		}
		System.out.println("after from around aspect...");
		// result = 5;
		return result;

	}

}
