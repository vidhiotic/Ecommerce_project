package com.ecommerce.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.ecommerce.actiondriver.Actions_Page;
import com.ecommerce.base.BaseClass;

public class Checkout extends BaseClass
{
	WebDriver ldriver;
	Actions_Page action= new Actions_Page();
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
	
	@FindBy(className = "sf-with-ul") 
	 WebElement women;
	
	@FindBy(xpath = "//*[@id=\"color_2\"]") 
	 WebElement instock;
	
	@FindBy(id = "bigpic") 
	 WebElement picture;
	
	@FindBy(xpath = "//*[@id=\"add_to_cart\"]/button/span") 
	 WebElement addtocart;
	
	@FindBy(xpath = "//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span") 
	 WebElement checkout;
	 
	@FindBy(xpath = "//span[contains(text(),'Proceed to checkout')]") 
	 WebElement proceedToCheckOutBtn;
	
	@FindBy(id="quantity_wanted")
	 WebElement quantity;
	
	@FindBy(name="group_1")
	 WebElement size;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/div/div[2]/div[2]/a[2]/span")
	 WebElement morebtn;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]//h2/i")
	 WebElement addToCartMessag;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button/span")
	 WebElement addToCartBtn;
	
	@FindBy(id="cgv")
	 WebElement terms;
	
	@FindBy(xpath = "//a[contains(text(),'Pay by bank wire')]")
	 WebElement bankWireMethod;
	
	@FindBy(xpath="//span[contains(text(),'I confirm my order')]")
	 WebElement confirmOrderBtn;
	
	@FindBy(xpath="//p/strong[contains(text(),'Your order on My Store is complete.')]")
	 WebElement confirmMessag;
	 
	@FindBy(xpath="//*[@id=\"center_column\"]/p[2]/a[1]/span") 
	 WebElement addressproceedButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button/span")
	 WebElement shipping_proceed;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button/span")
	 WebElement payment_proceed;
	
	public Checkout(WebDriver rdriver) 
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	 public void checkout() throws InterruptedException
	 {
		 Login lg=new Login(driver);
		 lg.click_signin();
	  }
	 
	 public void login_enter(String Email,String password) throws InterruptedException
	 {
		 action.type(emailtext, Email);
			action.type(pswrdtext, password);
			action.click(ldriver, signin);
			
	 }
	 public boolean verify_loggedinPage()
		{
			return action.isDisplayed(ldriver,myaccount);
			
		}
	 public void click_women() throws InterruptedException
	 {
		 action.click(ldriver,women);
		 action.click(ldriver, instock);
		 action.mouseHoverByJavaScript(instock);
		 action.click(ldriver, morebtn);
		 action.isDisplayed(ldriver, picture);	 
		
	 }
	 
	 public void enterQuantity(String quantity1) throws Throwable
	 {
			action.type(quantity, quantity1);
		}
	 
	 public void selectSize(String size1) throws Throwable {
			action.selectByVisibleText(size1, size);
			
		}
		
	 public void clickOnAddToCart() throws Throwable
	 {
			action.click(ldriver, addToCartBtn);
		}
	 
	 public void clickOnCheckOut() throws Throwable
	 {
			action.fluentWait(ldriver, proceedToCheckOutBtn, 10);
			action.JSClick(ldriver, proceedToCheckOutBtn);
		}
	public void clickOnProceed()
	{
		action.scrollByVisibilityOfElement(ldriver, addressproceedButton);
		action.click(ldriver, addressproceedButton);

		
	}
	public void address()
	{
		shipping_proceed.click();
	}
	
	public void checkTheTerms() throws Throwable 
	{
		terms.click();
		payment_proceed.click();
		
		
	}
	
	public void clickOnPaymentMethod()  throws Throwable 
	{
		bankWireMethod.click();
		
	}
	
	public void clickOnconfirmOrderBtn() throws Throwable 
	{
		action.click(ldriver, confirmOrderBtn);
		
	}
	
	public String validateConfirmMessage() 
	{
		String confirmMsg=confirmMessag.getText();
		return confirmMsg;
	}
	
}
