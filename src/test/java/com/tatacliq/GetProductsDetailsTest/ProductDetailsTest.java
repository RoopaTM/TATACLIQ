package com.tatacliq.GetProductsDetailsTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.DriverManager;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tatacliq.GenericLibrary.ConstantPath;
import com.tatacliq.GenericLibrary.Excelutility;
import com.tatacliq.GenericLibrary.PropertyFileUtility;
import com.tatacliq.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductDetailsTest {
	

	String product_name;
	Excelutility excelutils;
	WebDriverUtility webdriverutils;
	WebDriver driver;
	PropertyFileUtility propertyfileutils;
	
	
	@Test
	
	public void productDetailsTest() throws IOException
	{
		//to get url and broswer...............

		propertyfileutils=new PropertyFileUtility();
		//propertyfileutils.openPropertyFile(ConstantPath.PROPERTYFILEPATH);
		
		propertyfileutils.openPropertyFile("./src/main/resources/CommonData.properties");
		String Url = propertyfileutils.getDataFromPropertyFile("url");
		System.out.println(Url);
			
		String Browser="chrome";
		
		switch (Browser) {
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
		
		//to get data from excel...............
		 excelutils=new Excelutility();
		 excelutils.openExcel("./src/main/resources/TataCliqData.xlsx");
		product_name=excelutils.DataFromExcel("PRODUCTS_NAME", 1, 1);
		
		 webdriverutils=new WebDriverUtility();
		 webdriverutils.maximizeBrowser(driver);
		 webdriverutils.waitTillpageLoad(10, driver);
		 webdriverutils.launchApp(Url, driver);
		 
		 
		 
		 
		 
		
		}
				
	}
	
	

