package com.springinaction.springidol;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {
	
	@Pointcut("execution(* com.springinaction.springidol.Performer.perform(..))")
	public void performance(){
	}
	
	@Before("performance()")
	public void takeSeats(){
		System.out.println("The audience is taking their seats.");
	}
	
	@Before("performance()")
	public void turnOffCellPhones(){
		System.out.println("The audience is turning off their cellphones");
	}
	
	@AfterReturning("performance()")
	public void applaud(){
		System.out.println("The audience: CLAP CLAP CLAP CLAP CLAP");
	}

	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("The audience: Boo! We want our money back!");
	}
	
	@Around("performance()")
	public void measurePerformanceDuration(ProceedingJoinPoint joinpoint) {
		System.out.println("The audience is looking on the clock.");
		long start = System.nanoTime();
		try {
			joinpoint.proceed();
		} catch(Throwable t) {
			t.printStackTrace();
		} finally {
			long end = System.nanoTime(); 
			System.out.println("The performance took " + (end - start) / 1000 + " microseconds.");
		}
	}
}