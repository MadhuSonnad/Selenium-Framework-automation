package Practices;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class CONTACT_Additems 
{
public static void main(String[] args) throws Throwable {

	System.setProperty("webdriver.gecko.driver","./geckodriver.exe");

	  WebDriver driver=new FirefoxDriver();
	  
	  driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
//	  Random ran=new Random();
//	  int ranNum=ran.nextInt(1000);
	FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
	Properties pro=new Properties();
	pro.load(fis);
	String URL = pro.getProperty("url");
	String UserName=pro.getProperty("un");
	String PassWord=pro.getProperty("pw");
	driver.get(URL);
	
	
	
	driver.findElement(By.name("user_name")).sendKeys(UserName);
	driver.findElement(By.name("user_password")).sendKeys(PassWord);
	driver.findElement(By.id("submitButton")).click();
    driver.findElement(By.xpath("//td[@align='center'][4]")).click();
    driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
    driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("KUMAR");
    driver.findElement(By.xpath("//img[@title='Select']")).click();

    String parent = driver.getWindowHandle();
	System.out.println(driver.getTitle());
	Set<String> allid = driver.getWindowHandles();
	for(String s1:allid)
	{
		driver.switchTo().window(s1);
		if(parent.contains(s1))
		{
			continue;
		}
		else
		{
		Thread.sleep(3000);	
		driver.findElement(By.partialLinkText("Sample  & test demo")).click();
		}
	}
	 driver.switchTo().window(parent);
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	String dataact = driver.findElement(By.cssSelector("span.dvHeaderText")).getText();
	
	if(dataact.contains("KUMAR"))
	{
		System.out.println("its pass");
	}
	else
	{
		System.out.println("its fail");
	}
	//driver.switchTo().alert().accept();
	WebElement ele3 = driver.findElement(By.xpath("//img[@style='padding: 0px;padding-left:5px']"));
	Actions a1=new Actions(driver);
	a1.moveToElement(ele3).build().perform();

	driver.findElement(By.xpath("//a[.='Sign Out']")).click();

}
	
}	

