package com.tatacliq.ObjectRepository;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePageTest {

	 @FindBy(xpath="//input[@type='search']")
	private WebElement searchTxtFld;
	 
	 
	 @FindBy(xpath="//input[@type='search']")
	 private WebElement enterDataToSearchTxtFld;
	 
	 @FindBy(xpath="//input[@type='search']")
	 private WebElement clickOnEnterBtn;
	 
	 public WebElement getsearchTxtFld() {
	 return searchTxtFld;
	 }
	 
	 public HomePageTest(WebDriver driver)
	 {
		 PageFactory.initElements(driver, this);
	 }
	 
	 public void homePage(WebDriver driver, String product_name)
	 {
		 searchTxtFld.click();
		 enterDataToSearchTxtFld.sendKeys(product_name);
		 searchTxtFld.sendKeys(Keys.ENTER);
	 }
	 
}
