package com.ecommerce.pageObjects;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class Verify_Sorting extends BaseClass
{

	WebDriver ldriver;
	
	Actions_Page action= new Actions_Page();
	
	public Verify_Sorting(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/ul/li[1]/div/div/div[3]/div/div[1]/span[1]") 
	 WebElement price_1;
	
	@FindBy(xpath = "//*[@id=\"list\"]/a/i") 
	 WebElement list;
	
	
	public void applySorting() throws InterruptedException
	{
		String value="Price: Lowest first";
		Select drpdown=new Select(ldriver.findElement(By.id("selectProductSort")));
		drpdown.selectByVisibleText(value);
		action.scrollByVisibilityOfElement(ldriver, list);
		action.click(ldriver, list);
		

	}
	
	public boolean verifysorting()
	{
		List<WebElement> list_1=driver.findElements(By.className("price"));
		int n=list_1.size();
	/*	for(int i=0;i<n;i++)
		{
			String s=list_1.get(i).getText();
			System.out.println(s);
		}*/
		String[] list=new String[n];
		String[] list_copy=new String[n];
		
		for(int i=0;i<n;i++)
		{
			String s=list_1.get(i).getText();
			list[i]=s;	
			list_copy[i]=s;
		}
		Arrays.sort(list_copy);
	/*	System.out.println("List......");
		for(int i=0;i<n;i++)
		{
			System.out.println(list[i]);
		}
		
		System.out.println("List copy sorted......");
		for(int i=0;i<n;i++)
		{
			System.out.println(list_copy[i]);
		}*/
		boolean flag=Arrays.equals(list, list_copy);
		return flag;


	}
	

}
