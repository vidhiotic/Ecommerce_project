package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class Login extends BaseClass
{
	WebDriver ldriver;
	Actions_Page action= new Actions_Page();
	public Login(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@class='login']") 
	 WebElement signInBtn;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1") 
	 WebElement myaccount;
	
	@FindBy(xpath = "//*[@id=\"email\"]") 
	 WebElement emailtext;
	
	@FindBy(xpath = "//*[@id=\"passwd\"]") 
	 WebElement pswrdtext;
	
	@FindBy(className = "icon-lock") 
	 WebElement signin;
	
	public void click_signin()
	{
		signInBtn.click();
	}
	
	public void login(String Email,String password) throws InterruptedException
	{
		action.type(emailtext, Email);
		action.type(pswrdtext, password);
		action.click(ldriver, signin);
	}
	public boolean verify_loggedinPage()
	{
		return action.isDisplayed(ldriver,myaccount);
		
	}
	
	
	
}
