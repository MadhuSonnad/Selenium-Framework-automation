package com.crm.organization;


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
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.Verification_validationPage;
import com.crm.ObjectRepository.create_Organization;

//@Listeners(com.crm.Genric_Utility.Listener.class)
public class OrganazitionTest extends Baseclass	
{
	@Test(groups={"smokeTest"})
	
	//@Test(retryAnalyzer=com.crm.Genric_Utility.RetryAnayalser.class)
	public  void organazition() throws Throwable 
	{
		Excel_Utility Excel = new Excel_Utility ();
		Java_Utility java = new Java_Utility();
		File_Utility file1 = new File_Utility();
		Webdriver_Utility web=new Webdriver_Utility();

		driver.manage().window().maximize();

		HomePage home=new HomePage(driver);
		home.ClickOnOrganization();
		//Assert.assertEquals(false, true);
		
		//driver.findElement(By.linkText("Organizations")).click();
		create_Organization create=new create_Organization(driver);
		create.creatOrganton();

		//driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
		
		String exceldata = Excel.getDataFromExcel("Oraganation", 0, 0)+java.RanDomNum();
		create.OraganizationTextField(exceldata);

		create.SaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();
		Thread.sleep(4000);

		Verification_validationPage validation = new Verification_validationPage(driver);
		validation.organationValidation(driver,exceldata);

		WebElement ele = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		web.MouseOverOnElement(driver, ele);

		home.logoutButton();

		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}

