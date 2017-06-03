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
				
				System.out.println(DateFormat.getDateInstance().format(new Date())+",调用了"+arg1.getName()+",参数为"+Arrays.toString(arg2));
				  Object o=arg1.invoke(i, arg2);
				  System.out.println("返回值为："+o);
				return o;
			}
		});*/
		
		ICalc i2 =(ICalc)new LogHandler(i).newProxy();
		i2=(ICalc)new ValidateHandler(i2).newProxy();
		System.out.println(i2.add(1, -3)+"	"+i2.multi(1, 3));
	}
}
