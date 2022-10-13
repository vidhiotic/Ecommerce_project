package com.ecommerce.pageObjects;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class AccountCreation extends BaseClass
{
	
	WebDriver ldriver;
	Actions_Page action= new Actions_Page();
	public AccountCreation(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1")
	 WebElement formTitle;
	
	@FindBy(id = "uniform-id_gender1")
	 WebElement mr;
	
	@FindBy(id = "id_gender2")
	 WebElement mrs;

	@FindBy(name = "customer_firstname")
	 WebElement firstName;

	@FindBy(name = "customer_lastname")
	 WebElement lastName;

	@FindBy(name = "passwd")
	 WebElement passWord;

	@FindBy(name = "days")
	 WebElement days;

	@FindBy(name = "months")
	 WebElement months;

	@FindBy(name = "years")
	 WebElement years;

	@FindBy(name = "firstname")
	 WebElement customerNirstName;

	@FindBy(name = "lastname")
	 WebElement customerLastName;

	@FindBy(name = "company")
	 WebElement companyName;

	@FindBy(name = "address1")
	 WebElement address;

	@FindBy(name = "city")
	 WebElement city;

	@FindBy(name = "id_state")
	 WebElement state;

	@FindBy(name = "postcode")
	 WebElement postCode;

	@FindBy(name = "id_country")
	 WebElement country;

	@FindBy(name = "phone")
	 WebElement phone;

	@FindBy(name = "phone_mobile")
	WebElement mobile;

	@FindBy(name = "alias")
	 WebElement ref;

	@FindBy(name = "submitAccount")
	WebElement registerBtn;
	
	@FindBy(name = "email_create")
	 WebElement createEmail;
	
	@FindBy(className = "icon-user")
	 WebElement register;
	
	@FindBy(xpath = "//*[@id=\"submitAccount\"]/span/i")
	 WebElement registration;
	
	@FindBy(xpath = "//*[@id=\"center_column\"]/h1")
	 WebElement myaccount;
	
	public boolean createAccount(String gender,String fName, 
			String lName, 
			String pswd, 
			String day, 
			String month, 
			String year,
			String comPany, 
			String addr, 
			String cityString, 
			String stateName, 
			String zip, 
			String countryName,
			String mobilePhone) throws InterruptedException
	{
		if(gender.equalsIgnoreCase("Mr")) {
			action.click(ldriver, mr);
		} else {
			action.click(ldriver, mrs);
		}
		
		action.type(firstName, fName);
		action.type(lastName, lName);
		action.type(passWord, pswd);
		action.selectByValue(days, day);
		action.selectByValue(months, month);
		action.selectByValue(years, year);
		action.type(companyName, comPany);
		action.type(address, addr);
		action.type(city, cityString);
		action.selectByVisibleText(stateName, state);
		action.type(postCode, zip);
		action.selectByVisibleText(countryName, country);
		action.type(mobile, mobilePhone);
		registration.click();
		boolean flag=action.isDisplayed(ldriver, myaccount);
		return flag;
		
		
	}
	public boolean validateAcountCreatePage() throws Throwable 
	{
		 return action.isDisplayed(ldriver, formTitle);
	}
	public String randomEmailGenerator()
	{
		String generatedString=RandomStringUtils.randomAlphabetic(8);
		String email=generatedString+"@gmail.com";
		return email;
	}
	public void typeEmail(String email) throws InterruptedException
	{
		createEmail.click();
		logger.info("Email Button Clicked");
		action.type(createEmail, email);
		register.click();
		
	}

}
