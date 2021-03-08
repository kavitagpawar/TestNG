package com.tetng;

import org.testng.annotations.Test;

public class ExceptionTimeOutTest {
	// timeout is used to end the test test
	//to handle the exception
//	@Test(invocationTimeOut=2, expectedExceptions=NumberFormatException.class)
//	public void infiniteLoopTest() {
//		int i =1;
//		while(i==1)
	//	{
//			System.out.println(i);
	//	}
		
//	}
	@Test(expectedExceptions= NumberFormatException.class)
	public void test1() {
		
		String x = "100A";
		Integer.parseInt(x);
	}
}
