package com.tetng;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGBasics {
	
	// Pre-condition annotation -- starting with @Before
	@BeforeSuite //1
	public void setproperty() {
		System.out.println("Set system property");
	}
	
	@BeforeTest()//2
	public void launchBrowser() {
		System.out.println("launch the Browser");
	}
	
	@BeforeClass//3
	public void login() {
		System.out.println("login to app");
	}
	
	@BeforeMethod()//4
	public void enterurl() {
		System.out.println("Enter URL");
	}
	/*
	 * @beforeMethod
	 * @Test -1
	 * @AfterTest
	 * 
	 * @beforeMethod
	 * @Test --2
	 * @Aftertest
	 * 
	 * @beforeMethod
	 * @Test --3
	 * @Aftertest
	 * 
	 */
	
	@Test//5
	public void getTitle() {
		System.out.println("Title of webpage");
	}
	
	@Test
	public void searchTest() {
		System.out.println("search Test");
	}
	
	@Test
	public void googleLogoTest() {
		System.out.println("Google Logo Test");
	}
	
	
	@AfterMethod//6
	public void logOut() {
		System.out.println("Log out from app");
	}
	
	@AfterClass//7
	public void closeBrowser() {
		System.out.println("close the Browser");
	}
	
	@AfterTest//8
	public void deleteCookies() {
		System.out.println("delete cookies");
	}
	
	
	@AfterSuite//9
	public void generateTestReport() {
		System.out.println("generate Test Report");
	}
	
	
}
