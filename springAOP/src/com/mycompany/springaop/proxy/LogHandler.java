package com.mycompany.springaop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class LogHandler implements InvocationHandler {

	     private Object targe;      
	     
	public LogHandler(Object targe) {
			super();
			this.targe = targe;
		}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
	
		System.out.println(DateFormat.getDateInstance().format(new Date())+",调用了"
		             +arg1.getName()+",参数为"+
				      Arrays.toString(arg2));
		  Object o=arg1.invoke(targe, arg2);
		  System.out.println("返回值为："+o);
		return o;
		
	}
	
	public Object newProxy(){
		return Proxy.newProxyInstance(targe.getClass().getClassLoader(), targe
				.getClass().getInterfaces(), this);
	}

}
