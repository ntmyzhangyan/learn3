package com.atgs.apo.helloWord;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

import com.atgs.apo.Impl.AtithmeticCalculator;

public class ArithmeticCalcalatorLogginProxy {
	//Ҫ����Ķ���
	private AtithmeticCalculator target;
	 
	public ArithmeticCalcalatorLogginProxy(AtithmeticCalculator target){
		this.target=target;
	}
	
	public AtithmeticCalculator getLoggingProxy(){
		AtithmeticCalculator proxy=null;
		//�����������һ����������������
		ClassLoader loader =target.getClass().getClassLoader();

		System.out.println("load"+loader.toString());
		//�������������Щ����
		Class [] interfaces = new Class[]{AtithmeticCalculator.class};
		
		//�����ô������ķ���ʱ��ִ�иô���
		InvocationHandler h = new InvocationHandler() {
			/**
			 * proxy:���ڷ��ص��Ǹ��������һ������£���invoke �����ж���ʹ�øö���
			 * method�����ڱ����õķ���
			 * args:���÷���ʱ������Ĳ���
			 * 
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
				//���ش� Method �����ʾ�ķ�������
				String methodName=method.getName();
				//��־
				System.out.println("The method "+methodName +"begins with" +Arrays.asList(args));
				//ִ�з���
				Object result=null;
				try {
					//ǰ��֪ͨ
					result =method.invoke(target, args);
					//����֪ͨ�����Է��ʵ������ķ���ֵ
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					//�쳣֪ͨ�����ʵ��쳣��֪ͨ
				}
				//����֪ͨ����Ϊ�������ܳ��쳣�����Է��ʲ��������ķ���ֵ
				System.out.println(methodName +"end with" +result);
				return result;
			}
		};
		System.out.println("h:"+h);
		proxy=(AtithmeticCalculator) Proxy.newProxyInstance(loader, interfaces, h);
		return proxy;	
		
	}
		
}
