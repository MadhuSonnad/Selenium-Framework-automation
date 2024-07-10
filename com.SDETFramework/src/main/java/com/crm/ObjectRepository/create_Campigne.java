package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_Campigne 
{
	public create_Campigne (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Campaign...']")
	private WebElement CreateCampigne;


	@FindBy(className="detailedViewTextBox")
	private WebElement passDATA;

	public WebElement getCreateCampigne()
	{
		return CreateCampigne;
	}

	public WebElement getPassDATA() {
		return passDATA;
	}


	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savaButton;

	public WebElement getSavaButton() {
		return savaButton;
	}

	public void creatCampigne()
	{
		CreateCampigne.click();
	}

	public void CampigneTextField(String excel1)
	{
		passDATA.sendKeys(excel1);
	}

	public void SaveButton()
	{
		savaButton.click();
	}
}
