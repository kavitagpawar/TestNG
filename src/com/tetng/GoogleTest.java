package com.tetng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleTest {
	
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

	@Test(priority=1, groups="Search")
	public void search() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='CwaK9']//span[contains(text(),'I agree')]")).click();
		
		driver.findElement(By.xpath("//input[@name='q']")).sendKeys("testing");
		java.util.List<WebElement> list= driver.findElements(By.xpath("//ul[@role='listbox']//li//descendant::div[@class='sbl1']"));
		
		System.out.println("total nmber of suggestion" + list.size());
		
		for(int i =0 ; i< list.size();i++) {
			System.out.println(list.get(i).getText());
			if(list.get(i).getText().equals("testing centres near me")) {
				list.get(i).click();
				break;
			}
		}
	}
	
	@Test(priority=3, groups="logo")
	public void logoTest() {
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//span[@class='CwaK9']//span[contains(text(),'I agree')]")).click();
		boolean b = driver.findElement(By.xpath("//*[@id= 'hplogo']")).isDisplayed();
		System.out.println(b);
	}
	
	@Test(priority=2, groups="title")
	public void getTitle() {
		String title = driver.getTitle();
		System.out.println("Title is" + title);
		
	}
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
