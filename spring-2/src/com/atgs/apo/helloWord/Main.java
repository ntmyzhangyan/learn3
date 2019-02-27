package com.atgs.apo.helloWord;

import com.atgs.apo.Impl.AtithmeticCalculator;
import com.atgs.apo.Impl.AtithmeticCalculatorImpl;

public class Main {
	public static void main(String[] args) {
		AtithmeticCalculator target= new AtithmeticCalculatorImpl();
		AtithmeticCalculator Proxy = new ArithmeticCalcalatorLogginProxy(target).getLoggingProxy();
		 
		int result = Proxy.add(1, 2);
		System.out.println(result);
		result= Proxy.div(4, 2);
		System.out.println(result); 
		
		/*int result =atithmeticCalculator.add(1, 2);
		System.out.println(result);
		result=atithmeticCalculator.div(4, 2);
		System.out.println(result);*/
	}
}
