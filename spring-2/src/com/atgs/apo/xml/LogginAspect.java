package com.atgs.apo.xml;


import java.util.Arrays;
import org.aspectj.lang.JoinPoint;


public class LogginAspect {
	
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args =joinPoint.getArgs();
		System.out.println("the method "+methodName+" begins with"+Arrays.asList(args));
	}
	
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		//Object [] args =joinPoint.getArgs();
		System.out.println("the method "+methodName+" end ");
	}
	
	public void afterRunning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with " +result);
	}
	
	
	public void afterThrowing(JoinPoint joinPoint,Exception e){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("the method "+methodName +" occurs exception with "+ e);
	}
	
	
}
