package testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
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
	
	@BeforeClass
	public void tearUp()
	{
		driver = initilizeBrowser(prop.getProperty("browserName"));
		lp = new LoginPage(driver);
	}
	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}
	
	@Test(priority=1,enabled =true, alwaysRun =true)
	public void hoverOnTheLoginButtonAction()
	{    
		lp.hoverOnTheLoginButton();
    }
	
	@Test(priority=2,enabled = true, alwaysRun=true)
	public void clickOntheCustomerLoginButtonAction()
	{
		lp.clickOnTheCustomerLoginButton();
	}
	
    @Test(priority=3,enabled=true, alwaysRun=true)
	public void enterMobileNumberAction()
	{
		lp.enterMobileNumber();
	}
    
	@Test(priority=4,enabled=true, alwaysRun=true)
	public void clickOnTheContinueButtonAction()
	{
		lp.clickOnTheContinueButton();
	}
	
	@Test(priority=5,enabled=true, alwaysRun=true)
	public void userLoginWith_OTP_PasswordAction()
	{
		lp.userLoginWith_OTP_Password();
	}

	
	
}
