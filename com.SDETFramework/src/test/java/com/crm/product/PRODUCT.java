package com.crm.product;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.crm.Genric_Utility123.Baseclass;
import com.crm.Genric_Utility123.File_Utility;
import com.crm.Genric_Utility123.Webdriver_Utility;
import com.crm.ObjectRepository.HomePage;
import com.crm.ObjectRepository.Verification_validationPage;
import com.crm.ObjectRepository.create_Product;

public class PRODUCT extends Baseclass
{
	@Test(groups={"smokeTest"})
	public void product() throws EncryptedDocumentException, Throwable
	{
		File_Utility file1 = new File_Utility();
		Webdriver_Utility web=new Webdriver_Utility();

		driver.manage().window().maximize();

		HomePage home=new HomePage(driver);
		home.Productslink();
		
		create_Product create=new create_Product(driver);
		create.creatPRODUCT();

		create.ProductTextField("OPPO MOBILE");

		create.SaveButton();		
	String dataact = driver.findElement(By.cssSelector("span.lvtHeaderText")).getText();

	//Verification_validationPage valid=new Verification_validationPage(driver);
	//valid.organationValidation(driver, "OPPO MOBILE");
	
		if(dataact.contains("OPPO MOBILE"))
		{
			System.out.println("its pass");
		}
		else
		{
			System.out.println("its fail");
		}
		WebElement ele = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		web.MouseOverOnElement(driver, ele);

		home.logoutButton();
		//driver.findElement(By.xpath("//a[.='Sign Out']")).click();
	}
}
