package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;
import pages.ProfilePage;

public class ProfileTest extends BaseClass 
{
  public WebDriver driver ;
  public ProfilePage pp ;
  public LoginPage lp ;
  
  public  ProfileTest()
  {
	 super ();
  }
  
  @BeforeClass
  public void tearUp()
  {
	  driver = initilizeBrowser(prop.getProperty("browserName"));
	  pp = new ProfilePage(driver);
	  lp = new LoginPage(driver);
	  lp.hoverOnTheLoginButton();// execution 1      
	  lp.clickOnTheCustomerLoginButton();// execution 2
	  lp.enterMobileNumber();//3                                                    
	  lp.clickOnTheContinueButton();//4                                                                         
	  lp.userLoginWith_OTP_Password();//5   
	  
	  /* This is the temprory remove this 
       * after create the coplete class
       * 
       */                                                                          
	  
  }
  @AfterClass
  public void tearDown()
  {
	  driver.quit();
  }
  @Test(priority=1,enabled =true , alwaysRun =true)
  public void Veriy_that_user_is_able_to_click_on_login_button()
  {
	 //pp.clickOnProfileButton();
	  System.out.println("This is the best book....");
  }
  
	
}
