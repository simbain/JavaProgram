package com.mycompany.springaop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;


public class Test {
	public static void main(String[] args) {
        
		final ICalc i=new ICalcImpl();
	/*
		ICalc i2 = (ICalc)Proxy.newProxyInstance(i.getClass().getClassLoader(), i.getClass().getInterfaces(),new InvocationHandler() {
			
			@Override
			public Object invoke(Object arg0, Method arg1, Object[] arg2)
					throws Throwable {
				
				System.out.println(DateFormat.getDateInstance().format(new Date())+",������"+arg1.getName()+",����Ϊ"+Arrays.toString(arg2));
				  Object o=arg1.invoke(i, arg2);
				  System.out.println("����ֵΪ��"+o);
				return o;
			}
		});*/
		
		ICalc i2 =(ICalc)new LogHandler(i).newProxy();
		i2=(ICalc)new ValidateHandler(i2).newProxy();
		System.out.println(i2.add(1, -3)+"	"+i2.multi(1, 3));
	}
}
