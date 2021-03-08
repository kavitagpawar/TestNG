package com.tetng;

import org.testng.annotations.Test;

public class TestNGFeatures {
	// if loginTest pass then other test case will be excuted  else ignored

	@Test
	public void loginTest() {
		System.out.println("Login test");
		int i =9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest() {
		System.out.println("Home Page test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void searchPageTest() {
		System.out.println("Search Page test");
	}
	

}
