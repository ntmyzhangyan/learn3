package com.atgs.apo.xml;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		//1.创建spring IOC容器
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext-xml.xml");
		
		//2.从容器中取出bean实例
		AtithmeticCalculator atithmeticCalculator = (AtithmeticCalculator) ctx.getBean(AtithmeticCalculator.class);
		//3.使用bean
		int result=atithmeticCalculator.add(2,3);
		System.out.println(result);
		result=atithmeticCalculator.div(6,1);
		System.out.println(result);
	}
}
