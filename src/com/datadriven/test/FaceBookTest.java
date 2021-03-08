package com.datadriven.test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.test.utility.TestUtil;

public class FaceBookTest {
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", "./driver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.get("https://secure.tesco.com/account/en-GB/register");
		
	}
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> MyData= TestUtil.getDataFromExcel();
		return MyData.iterator();
	}
	
	@Test(dataProvider="getTestData")
	public void tescoRegistTest(String email,String pswd, String title, String firstname, String lastname, String phone, String postcode) {
		
		driver.findElement(By.id("username")).clear();
		driver.findElement(By.id("username")).sendKeys(email);
		
		driver.findElement(By.id("password")).clear();
		driver.findElement(By.id("password")).sendKeys(pswd);	
		
		Select select = new Select(driver.findElement(By.id("title")));
		select.selectByVisibleText(title);		
		
		driver.findElement(By.name("first-name")).clear();
		driver.findElement(By.name("first-name")).sendKeys(firstname);
		
		driver.findElement(By.name("last-name")).clear();
		driver.findElement(By.name("last-name")).sendKeys(lastname);
		
		driver.findElement(By.name("phone-number")).clear();
		driver.findElement(By.name("phone-number")).sendKeys(phone);
		
		driver.findElement(By.name("postcode")).clear();
		driver.findElement(By.name("postcode")).sendKeys(postcode);
		
	}
	

	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
