package com.ecommerce.testCases;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.AccountCreation;
import com.ecommerce.pageObjects.Index;
import com.ecommerce.utilities.XL_Utility;

import static org.testng.Assert.fail;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class AccountcreateTest extends BaseClass
{
		
	@Test
	public void createAccount() throws Throwable
	{
		logger.info("-----------------------AccountCreateTest started-------------------");
		logger.info("URL is opened");
		Index In=new Index(driver);
		In.click_signin();
		logger.info("Signin clicked");
		AccountCreation ac=new AccountCreation(driver);
		boolean result=ac.validateAcountCreatePage();
		Assert.assertTrue(result);
		String email=ac.randomEmailGenerator();
		ac.typeEmail(email);
		logger.info("Random email generated");
	}
	
	@Test(dataProvider="ExcelData")
	public void createNewAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws InterruptedException
	{
		AccountCreation ac=new AccountCreation(driver);
		logger.info("New account creation start");
		boolean flag=ac.createAccount(gender,fName, 
			 lName, 
			pswd, 
			day, 
			 month, 
			 year,
			comPany, 
			 addr, 
			cityString, 
			stateName, 
			 zip, 
			countryName,
			 mobilePhone);
		logger.info("New account created");
		if(flag)
		{
			logger.info("After account creation page is verified");
			
		}
		else
		{
			fail();
		}
		logger.info("--------------------AccountCreateTest ended------------------");
		
		
		
	}
	
	@DataProvider(name="ExcelData")
	public String [][] getExcelDta() throws IOException
	{
		String path=".\\DataFiles\\TestData.xlsx";
		XL_Utility xlutil=new XL_Utility(path);
		int totalrows=xlutil.getRowCount("AccountCreationData");
		int totalcell=xlutil.getCellCount("AccountCreationData",1);
		String Exceldata[][]=new String[totalrows][totalcell];
		
		for(int i=1;i<=totalrows;i++)
		{
			for(int j=0;j<totalcell;j++)
			{
				Exceldata[i-1][j]=xlutil.getCellData("AccountCreationData", i, j);
			}
		}		
		logger.info("Data is fetched from the excel");
		return Exceldata;
		
	}
	

}
