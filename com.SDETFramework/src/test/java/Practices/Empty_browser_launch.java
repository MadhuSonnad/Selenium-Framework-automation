package Practices;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Empty_browser_launch
{
public static void main(String[] args) throws IOException 
{
System.setProperty("webdriver.gecko.driver","./geckodriver.exe");

  WebDriver driver=new FirefoxDriver();
FileInputStream fis=new FileInputStream("./Common_Data.properties.txt");
Properties pro=new Properties();
pro.load(fis);
String URL = pro.getProperty("url");
String UserName=pro.getProperty("un");
String PassWord=pro.getProperty("pw");
driver.get(URL);
//driver.findElement(By.name("user_name")).sendKeys(UserName);
//driver.findElement(By.name("user_password")).sendKeys(PassWord);
//driver.findElement(By.id("submitButton")).click();
}
}



