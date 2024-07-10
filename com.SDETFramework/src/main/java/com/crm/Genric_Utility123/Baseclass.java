package com.crm.Genric_Utility123;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.crm.ObjectRepository.LogInPage143;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass
{  
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups={"smokeTest","regressionTest"})
	public void baseSuite()
	{
		System.out.println("database connection");
	}
	@BeforeTest(groups={"smokeTest","regressionTest"})
	public void baseTest()
	{
		System.out.println("execute the parallel mood");
	}
	@Parameters("BROWSER")
	
	@BeforeClass(groups={"smokeTest","regressionTest"})
	
	//public void baseclass(String BROWSER)
	public void baseclass() throws Throwable
	{
      	File_Utility file1 = new File_Utility();
		Webdriver_Utility web=new Webdriver_Utility();
		String Browser = file1.getPropertyKeyValue("browser");

		if(Browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
	else if (Browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();			
		}
		else if(Browser.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		sdriver=driver;
		System.out.println("Launching browser");
	}
	@BeforeMethod(groups={"smokeTest","regressionTest"})
	public void baseMethod() throws Throwable 
	{
		File_Utility file1 = new File_Utility();
		String URL = file1.getPropertyKeyValue("url");
		String UserName = file1.getPropertyKeyValue("un");
		String PassWord = file1.getPropertyKeyValue("pw");

		driver.get(URL);

		LogInPage143 page=new LogInPage143(driver);
		page.login(UserName,PassWord);
		
		System.out.println("Login application");
	}
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Logout application");
	}

	@AfterClass
	public void afterClass()
	{
		System.out.println("close the browser");
	}
	@AfterTest
	public void afterTest()
	{
		System.out.println("executed sucessfully");
	}
	@AfterSuite
	public void afterSuite()
	{
		System.out.println("database close");
	}
}