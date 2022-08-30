package com.tatacliq.GenericLibrary;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public String browser;
	public String url;
	public WebDriver driver;
	public WebDriverUtility webdriverutils;
	public Excelutility excelutils;

	
	/**
	 *@BeforeSuite is used write  common actions excelconnection ,databaseconnection ,PropertyFile connection
	 * @throws IOException
	 */
	@BeforeSuite(groups="baseclass")
	public void beforesuiteTest() throws IOException
	{
		System.out.println("hai iam beforeSuite");

		Excelutility excelutility = new Excelutility();
		excelutility.openExcel(ConstantPath.EXCELFILEPATH);	
		
		PropertyFileUtility propertyfileutils=new PropertyFileUtility();
		propertyfileutils.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
	}
	
	
	/**
	 *@throws Throwable 
	 * @throws NumberFormatException 
	 * @throws EncryptedDocumentException 
	 * @Beforeclass is used to write normalexecution like launch browseer ,
	 *navigate application 
	 *read the commonData browser setting
	 *and we have to create instance of CommonPom class
	 *we have to create instance of explicit wait
	 */
	//@Parameters( "browser")
	@BeforeClass(groups="baseclass")
	
	public void beforeclassTest(/*String browser*/) throws EncryptedDocumentException, NumberFormatException, Throwable
	{
		WebDriverUtility webdriverutils=new WebDriverUtility();
       

		switch (browser)
		{
		case "chrome":
		
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			break;
			
		case "firefox":
		
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
			
		case "edge":
		
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			break;	
		
		
		default:
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			break;
		}
		
		webdriverutils.launchApp(url, driver);
	}

	
	/**
	 * This annotation is used to  write Login actions	
	 */
	@BeforeMethod(groups="baseclass")
	public void beforeMethodTest()
	{
		System.out.println("hai before method");
	}
	
	/**
	 * this annotation is used to write logout actions
	 */
	@AfterMethod(groups="baseclass")
	public void afterMethodTest()
	{
		System.out.println("hai after method");
	}
	
	
@AfterClass(groups="baseclass")
	
	public void afterClassTest()
	{
	webdriverutils.quitBrowser(driver);
	}
	/**
	 * this annotation is used to close the connection
	 * @throws IOException
	 */
	@AfterSuite(groups="baseclass")
	
	public void afterSuiteTest() throws IOException
	{
		excelutils.saveDataIntoExcel(ConstantPath.EXCELFILEPATH);
		excelutils.closeExcel();
	}	
}
