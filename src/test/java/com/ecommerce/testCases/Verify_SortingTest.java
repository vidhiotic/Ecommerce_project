package com.ecommerce.testCases;

import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.Login;
import com.ecommerce.pageObjects.SummerDresses;
import com.ecommerce.pageObjects.Verify_Sorting;

public class Verify_SortingTest extends BaseClass
{
	@Test(priority=0)
	public void Verify_SortingTestStarted()
	{
		logger.info("------------------Verify_SortingTest case started------------------");
	}
	
	
	@Test(priority=1,dataProvider="LoginData",dataProviderClass = Actions_Page.class)
	public void verify(String email,String password) throws Exception
	{
		Login lg=new Login(driver);
		lg.click_signin();	
		logger.info("Sign in is clicked");
		lg.login(email, password);
		logger.info("Successfully signed in");
		lg.verify_loggedinPage();
		logger.info("Logged in page verified");
		SummerDresses sd=new SummerDresses(driver);
		sd.click_women();
		logger.info("women clickedd");
		Verify_Sorting vs=new Verify_Sorting(driver);
		vs.applySorting();
		logger.info("sorting applied");
		boolean flag=vs.verifysorting();
		if(flag)
		{
			logger.error("Sorting is right on this page.Hence fail");
			fail();
		}
		else
		{
			logger.error("Sorting is broken on this page.Hence verified");
		}
		logger.info("-----------------Verify_SortingTest case ended------------------");	
	}
	
	
	

}
