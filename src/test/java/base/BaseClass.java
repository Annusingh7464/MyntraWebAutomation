package base;

import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	
	
	
	public void initilizeBrowser(String BrowserName)
	{
		  if(BrowserName.equalsIgnoreCase("Chrome"))
		  {
			 WebDriverManager.chromedriver().setup();
			 
		  }
		   
		
	}
}
