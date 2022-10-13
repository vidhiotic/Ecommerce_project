package com.ecommerce.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	public ReadConfig()
	{
		File src=new File("./Configuration/Config.properties");
		try
		{
			FileInputStream fis=new FileInputStream(src);
			pro=new Properties();
			pro.load(fis);
		}
		catch(Exception e)
		{
			System.out.println("Exception is:" +e.getMessage());
			
		}
	}
	public String  getApplicationURL()
	{
		String url=pro.getProperty("baseurl");
		return url;
	}
	
	public String  getChromePath()
	{
		String chrome=pro.getProperty("chromepath");
		return chrome;
	}
	public String  getIEPath()
	{
		String ie=pro.getProperty("iepath");
		return ie;
	}
	public String  getfirefoxPath()
	{
		String firefox=pro.getProperty("firefoxpath");
		return firefox;
	}




}
