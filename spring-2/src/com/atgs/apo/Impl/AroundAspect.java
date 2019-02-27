package com.atgs.apo.Impl;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1)
@Aspect
@Component
public class AroundAspect {
	
	//定义一个方法，用于切入点表达式，一般地，该地方中在不需要添加其他的代码 使用@Pointcut来声明切入点表达式
	//后面的其他通知直接使用方法名来引用当前的切入点表达式
	@Around("execution(public int com.atgs.apo.Impl.AtithmeticCalculatorImpl.*(..))")
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
