package utills;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ReportGenerate 
{
 public  static ExtentReports  generatedHTML_Report()
 {
	 ExtentReports extentReport = new ExtentReports();
	 File HTMLReportFile = new File(System.getProperty("user.dir")+"\\HTMLReport\\Report.html");
	 ExtentSparkReporter sparkReporter = new ExtentSparkReporter(HTMLReportFile);
	 
	 // now we are configuring the HTML Report
	 sparkReporter.config().setTheme(Theme.DARK);
	 sparkReporter.config().setDocumentTitle("AutomationTestingReports");
	 sparkReporter.config().setReportName("EaseMyTripReport");
	 // now report is generating..
	 extentReport.attachReporter(sparkReporter);
	 
	 // System.info......
	 Properties propFile = new Properties();
	 File file = new File(System.getProperty("user.dir")+"//src//main//java//testdataProperties//testData.properties");
	 try {
	 FileInputStream fis = new FileInputStream(file);
	 propFile.load(fis);
	 }catch(Throwable e)
	 {
		 e.printStackTrace();
	 }
	 
	 extentReport.setSystemInfo("Tester Name",propFile.getProperty("testerName"));
	 extentReport.setSystemInfo("WebApplication Name",propFile.getProperty("url"));
	 extentReport.setSystemInfo("BrowserName",propFile.getProperty("browserName"));
	 
	 return extentReport ;
 }
	
}//This is a class bracket
