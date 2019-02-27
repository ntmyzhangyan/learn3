package com.atgs.apo.helloWord;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.atgs.apo.Impl.AtithmeticCalculator;

public class ArithmeticCalcalatorLogginProxy {
	//要代理的对象
	private AtithmeticCalculator target;
	 
	public ArithmeticCalcalatorLogginProxy(AtithmeticCalculator target){
		this.target=target;
	}
	
	public AtithmeticCalculator getLoggingProxy(){
		AtithmeticCalculator proxy=null;
		//代理对象由哪一个类加载器负责加载
		ClassLoader loader =target.getClass().getClassLoader();

		System.out.println("load"+loader.toString());
		//代理对象中有哪些方法
		Class [] interfaces = new Class[]{AtithmeticCalculator.class};
		
		//当调用代理对象的方法时，执行该代码
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:正在返回的那个代理对象，一般情况下，在invoke 方法中都不使用该对象
			 * method：正在被调用的方法
			 * args:调用方法时，传入的参数
			 * 
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//返回此 Method 对象表示的方法名称
				String methodName=method.getName();
				//日志
				System.out.println("The method "+methodName +"begins with" +Arrays.asList(args));
				//执行方法
				Object result=null;
				try {
					//前置通知
					result =method.invoke(target, args);
					//返回通知，可以访问到方法的返回值
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//异常通知，访问到异常的通知
				}
				//后置通知，因为方法可能出异常，所以访问不到方法的返回值
				System.out.println(methodName +"end with" +result);
				return result;
			}
		};
		System.out.println("h:"+h);
		proxy=(AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;	
		
	}
		
}
