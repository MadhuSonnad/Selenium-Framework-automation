package com.crm.campaingn;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class MAKE_MY_TRIOP 
{
	public static void main(String[] args) throws Throwable 
	{
		System.setProperty("webdriver.gecko.driver","./src/test/resources/geckodriver.exe");
		WebDriver driver=new FirefoxDriver();

		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		FileInputStream fis=new FileInputStream("./common_data1_properties.txt");
		Properties pro=new Properties();
		pro.load(fis);
		String URL = pro.getProperty("url");
		driver.get(URL);
		Thread.sleep(2000);

		driver.findElement(By.cssSelector("span.langCardClose")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[@class='lbl_input latoBold appendBottom10'][1]")).click();
		Thread.sleep(2000);
		String month = "October 2022";
		String date = "8";

		driver.findElement(By.xpath("//div[text()='"+month+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date+"']")).click();

		driver.findElement(By.xpath("//input[@data-cy='fromCity']")).click();
		FileInputStream fis1=new FileInputStream("./Excel/Madhu2.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String data = cell.getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='From']")).sendKeys(data);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//li[@data-section-index='0'][1]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[.='To']")).click();
		FileInputStream fis2=new FileInputStream("./Excel/Madhu2.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sheet1 = book.getSheet("Sheet2");
		Row row1 = sheet.getRow(2);
		Cell cell1 = row.getCell(0);
		String data1 = cell.getStringCellValue();
		driver.findElement(By.xpath("//input[@placeholder='To']")).sendKeys(data1);
		driver.findElement(By.xpath("//li[@data-section-index='0'][1]")).click();

		driver.findElement(By.xpath("//span[.='RETURN']")).click();
		Thread.sleep(2000);
		String month1 = "October";
		String date1 = "15";
		driver.findElement(By.xpath("//div[text()='"+month1+"']/ancestor::div[@class='DayPicker-Month']/descendant::p[text()='"+date1+"']")).click();
		driver.findElement(By.xpath("//label[@for='travellers']")).click();

		String adults = "adults-4";
		String children =  "children-3";
		String infants = "infants-2";
		driver.findElement(By.xpath("//li[@data-cy='"+adults+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='"+children+"']")).click();
		driver.findElement(By.xpath("//li[@data-cy='"+infants+"']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[.='APPLY']")).click();
	}		
}