package com.datadriven.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.excel.utility.Xls_Reader;

public class ParameterizedTest {

	public static void main(String[] args) throws InterruptedException {
		//webdriver code
		System.setProperty("webdriver.chrome.driver","./driver/chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		Thread.sleep(3000);
		driver.get("https://secure.tesco.com/account/en-GB/register");
		
		// get data from excel
		Xls_Reader xlsreader = new Xls_Reader("C:\\Eclipse_Program\\OnlineSelenium\\src\\com\\testData\\TescoRegTestData.xlsx");
		xlsreader.addColumn("RegTestData", "status");
		//Parameterisation
		for (int i= 2 ; i < xlsreader.getRowCount("RegTestData"); i++)
		{
			String  email =xlsreader.getCellData("RegTestData","email",i);
			String  pswd =xlsreader.getCellData("RegTestData","password",i);
			System.out.println(pswd);
			String  title =xlsreader.getCellData("RegTestData","title",i);
			String  firstname =xlsreader.getCellData("RegTestData","firstname",i);
			String  lastname =xlsreader.getCellData("RegTestData","lastname",i);
			String  phone =xlsreader.getCellData("RegTestData","phone",i);
			String  postcode =xlsreader.getCellData("RegTestData","postcode",i);
			
			
			//enter data
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
			
			xlsreader.setCellData("RegTestData", "status", i, "Pass");
		
			
		}
		
		
	}

}
