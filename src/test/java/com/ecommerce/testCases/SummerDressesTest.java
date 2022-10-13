package com.ecommerce.testCases;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.Login;
import com.ecommerce.pageObjects.SummerDresses;

public class SummerDressesTest extends BaseClass
{
	@Test(priority=0)
	public void SummerDressesTestStarted()
	{
		logger.info("-----------------SummerDressesTest case started----------------");
	}
	
	@Test(priority=1,dataProvider="LoginData",dataProviderClass = Actions_Page.class)
	public void login(String Email,String password)throws Exception
	{

		Login lg=new Login(driver);
		lg.click_signin();	
		logger.info("Sign in is clicked");
		lg.login(Email, password);
		logger.info("Successfully signed in");
		lg.verify_loggedinPage();	
		logger.info("Logged in page verified");
		
		SummerDresses sd=new SummerDresses(driver);
		sd.click_women();
		logger.info("women clickedd");
			boolean filters_flag=sd.verify_filters();
		if(filters_flag)
		{
			logger.info("Filters on summerdress page are verified");;
		}
		else
		{
			fail();
		}
		sd.verify_filters();
		logger.info("-----------------SummerDressesTest case ended-----------------");  
	}
	

}

