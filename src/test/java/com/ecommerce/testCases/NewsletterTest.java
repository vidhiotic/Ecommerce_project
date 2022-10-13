package com.ecommerce.testCases;
import static org.testng.Assert.fail;

import org.testng.annotations.Test;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.AccountCreation;
import com.ecommerce.pageObjects.Newsletter;

public class NewsletterTest extends BaseClass
{
	Actions_Page action= new Actions_Page();
	
	@Test
	public void Newsletter_Test() throws InterruptedException
	{
		logger.info("------------------NewsLetterTest started---------------");
		logger.info("URL is opened");
		AccountCreation ac=new AccountCreation(driver);
		String email=ac.randomEmailGenerator();
		Newsletter nl=new Newsletter(driver);
		boolean flag=nl.verify_newletter();
		if(flag)
		{
			logger.info("Newsletter field is verified");
		}
		else
		{
			fail();
		}
		nl.newsletterclick(email);
		nl.verify_alert();
		
		logger.info("-----------------NewsLetterTest ended-------------------");
		
		
	}
	

}
