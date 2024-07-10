package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Verification_validationPage
{
	public Verification_validationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement actualdatas;
	
	public WebElement getActualOrganazationgetDataact12()
	{
		return actualdatas;
	}
	public void organationValidation(WebDriver driver, String Passdata)
	{
		String dataact=	 actualdatas.getText();
		if(dataact.contains(Passdata))
		{
			System.out.println("its pass");
		} 
		else
		{
			System.out.println("its fail");
		}
	}
}
