package testcases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
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
	 pp.clickOnProfileButton();
	  
  }
  @Test(priority=2,enabled=true,alwaysRun=true)
  public void verifying_that_user_able_click_on_the_myProfileButton()
  {
	  pp.ClickOntheMyProfile_After_login();
  }
  @Test(priority=3,enabled =true,alwaysRun=true)
  public void Verify_that_user_is_able_to_select_Passenger_Type()
  {
	  pp.select_PassengerDropDown_Button();
  }
  
  @Test(priority=4,enabled= true,alwaysRun=true)
  public void verify_that_user_is_able_to_click_on_Title()
  {
	  pp.select_TitileDropdown();
	  
  }
  @Test(priority=5,enabled =true,alwaysRun=true)
  public void verify_that_user_is_able_to_enter_firstName()
  {
	  pp.Enter_First_Name("Arjun");
  }
  @Test(priority=6, enabled =true ,alwaysRun=true)
  public void verify_that_user_is_able_to_enter_last_name()
  {
	pp.enterLastName("Singh");	
  }
  @Test(priority=7,enabled=true,alwaysRun=true)
  public void verify_that_user_able_to_enterDOB()
  {
	  pp.enter_DOB();
  }
  @Test(priority=8,enabled=true,alwaysRun=true)
  public void verify_that_user_is_able_to_update_profile()
  {
	  
  }
}
