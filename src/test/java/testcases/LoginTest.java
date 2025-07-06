package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseClass;

public class LoginTest extends BaseClass{
	
	public WebDriver driver ;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void tearUp()
	{
		driver = initilizeBrowser(prop.getProperty("browserName"));
	}
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	@Test(priority =1 , enabled = true)
	public void dummyTesting()
	{
		System.out.println("This is the testing of From the Login test methods");
	}

	
	
}
