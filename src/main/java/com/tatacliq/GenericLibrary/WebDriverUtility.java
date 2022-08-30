package com.tatacliq.GenericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class WebDriverUtility {
	
	
	/**
	 * This method is used to launch to the Application
	 * @param url
	 * @param driver
	 */
	public  void launchApp(String url , WebDriver driver)
	{
		driver.get(url);
	}
	
	/**
	 * this method is used to disable notifications
	 */public void disableNotifications() {
			ChromeOptions opt=new ChromeOptions();
			opt.addArguments("--disable-notifications");
			WebDriver driver=new ChromeDriver(opt);
	}


	/**
	 * This method is used to maximize the browser
	 * @param driver
	 */
	public  void maximizeBrowser(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	/**
	 * This method is used to implicitly wait till page load
	 * @param longTimeOut
	 * @param driver
	 */
	public void waitTillpageLoad(long longTimeOut,WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(longTimeOut, TimeUnit.SECONDS);
	}
	
	
	/**
	 * This method is used to close the browser instance
	 * @param driver
	 */
	public  void quitBrowser(WebDriver driver)
	{
		driver.quit();
	}
	
	
}
