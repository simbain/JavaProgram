package com.mycompany.springaop.proxy;

public class ICalcImpl implements ICalc{

	@Override
	public int add(int num, int num2) {
		return num+num2;
	}

	@Override
	public int multi(int num, int num2) {
		return num*num2;
	}

}
