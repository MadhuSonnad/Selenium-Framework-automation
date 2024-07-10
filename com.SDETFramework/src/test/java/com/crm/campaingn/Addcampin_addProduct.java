package com.crm.campaingn;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.crm.Genric_Utility123.Baseclass;
import com.crm.Genric_Utility123.Excel_Utility;
import com.crm.Genric_Utility123.File_Utility;
import com.crm.Genric_Utility123.Java_Utility;
import com.crm.Genric_Utility123.Webdriver_Utility;
import com.crm.ObjectRepository.Campigne_product;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.Verification_validationPage;
@Listeners(com.crm.Genric_Utility123.Listeners.class)

public class Addcampin_addProduct extends Baseclass
{
	//@Test(retryAnalyzer=com.crm.Genric_Utility123.RetryAnalyzer.class)
	
	@Test(groups={"smokeTest"})
	public void addcampin__addProduct() throws Throwable
	{
		Excel_Utility Excel = new Excel_Utility ();
		Java_Utility java = new Java_Utility();
		File_Utility file1 = new File_Utility();
		Webdriver_Utility web=new Webdriver_Utility();

		driver.manage().window().maximize();
		
		HomePage home=new HomePage(driver);
		home.moveToMore();
		home.Campainglink();
		web.Explicitwait(driver);

		Campigne_product add=new Campigne_product(driver);
		add.creatCampigne();
		//Thread.sleep(2000);
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		String exceldata = Excel.getDataFromExcel("Oraganation", 0, 0)+java.RanDomNum();
		add.CampigneTextField(exceldata);

		add.SelectpluseSysmbole();

		driver.findElement(By.xpath("//img[@title='Select']")).click();
		web.SwitchToWindow(driver,"Products&action");
		Thread.sleep(2000);
		driver.findElement(By.partialLinkText("OPPO MOBILE")).click();

		web.SwitchToWindow(driver,"Campaigns&action");
		//driver.switchTo().window(parent);
		//Thread.sleep(2000);

		add.SaveButton();
		//driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		//Thread.sleep(2000);
		Verification_validationPage validation = new Verification_validationPage(driver);
		validation.organationValidation(driver, exceldata);

		WebElement ele3 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		web.MouseOverOnElement(driver, ele3);
		//		Actions a1=new Actions(driver);
		//		a1.moveToElement(ele3).build().perform();

		home.logoutButton();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
