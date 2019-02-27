package com.atgs.apo.Impl;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
@Order(1) //ֵԽС�����ȼ�Խ��
@Aspect
@Component
public class VlidationAspect {
	@Before("LogginAspect.declareJointPointExpression()")
	public void validateArgs(JoinPoint joinPoint){
		System.out.println("vlidate:"+Arrays.asList(joinPoint.getArgs()));
	}
}
