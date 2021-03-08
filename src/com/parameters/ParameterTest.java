package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	WebDriver driver;
	
	@Test
	@Parameters({"url","emailId"}) 
	public void yahooLoginTest(String url, String emailId) {
	 System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
	 driver = new ChromeDriver();
	 driver.get(url);
	 driver.findElement(By.xpath("//input[@id='login-username']")).clear();
	 driver.findElement(By.xpath("//input[@id='login-username']")).sendKeys(emailId);
	 driver.findElement(By.xpath("//input[@name='signin']")).click();
	}
	

}
