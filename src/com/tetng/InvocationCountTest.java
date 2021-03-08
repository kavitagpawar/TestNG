package com.tetng;

import org.testng.annotations.Test;

public class InvocationCountTest {
	// execute same test for 10 times
	@Test(invocationCount=3)
	public void sum() {
		int a =10;
		int b =20;
		int c = a+b;
		System.out.println("sum is  == " + c);
	}
	
	
	
}
