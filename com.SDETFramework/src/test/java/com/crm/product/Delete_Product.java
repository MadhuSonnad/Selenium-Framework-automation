package com.crm.product;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.crm.Genric_Utility123.Baseclass;
import com.crm.Genric_Utility123.File_Utility;
import com.crm.Genric_Utility123.Webdriver_Utility;
import com.crm.ObjectRepository.HomePage;

import com.crm.ObjectRepository.delete_product;

public class Delete_Product extends Baseclass
{
	@Test(groups={"regressionTest"})
	public void delete_product()throws Throwable 
	{
		File_Utility file1 = new File_Utility();
		Webdriver_Utility web=new Webdriver_Utility();

		driver.manage().window().maximize();

		//		System.setProperty("webdriver.gecko.driver","./geckodriver.exe");	
		//		WebDriver driver=new FirefoxDriver();
		//		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

		//		driver.findElement(By.name("user_name")).sendKeys(UserName);
		//		driver.findElement(By.name("user_password")).sendKeys(PassWord);
		//		driver.findElement(By.id("submitButton")).click();

		HomePage home=new HomePage(driver);
		home.Productslink();
        //driver.findElement(By.linkText("Products")).click();
		
		delete_product delete=new delete_product(driver);
		delete.creatPRODUCT();
		//driver.findElement(By.xpath("//img[@title='Create Product...']")).click();

		//driver.findElement(By.xpath("//input[@class='detailedViewTextBox']")).sendKeys("OPPO MOBILE");
		delete.ProductTextField("OPPO MOBILES");

		delete.SaveButton();
		//driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		delete.deleteProducts();
		//driver.findElement(By.xpath("//input[@title='Delete [Alt+D]']")).click();
		//Thread.sleep(1000);
		
		web.SwitchToAlertAndAccept(driver);
		//driver.switchTo().alert().accept();

		WebElement ele3 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
		web.RightClickOnElement(driver, ele3);

		home.logoutButton();
		//	driver.findElement(By.xpath("//a[.='Sign Out']")).click();

	}
}
