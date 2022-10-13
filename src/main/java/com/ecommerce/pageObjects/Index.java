package com.ecommerce.pageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Actions_Page;
public class Index 
{
	WebDriver ldriver;	
	Actions_Page action= new Actions_Page();
	public Index(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//a[@class='login']") 
	 WebElement signInBtn;
	
	@FindBy(xpath = "//img[@class='logo img-responsive']")
	 WebElement myStoreLogo;
	
	@FindBy(id="search_query_top")
	 WebElement searchProductBox;
	
	@FindBy(name="submit_search")
	 WebElement searchButton;
	
	public boolean verify_searchbox()
	{
		return action.isDisplayed(ldriver,myStoreLogo);
		
	}	
	public void click_signin()
	{
		signInBtn.click();
	}

}
