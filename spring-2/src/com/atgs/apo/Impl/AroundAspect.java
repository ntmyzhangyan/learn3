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
	
	//����һ�������������������ʽ��һ��أ��õط����ڲ���Ҫ��������Ĵ��� ʹ��@Pointcut�������������ʽ
	//���������ֱ֪ͨ��ʹ�÷����������õ�ǰ���������ʽ
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
