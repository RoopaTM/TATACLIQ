package com.tatacliq.GetProductsDetailsTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import com.tatacliq.GenericLibrary.BaseClass;
import com.tatacliq.GenericLibrary.ConstantPath;
import com.tatacliq.GenericLibrary.Excelutility;
import com.tatacliq.GenericLibrary.PropertyFileUtility;
import com.tatacliq.GenericLibrary.WebDriverUtility;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetProductDetailsTest extends BaseClass {

	
	String product_name;
	Excelutility excelutils;
	WebDriver driver;
	Workbook wb;
	PropertyFileUtility propertyfileutils;
	@Test
	
	public void getProductDetailsTest() throws InterruptedException, EncryptedDocumentException, IOException
	{
		
		excelutils=new Excelutility();
		WebDriverUtility webdriverutils;
		excelutils.openExcel(ConstantPath.EXCELFILEPATH);
		product_name=excelutils.DataFromExcel("PRODUCTS_NAME", 1, 1);
				
		browser=propertyfileutils.getDataFromPropertyFile("browser");
		 url = propertyfileutils.getDataFromPropertyFile("url");
		
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
		
	
		driver.get(url);
		webdriverutils=new WebDriverUtility();
		webdriverutils.disableNotifications();
		webdriverutils.maximizeBrowser(driver);
		webdriverutils.waitTillpageLoad(10, driver);
		
		
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//input[@type='search']")).click();
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(product_name);
		//driver.findElement(By.xpath("//input[@type='search']")).sendKeys(Keys.ENTER);
		
		
		List<WebElement> prod_names = driver.findElements(By.xpath("//div[@class='ProductDescription__header']"));
		int prod_count = prod_names.size();
		
		for(int i=0;i<prod_count;i++)
		{
			System.out.println(prod_names.get(i).getText());
		}
//		
//		FileInputStream fis1=new FileInputStream("./src/main/resources/TataCliqData.xlsx");
//	    Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("PRODUCT_DETAILS");
//		int lastRow = sh.getLastRowNum();
//		for(int i=1; i<lastRow;i++)
//		{
//			Row rw = sh.getRow(i);
//			Cell cell = rw.createCell(i);
//			cell.setCellValue(prod_names.get(i).getText());
//		}
//		FileOutputStream fos=new FileOutputStream("./src/main/resources/TataCliqData.xlsx");
//		wb.write(fos);
//		
		
		
		Thread.sleep(2000);
		 List<WebElement> prod_description = driver.findElements(By.xpath("//h2[contains(@class,'ProductDescription__description')]"));
		
		 int description_count = prod_description.size();
			
			for(int i=0;i<description_count;i++)
			{
				System.out.println(prod_description.get(i).getText());
			}

						
			Thread.sleep(2000);
			
			 List<WebElement> prod_price = driver.findElements(By.xpath("//div[@class='ProductDescription__content']/descendant::h3[@class='ProductDescription__boldText']"));
			
			 int price_count = prod_price.size();
				
				for(int i=0;i<price_count;i++)
				{
					System.out.println(prod_price.get(i).getText());
				}
				 
				
		
				
				
				for(int i=0; i<description_count; i++)
				{
					excelutils.openExcel(ConstantPath.EXCELFILEPATH);
					wb.getSheet("PRODUCT_DETAILS").createRow(i+1).createCell(0).setCellValue(prod_description.get(i).getText());
					wb.getSheet("PRODUCT_DETAILS").getRow(i+1).createCell(1).setCellValue(prod_description.get(i).getText());
					wb.getSheet("PRODUCT_DETAILS").getRow(i+1).createCell(1).setCellValue(prod_price.get(i).getText());
					
				}
				excelutils.saveDataIntoExcel("PRODUCT_DETAILS");
				
				wb.close();
				
			
	}
	
	
}
