package listeners;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utills.ReportGenerate;

public class Mylisteners implements ITestListener
{
	ExtentReports extentReport ;
	ExtentTest extentTest ;
	
	@Override
	public void onStart(ITestContext context) 
	{
		 extentReport = ReportGenerate.generatedHTML_Report();
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		 String TestName = result.getName();
		 extentTest = extentReport.createTest(TestName);
		 extentTest.log(Status.INFO,TestName+" >---->  Successfully Executed" );
		 
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		String TestName = result.getName();
		extentTest.log(Status.PASS,TestName+">----> Passed");
		/*
		 * WebDriver driver = null; //Configuration for the Taking ScreenShots.........
		 * try { driver =
		 * (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").
		 * get(result.getInstance()); } catch(Throwable e) { e.printStackTrace(); }
		 * 
		 * File
		 * srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 * String destinationScreensots =
		 * System.getProperty("user.dir")+"\\Screenshots\\"+TestName+".png"; try {
		 * FileHandler.copy(srcScreenshot, new File(destinationScreensots));
		 * }catch(Throwable e) { e.printStackTrace(); }
		 * 
		 * // This is for the adding screen shot in the html report.
		 * 
		 * extentTest.addScreenCaptureFromPath(destinationScreensots);
		 */	
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		String TestName = result.getName();
		extentTest.log(Status.FAIL,TestName+"  >----->  Failed");
		extentTest.log(Status.INFO,result.getThrowable());
		WebDriver driver = null;
      //Configuration for the Taking ScreenShots.........
		try {
		     driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} catch(Throwable e)
		{
			e.printStackTrace();
		}
		
		 File srcScreenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 String destinationScreensots = System.getProperty("user.dir")+"\\Screenshots\\"+TestName+".png";
		 try {
		 FileHandler.copy(srcScreenshot, new File(destinationScreensots));
		 }catch(Throwable e)
		 {
			 e.printStackTrace();
		 }
		 
		 // This is for the adding screen shot in the html report.
		 
		 extentTest.addScreenCaptureFromPath(destinationScreensots);
		
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		String TestName = result.getName();
		extentTest.log(Status.SKIP,TestName+"Skipped");
	}

	

	@Override
	public void onFinish(ITestContext context) 
	{
		extentReport.flush();
		String PathOfHTMLReport = System.getProperty("user.dir")+"\\HTMLReport\\Report.html";
		File HTMLReport = new File(PathOfHTMLReport);
		
		try {
			Desktop.getDesktop().browse(HTMLReport.toURI());
		} catch (IOException e) 
		{
			
			e.printStackTrace();
		}
		
	}
  
}
