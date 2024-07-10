package Practices;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Aamzon
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.get("https://www.amazon.com");
		WebElement ele = driver.findElement(By.xpath("@span[class='a-price-whole']"));
		ele.getText();
	}

}
