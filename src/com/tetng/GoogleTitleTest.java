package com.tetng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTitleTest {
	
WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
			System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		    driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
			driver.get("https://www.google.com");	  
	}

	@Test
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title is" + title);
		
		//assert used to check if title is right: validation
		Assert.assertEquals(title, "faceboook","title is not matched");
		Assert.assertEquals(title,"Google");
	}
	
	@Test
	public void logoTest() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='CwaK9']//span[contains(text(),'I agree')]")).click();
		boolean b = driver.findElement(By.xpath("//*[@id= 'hplogo']")).isDisplayed();
		Assert.assertTrue(b);
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}
