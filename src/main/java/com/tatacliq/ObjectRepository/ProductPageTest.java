package com.tatacliq.ObjectRepository;

import java.awt.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPageTest {

	@FindBy(xpath="//div[@class='ProductDescription__header']")
	private java.util.List<WebElement> prod_name;
}
