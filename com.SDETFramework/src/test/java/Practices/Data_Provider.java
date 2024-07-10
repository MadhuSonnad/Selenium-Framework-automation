package Practices;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Data_Provider 
{
	@Test(dataProvider="dataProvider_test")
	
	public void companyDetails(String name,String Part_number, String SerialNo) throws InterruptedException
	{
		System.setProperty("webdriver.gecko.driver","./geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
		
		driver.get("http://localhost:8888/");
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		
		driver.findElement(By.linkText("Products")).click();
		driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		driver.findElement(By.name("productname")).sendKeys(name);
		driver.findElement(By.id("productcode")).sendKeys(Part_number);
		driver.findElement(By.id("serial_no")).sendKeys(SerialNo);
		//driver.findElement(By.xpath("//[@title='Save [Alt+S]']")).click();	
		
		driver.quit();
		Thread.sleep(2000);
	}
		@DataProvider
		
		public Object[][] dataProvider_test()
		{
			Object [][] objarr=new Object[3][3];
		    objarr[0][0]="ABCD";
			objarr[0][1]="123456";
			objarr[0][2]="A12345B";
			
			objarr[1][0]="EFCH";
			objarr[1][1]="123456";
			objarr[1][2]="E12345F";
			
			
			objarr[2][0]="IJKL";
			objarr[2][1]="123456";
			objarr[2][2]="I12345J";
			
			return objarr;
					
		}
	}



//)Write a xpath to find Akhil salary (If we are not aware or sure about html tag then we can go for //*)
//--> //*[text()='Akhil']/following-sibling::td[2]
