package com.ecommerce.testCases;
import static org.testng.Assert.fail;
import org.testng.annotations.Test;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.Login;

public class LoginTest extends BaseClass
{
	@Test(priority=0)
	public void LoginTestStarted()
	{
		logger.info("---------------LoginTest case started--------------");
	}
	
	@Test(priority=1,dataProvider="LoginData",dataProviderClass = Actions_Page.class)
	public void loginDetails(String Email,String password) throws InterruptedException
	{
		logger.info("URL opened for logindetails");
		Login lg=new Login(driver);
		lg.click_signin();
		logger.info("Signin clicked");
		lg.login(Email, password);
		logger.info("Credentials entered");
		boolean flag=lg.verify_loggedinPage();
		if(flag)
		{
			logger.info("Looged in page verified");
		}
		else
		{
			fail();
		}
		logger.info("----------------LoginTest Ended----------------");
		
	}
}
