package com.test.utility;

import java.util.ArrayList;

import com.excel.utility.Xls_Reader;
//utilty class for faceBookTest.java
public class TestUtil {
	static Xls_Reader xlsreader;
	public static ArrayList<Object[]> getDataFromExcel(){
		
		ArrayList<Object[]> myData = new ArrayList<Object[]>();
		try {
			 xlsreader = new Xls_Reader("C:\\Eclipse_Program\\TestNg\\src\\com\\testData\\TescoRegTestData.xlsx");
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
			
			Object ob[] = {email,pswd,title,firstname,lastname,phone,postcode};
			myData.add(ob);
		
		}
		return myData;
	}
	
}
