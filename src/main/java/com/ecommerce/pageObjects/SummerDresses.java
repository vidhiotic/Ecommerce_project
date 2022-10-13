package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class SummerDresses extends BaseClass
{
	WebDriver ldriver;
	Actions_Page action= new Actions_Page();
	
	public SummerDresses(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(className = "sf-with-ul") 
	 WebElement women;
	
	@FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[2]/a") 
	 WebElement dresses;
	
	@FindBy(xpath = "//*[@id=\"categories_block_left\"]/div/ul/li[3]/a") 
	 WebElement summerdress;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div[1]/div/a[1]/img") 
	 WebElement pic_1;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[2]/div/div[1]/div/a[1]/img") 
	 WebElement pic_2;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[3]/div/div[1]/div/a[1]/img") 
	 WebElement pic_3;
	
	@FindBy(id = "selectProductSort") 
	 WebElement dropdown;
	
	
	 public void click_women() throws Exception
	 {
		 action.click(ldriver,women);	
		 action.click(ldriver, dresses);
		 action.click(ldriver, summerdress);
		
		
	 }
	 public boolean verify_filters()
	 {
		boolean flag1= action.isDisplayed(ldriver, pic_1);
		boolean flag2= action.isDisplayed(ldriver, pic_2);
		boolean flag3= action.isDisplayed(ldriver, pic_3);
		if(flag1 && flag2 && flag3)
		{
			return true;
		}
		else
		{
			return false;
		}		 
	 }
	
}
