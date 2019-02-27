package com.atgs.apo.Impl;


import java.util.Arrays;
import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(3)
@Aspect
@Component
public class LogginAspect {
	@Pointcut("execution(public int com.atgs.apo.Impl.AtithmeticCalculatorImpl.*(..))")
	public void declareJointPointExpression(){}
	@Before("declareJointPointExpression()")
	//"execution(* com.atgs.apo.Impl.*.*(int , int ))"
	//@Before("execution(public int com.atgs.apo.Impl.AtithmeticCalculatorImpl.*(int , int ))")
	public void beforeMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		Object [] args =joinPoint.getArgs();
		System.out.println("the method "+methodName+" begins with"+Arrays.asList(args));
	}
	@Before("declareJointPointExpression()")
	//@After("execution(public int com.atgs.apo.Impl.AtithmeticCalculatorImpl.*(..))")
	//@After("execution(public int com.atgs.apo.Impl.AtithmeticCalculatorImpl.*(int , int ))")
	public void afterMethod(JoinPoint joinPoint){
		String methodName = joinPoint.getSignature().getName();
		//Object [] args =joinPoint.getArgs();
		System.out.println("the method "+methodName+" end ");
	}
	@AfterReturning(value="declareJointPointExpression()",
			returning="result")
	public void afterRunning(JoinPoint joinPoint,Object result){
		String methodName = joinPoint.getSignature().getName();
		System.out.println("the method "+methodName+" ends with " +result);
	}
	@AfterThrowing(value="declareJointPointExpression()", throwing="ex")
	public void afterThrowing(JoinPoint joinPoint,Exception ex){
		String methodName=joinPoint.getSignature().getName();
		System.out.println("the method "+methodName +" occurs exception with "+ ex );
	}
	
	
}
