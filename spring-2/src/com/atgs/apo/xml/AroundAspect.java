package com.atgs.apo.xml;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

public class AroundAspect {
	
	public Object aroundMethod(ProceedingJoinPoint point){
		Object result=null;
		String methodName=point.getSignature().getName();
	
		try {
			System.out.println("The method "+methodName+" begin with" +Arrays.asList(point.getArgs()));
			result=point.proceed();
			System.out.println("the method "+methodName+" ends with " +result);
		} catch (Throwable e) {
			System.out.println("the method "+methodName +" occurs exception with "+ e);
			throw new RuntimeException(e);
		}
		
		System.out.println("the method "+methodName+" ends");
		
		return result;
		
	}
}
