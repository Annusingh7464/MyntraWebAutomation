package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	

	
//============================Action_Methods==========================================================================
  public void clickOnProfileButton()
  {
	     Actions action = new Actions(driver);
		 action.moveToElement(Afterlogin_Button).build().perform();
  }
	
}//==== Class Closed Breaket =========
