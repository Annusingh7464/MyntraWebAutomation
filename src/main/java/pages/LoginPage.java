package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utills.Utilitites;

public class LoginPage {

	public WebDriver driver ;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
//=============== Page Objects & Web Elements ========================= 	
	
   @FindBy(id="Login or Signup")	
   private WebElement loginButton;
   

   
//================Page Actions ====================================
   
   public void hoverOnTheLoginButton()
   {
	   Actions action = new Actions(driver);
	   action.moveToElement(loginButton).build().perform();
	   Utilitites.ThreadSleepTimeOut();
   }
   
}//======This is the Class--close Method
