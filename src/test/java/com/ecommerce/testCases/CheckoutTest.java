package com.ecommerce.testCases;
import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;
import com.ecommerce.pageObjects.Checkout;

import org.testng.annotations.Test;

import static org.testng.Assert.fail;

import org.testng.Assert;

public class CheckoutTest extends BaseClass
{
	@Test(priority=0)
	public void checkoutTestStarted()
	{
		logger.info("-----------------Checkout case started-----------------");
	}
	

	
	@Test(priority=1,dataProvider="LoginData",dataProviderClass = Actions_Page.class)
	public void login(String Email,String password)throws Exception
	{
		
		Checkout co=new Checkout(driver);
		co.checkout();
		logger.info("Sign in is clicked");
		co.login_enter(Email,password);
		logger.info("Successfully signed in");	
		boolean flag=co.verify_loggedinPage();
		if(flag)
		{
			logger.info("Looged in page verified");
		}
		else
		{
			fail();
		}
		logger.info("-----------------LoginTest Ended----------------");
		co.click_women();
		logger.info("women clickedd");
	}
	
	@Test(priority=2,dataProvider = "getProduct", dataProviderClass = Actions_Page.class)
	public void endtoendTest(String qty, String size) throws Throwable
	{
		Checkout co=new Checkout(driver);
		co.enterQuantity(qty);
		logger.info("Quantity is entered");
		co.selectSize(size);
		logger.info("Size is entered");
		co.clickOnAddToCart();
		logger.info("Add to cart is clicked");
		co.clickOnCheckOut();
		logger.info("Checkout is clicked");
		co.clickOnProceed();
		logger.info("proceed is clicked");
		co.address();
		logger.info("Address is selected");
			co.checkTheTerms();
		logger.info("Terms are clicked");
		logger.info("proceed is clicked");
	}
	
	@Test(priority=3)
	public void order_confirmation() throws Throwable
	{
		Checkout co=new Checkout(driver);
		co.clickOnPaymentMethod();
		logger.info("payments methood  is selected");
		co.clickOnconfirmOrderBtn();
		logger.info("Order is confirmed");
		String message=co.validateConfirmMessage();	
		String expectedMsg="Your order on My Store is complete.";
		Assert.assertEquals(message, expectedMsg);
		logger.info("Order confirmation is verified");
		logger.info("---------------------CheckoutTest ended----------------");
	}
	
	
	
	}

