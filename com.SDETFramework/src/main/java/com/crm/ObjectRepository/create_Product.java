package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_Product
{
	public create_Product(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Product...']")
	private WebElement createProduct;


	@FindBy(className="detailedViewTextBox")
	private WebElement passDATA;

	public WebElement getCreateProduct()
	{
		return createProduct;
	}

	public WebElement getPassDATA() {
		return passDATA;
	}


	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savaButton;

	public WebElement getSavaButton() {
		return savaButton;
	}


	public void creatPRODUCT()
	{
		createProduct.click();
	}

	public void ProductTextField(String excel1)
	{
		passDATA.sendKeys(excel1);
	}

	public void SaveButton()
	{
		savaButton.click();
	}
}
	
