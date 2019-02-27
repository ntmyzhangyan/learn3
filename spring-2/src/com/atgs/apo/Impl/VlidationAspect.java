package com.atgs.apo.Impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1) //值越小，优先级越高
@Aspect
@Component
public class VlidationAspect {
	@Before("LogginAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("vlidate:"+Arrays.asList(joinPoint.getArgs()));
	}
}
