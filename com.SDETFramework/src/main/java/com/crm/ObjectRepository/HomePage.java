package com.crm.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage
{

	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	@FindBy(linkText="Organizations")
	private WebElement organizationLinkText;


	@FindBy(xpath="//img[@style='padding-left:5px']")
	private WebElement moveCusorOnMore;

	@FindBy(xpath="//a[@name='Campaigns']")
	private WebElement Campaigns;

	@FindBy(linkText="Products")
	private WebElement productLinkText;

	@FindBy(xpath="//a[.='Sign Out']")
	private WebElement signout;


	public WebElement getSignout() {
		return signout;
	}

	public WebElement getOrganizationLinkText() {
		return organizationLinkText;
	}

	public WebElement getMoveCusorOnMore() {
		return moveCusorOnMore;
	}

	public WebElement getCampaigns() {
		return Campaigns;
	}

	public WebElement getProductLinkText() {
		return productLinkText;
	} 

	public void Productslink()
	{
		productLinkText.click();
	}

	public void ClickOnOrganization()
	{
		organizationLinkText.click();
	}

	public void moveToMore()
	{
		moveCusorOnMore.click();

	}

	public void Campainglink()
	{
		Campaigns.click();	
	}


	public void logoutButton()
	{
		signout.click();
	}



}
