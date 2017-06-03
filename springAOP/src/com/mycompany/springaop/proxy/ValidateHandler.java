package com.mycompany.springaop.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.text.DateFormat;
import java.util.Arrays;
import java.util.Date;

public class ValidateHandler implements InvocationHandler {

	     private Object targe;      
	     
	public ValidateHandler(Object targe) {
			super();
			this.targe = targe;
		}

	@Override
	public Object invoke(Object arg0, Method arg1, Object[] arg2)
			throws Throwable {
	 
		      for(Object c:arg2)
		      {
		    	  if(Integer.valueOf(c.toString())<0)
		    	  {
		    		  throw new Exception("算法中不能有副数");
		    	  }
		      }
		       
		      Object o=arg1.invoke(targe, arg2);
		return o;
		
	}
	
	public Object newProxy(){
		return Proxy.newProxyInstance(targe.getClass().getClassLoader(), targe
				.getClass().getInterfaces(), this);
	}

}
