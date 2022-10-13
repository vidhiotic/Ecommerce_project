package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class Newsletter extends BaseClass
{
	WebDriver ldriver;
	Actions_Page action= new Actions_Page();
	public Newsletter(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(id = "newsletter-input") 
	 WebElement newsletter;
	
	@FindBy(name = "submitNewsletter") 
	 WebElement newsletterSubmit;
	
	@FindBy(className = "alert") 
	 WebElement alertmessage;
	
	public boolean verify_newletter()
	{
		boolean flag=action.isDisplayed(ldriver, newsletter);
		return flag;
	}
	public void newsletterclick(String email)
	{
		
		action.type(newsletter, email);
		logger.info("Random email entered");
		action.click(ldriver,newsletterSubmit );
		logger.info("Submit button clicked");
	}
	
	public void verify_alert()
	{
		 String expectedAlertMessage = "Newsletter : You have successfully subscribed to this newsletter.";
		String actualAlertMessage = alertmessage.getText();
		  Assert.assertEquals(expectedAlertMessage, actualAlertMessage);
	}
}
	

