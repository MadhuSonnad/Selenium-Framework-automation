package com.crm.campaingn;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.beust.jcommander.Parameters;
import com.crm.Genric_Utility123.Baseclass;
import com.crm.Genric_Utility123.Excel_Utility;
import com.crm.Genric_Utility123.File_Utility;
import com.crm.Genric_Utility123.Java_Utility;
import com.crm.Genric_Utility123.Webdriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.Verification_validationPage;
import com.crm.ObjectRepository.create_Campigne;

@Listeners(com.crm.Genric_Utility123.Listeners.class)
public class CAMPINGTEST extends Baseclass 
{
	@Test(retryAnalyzer=com.crm.Genric_Utility123.RetryAnalyzer.class)
	public  void  campinge()throws Throwable
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
		   Assert.assertEquals(false, true);

		//	WebElement ele = driver.findElement(By.xpath("//img[@style='padding-left:5px']"));
		//	web.MouseOverOnElement(driver, ele);
		//	driver.findElement(By.xpath("//a[@name='Campaigns']")).click();

		create_Campigne create=new create_Campigne(driver);
		create.creatCampigne();
		//driver.findElement(By.xpath("//img[@alt='Create Campaign...']")).click();

		String exceldata = Excel.getDataFromExcel("Oraganation", 0, 0)+java.RanDomNum();
		create.CampigneTextField("excel1");

		//driver.findElement(By.className("detailedViewTextBox")).sendKeys(exceldata);
		create.SaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]'][1]")).click();		
		//Thread.sleep(2000);

		Verification_validationPage validation = new Verification_validationPage(driver);
		validation.organationValidation(driver, exceldata);

		/*String dataact = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();

		if(dataact.contains(exceldata))
		{
			System.out.println("its pass");
		}
		else
		{
			System.out.println("its fail");
		}*/

		WebElement ele1 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		web.MouseOverOnElement(driver, ele1);

		home.logoutButton();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
		driver.close();
	}
}


