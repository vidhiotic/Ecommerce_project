package com.ecommerce.testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.Index;

public class IndexTest extends BaseClass
{
	
	@Test
	public void verify_indexPage() throws InterruptedException
	{
		//driver.get(baseurl);
		logger.info("------------------------IndexTest started-----------------");
		logger.info("URL is opened");
		Index In=new Index(driver);
		boolean result=In.verify_searchbox();
		Assert.assertTrue(result);
		logger.info("Search box is verified");
		if(driver.getTitle().equals("My Store"))
		{
			Assert.assertTrue(true);
		}
		else
		{
			Assert.assertTrue(false);
		}
		
		In.click_signin();
		logger.info("Signin clicked");
		logger.info("----------------- IndexTest ended-------------------");
	
	}
	

}
