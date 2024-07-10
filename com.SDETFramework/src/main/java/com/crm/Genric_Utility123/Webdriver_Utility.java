 package com.crm.Genric_Utility123;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Webdriver_Utility
{
	/**
	 * Wait for page to load before identifying any synchronized element on DOM 
	 * 
	 * @author MADHU
	 */
	public void waitPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
		
	/**
	 * After every action it will go for next action to perform
	 * 
	 * @param driver
	 *  @author MADHU
	 */
	public void scriptTimeOut(WebDriver driver)
	{
		driver.manage().timeouts().setScriptTimeout(30, TimeUnit.SECONDS);
	}
	
	public void Explicitwait(WebDriver driver)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
	}
	
	/**
	 * use to wait for element to be clickable in GUI, and check for specific element for every 500milliSeconds
	 * 
	 * @param driver
	 * @param Element
	 * @param pollingtime
	 *  @author MADHU
	 */
	/*public void WaitForElementWithCustomTimeOut(WebDriver driver,WebElement Element,int pollingtime)
	{
		FluentWait<WebDriver> wait1=new FluentWait<WebDriver>(driver);
		wait1.pollingEvery(Duration.ofSeconds(20));
		wait1.until(ExpectedConditions.elementToBeClickable(Element));	
	}*/
	/**
	 * used to switch to any window based on window title
	 * 
	 * 
	 * @param driver
	 * @param PartialWindowTitle
	 *  @author MADHU
	 */
	public void SwitchToWindow(WebDriver driver,String PartialWindowTitle)
	{
		Set<String> allid = driver.getWindowHandles();	
		Iterator<String> id = allid.iterator();
		while(id.hasNext())
		{
			String wid = id.next();
			driver.switchTo().window(wid);
			if(driver.getTitle().contains(wid))
			{
				break;
			}
		}
	}

	/**
	 * used to switch to Alert window and Accept(click on button)
	 * 
	 * 
	 * @param driver
	 *  @author MADHU
	 */
	public void SwitchToAlertAndAccept(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 *  used to switch to Alert window and Reject / cancel (click on button)
	 * 
	 * @param driver
	 *  @author MADHU
	 */
	public void SwitchToAlertAndDismiss(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/**
	 * used to switch to frame window based on Index
	 * 
	 * 
	 * @param driver
	 * @param id_name_Attribute
	 * @author MADHU
	 */
	public void SwitchToFrame(WebDriver driver,String id_name_Attribute)
	{
		driver.switchTo().frame(id_name_Attribute);
	}

	/**
	 * used to select the value from the dropdown based on text
	 * 
	 * 
	 * @param element
	 * @param text
	 * @author MADHU
	 */
	public void Select(WebElement element,String text)
	{
		org.openqa.selenium.support.ui.Select S=new org.openqa.selenium.support.ui.Select(element);
		S.selectByVisibleText(text);

	}
	/**
	 * used to select the value from the dropdown based on Index
	 * 
	 * 
	 * @param element
	 * @param index
	 * @author MADHU
	 */
	public void Select(WebElement element,int index)
	{
		org.openqa.selenium.support.ui.Select S=new org.openqa.selenium.support.ui.Select(element);
		S.selectByIndex(0);

	}

	/**this method is use to fetch the data from Excel
	 * 
	 * 
	 * 
	 * @param sheetname
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 * @author MADHU
	 */

	public String getDataFromExcel(String sheetname,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis1=new FileInputStream("./Excel/Madhu.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		//		Sheet sht = book.getSheet(sheetname);
		//		Row row = sht.getRow(rowNum);
		//		Cell cell = row.getCell(cellNum);
		//		String data = cell.getStringCellValue();
		//		return data;
		//	}
		//	

		DataFormatter format=new DataFormatter();
		return format.formatCellValue(book.getSheet(sheetname).getRow(rowNum).getCell(cellNum));
	}

	/**
	 * used to place mouse cursor on specific element
	 * 
	 * 	
	 * @param driver
	 * @param element
	 * @author MADHU
	 */
	public void MouseOverOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * used to right click on specific element
	 * 
	 * @param driver
	 * @param element
	 * @author MADHU
	 */
	public void RightClickOnElement(WebDriver driver, WebElement element)
	{
		Actions a=new Actions(driver);
		a.contextClick(element).perform();
	}
	/**
	 * used to move by offset to specific element
	 * 
	 * 
	 * @param driver
	 * @param x
	 * @param y
	 * @author MADHU
	 */
	public void MoveByOffset(WebDriver driver, int x, int y)
	{
		Actions a=new Actions(driver);
		a.moveByOffset(x,y).perform();
	}

}
