package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utills.Utilitites;

public class ProfilePage 
{
	public WebDriver driver ;

	public ProfilePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
//====================================== WebElement & Objects =============================================================
	@FindBy(id="welcome-det-User")
	private WebElement Afterlogin_Button;
	
	@FindBy(xpath="//span[contains(text(),'My Profile')]")
	private WebElement ProfileButton_After_Login;
	
	@FindBy(xpath="//div[@class='breadcrum f15']//li[contains(text(),'Profile')]")
	private WebElement profileText;
	
	@FindBy(id="passengerType")
	private WebElement passangerTypeDropDownButton;
	
	@FindBy(xpath="//select[@class='inpprof actvippbx ng-scope ng-pristine ng-valid']")
	private WebElement clickOnTitleDropDown;
	
	@FindBy(id="fName")
	private WebElement ClickOnFirtName;
	
	@FindBy(id="lName")
	private WebElement ClickOnlastName;
	
	@FindBy(id="dob")
	private WebElement clickOnDOB;
	
	@FindBy(xpath="//div[@class='blu_btn algit flx f13 fill_btn']")
	private WebElement updateProfileButton;
	

	
//============================Action_Methods==========================================================================
  public void clickOnProfileButton()
  {
	     Actions action = new Actions(driver);
	     Utilitites.ExplicitlyWait(driver, Afterlogin_Button);
		 action.moveToElement(Afterlogin_Button).build().perform();
		 
  }
  public void ClickOntheMyProfile_After_login()
  {
	  ProfileButton_After_Login.click();
	  String AcctualProfileText = profileText.getText();
	  Assert.assertEquals(AcctualProfileText,"Profile","Element not found");
  }
  public void select_PassengerDropDown_Button()
  {
	  Utilitites.commonMthodForDropDown_Button(passangerTypeDropDownButton, 1);
	  Utilitites.ExplicitlyWait(driver,passangerTypeDropDownButton);
  }
  public void select_TitileDropdown()
  {
	  Utilitites.commonMthodForDropDown_Button(clickOnTitleDropDown, 2);
	  Utilitites.ThreadSleepTimeOut();
  }
  public void Enter_First_Name(String FirstName)
  {
	  ClickOnFirtName.sendKeys(FirstName);
  }
  
  public void enterLastName(String lastName)
  {
	  ClickOnlastName.sendKeys(lastName);
  }
  public void enter_DOB()
  {
	  clickOnDOB.click();
	  clickOnDOB.clear();
	  clickOnDOB.sendKeys("2000-08-09");
  }
  public void updateProfile()
  {
	  updateProfileButton.click();
  }
  
	
  
}//==== Class Closed Breaket =========
