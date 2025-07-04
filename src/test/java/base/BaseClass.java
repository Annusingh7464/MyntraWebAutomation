package base;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	  public WebDriver driver ;
	  public Properties prop ;
	  
	  
	  public BaseClass() {
		  
		   prop = new Properties();
		  File propfile = new File(System.getProperty("user.dir")+"//src//main//java//testdataProperties//testData.properties");
		  
		  try {
		  FileInputStream fis = new FileInputStream(propfile);
		  prop.load(fis);
		  }catch(Throwable e)
		  {
			  e.printStackTrace();
		  }
		  
	  }
	  
	
	
	public WebDriver initilizeBrowser(String BrowserName)
	{
		  if(BrowserName.equalsIgnoreCase("Chrome"))
		  {
			 WebDriverManager.chromedriver().setup();
			 driver = new ChromeDriver();
			 
		  }
		  else if(BrowserName.equalsIgnoreCase("Firefox"))
		  {
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  }
		  else
		  {
			  System.out.println("Browser Not Found.......");
		  }
		  
		  driver.get(prop.getProperty("url"));
		  driver.manage().window().maximize();
		  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		  return driver ;
		   
		
	}
	
}
