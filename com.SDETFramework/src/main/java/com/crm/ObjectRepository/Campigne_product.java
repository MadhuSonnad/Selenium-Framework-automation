package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Campigne_product {

	public Campigne_product (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CreateCampigne12;


	@FindBy(className="detailedViewTextBox")
	private WebElement passDATA;

	public WebElement getCreateCampigne()
	{
		return CreateCampigne12;
	}

	public WebElement getPassDATA() 
	{
		return passDATA;
	}


	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savaButton;

	
	@FindBy(xpath="//img[@title='Select']")
	private WebElement SelectOption;
	
	
	public WebElement getSelectOption() {
		return SelectOption;
	}

	public WebElement getSavaButton() {
		return savaButton;
	}


	public void creatCampigne()
	{
		CreateCampigne12.click();
	}

	public void CampigneTextField(String excel1)
	{
		passDATA.sendKeys(excel1);
	}

	public void SelectpluseSysmbole()
	{
		SelectOption.click();
	}
	
	public void SaveButton()
	{
		savaButton.click();
	}
	
}
