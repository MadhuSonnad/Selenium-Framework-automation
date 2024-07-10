package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class create_Organization
{

	public create_Organization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement CreateOraganization;


	@FindBy(className="detailedViewTextBox")
	private WebElement passDATA;

	public WebElement getCreateOraganization() {
		return CreateOraganization;
	}

	public WebElement getPassDATA() {
		return passDATA;
	}


	@FindBy(xpath="//input[@title='Save [Alt+S]'][1]")
	private WebElement savaButton;

	public WebElement getSavaButton() {
		return savaButton;
	}


	public void creatOrganton()
	{
		CreateOraganization.click();
	}

	public void OraganizationTextField(String excel1)
	{
		passDATA.sendKeys(excel1);
	}

	public void SaveButton()
	{
		savaButton.click();
	}
}
