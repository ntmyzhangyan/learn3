package com.atgs.apo.xml;

import java.util.Arrays;
import org.aspectj.lang.JoinPoint;


public class VlidationAspect {

	public void validateArgs(JoinPoint joinPoint){
		System.out.println("vlidate:"+Arrays.asList(joinPoint.getArgs()));
	}
}
