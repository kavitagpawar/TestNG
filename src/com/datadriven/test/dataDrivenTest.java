package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.excel.utility.Xls_Reader;

public class dataDrivenTest {

	public static void main(String[] args) throws InterruptedException {
		
	
		
		Xls_Reader xlsreader = new Xls_Reader("C:\\Eclipse_Program\\OnlineSelenium\\src\\com\\testData\\TescoRegTestData.xlsx");
		String  email =xlsreader.getCellData("RegTestData","email",2);
		String  pswd =xlsreader.getCellData("RegTestData","password",2);
		String  title =xlsreader.getCellData("RegTestData","title",2);
		String  firstname =xlsreader.getCellData("RegTestData","firstname",2);
		String  lastname =xlsreader.getCellData("RegTestData","lastname",2);
		String  phone =xlsreader.getCellData("RegTestData","phone",2);
		String  postcode =xlsreader.getCellData("RegTestData","postcode",2);
		
		
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://secure.tesco.com/account/en-GB/register");
		Thread.sleep(3000);
		driver.manage().window().maximize();
		driver.findElement(By.id("username")).sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(pswd);	
		driver.findElement(By.id("title")).sendKeys(title);
		driver.findElement(By.name("first-name")).sendKeys(firstname);
		driver.findElement(By.name("last-name")).sendKeys(lastname);
		driver.findElement(By.name("phone-number")).sendKeys(phone);
		driver.findElement(By.name("postcode")).sendKeys(postcode);
		
		
	}
		

}


