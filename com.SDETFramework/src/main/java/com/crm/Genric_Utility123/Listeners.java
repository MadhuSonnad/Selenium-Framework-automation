package com.crm.Genric_Utility123;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
public class Listeners implements ITestListener
{
	public void onTestFailure(ITestResult result)
	{
		String data=result.getMethod().getMethodName();
		System.out.println(data+"=====Excute I Am Listing====");

		EventFiringWebDriver edriver = new EventFiringWebDriver(Baseclass.sdriver);
		File src=edriver.getScreenshotAs(OutputType.FILE);
		try
		{
			File des=new File("./com.crm.SeleniumSDET42Framework/Screenshoot/"+data+".png");
			FileUtils.copyFile(src, des);
		} 
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	public void onTestSkipped(ITestResult result) 
	{

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {

	}

	public void onTestStart(ITestResult result) {


	}

	public void onTestSuccess(ITestResult result) {


	}
}

