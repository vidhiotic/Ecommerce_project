package com.ecommerce.base;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.ecommerce.utilities.ReadConfig;


public class BaseClass
{
	ReadConfig readconfig=new ReadConfig();
	public String baseurl=readconfig.getApplicationURL();
	public String username="admin@xyz.com";
	public String password="admin@123";
	public String browser=readconfig.getChromePath();
	public static WebDriver driver;
	public static Logger logger;
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String br)
	{
		
		logger=LogManager.getLogger("Ecommerce");
		PropertyConfigurator.configure("Log4j.properties");
		if(br.equals("chrome"))
		{

			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
			driver=new ChromeDriver();
		}
		else if(br.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver",readconfig.getfirefoxPath());
			driver=new FirefoxDriver();
			
		}
		else if(br.equals("ie"))
		{
			System.setProperty("webdriver.ie.driver",readconfig.getIEPath());
			driver=new InternetExplorerDriver();
			
		}
		driver.manage().window().maximize();
		driver.get(baseurl);
		
		
		
	}
	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	

}
