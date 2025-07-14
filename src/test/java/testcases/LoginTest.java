package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import base.BaseClass;
import pages.LoginPage;
import utills.Utilitites;

public class LoginTest extends BaseClass{
	
	public WebDriver driver ;
	public LoginPage lp ;
	
	public LoginTest()
	{
		super();
	}
	
	@BeforeMethod
	public void tearUp()
	{
		driver = initilizeBrowser(prop.getProperty("browserName"));
		lp = new LoginPage(driver);
	}
	@AfterMethod
	public void tearDown()
	{
		//driver.quit();
	}
	
	@Test(priority=1,enabled =true)
	public void userLogin()
	{
		lp.hoverOnTheLoginButton();
		lp.clickOnTheCustomerLoginButton();
		lp.enterMobileNumber();
		lp.clickOnTheContinueButton();
		lp.userLoginWith_OTP_Password();
		lp.logoutUser();
	}
	

	
	
}
