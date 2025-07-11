package pages;

import java.time.Duration;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utills.Utilitites;

public class LoginPage {

	public WebDriver driver ;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver ;
		PageFactory.initElements(driver, this);
	}
	
//=============== Page Objects & Web Elements ========================= 	
	
   @FindBy(xpath="//a[@class='_btnclick' or @id='Login or Signup']")	
   private WebElement loginButton;
   
   @FindBy(id="shwlogn")
   private WebElement customerLoginButton;
   
   @FindBy(id="txtEmail")
   private WebElement mobileNumberField;
   @FindBy(id="shwotp")
   private WebElement continueButtonOfMobileNumber ;
   
   @FindBy(id="txtEmail2")
   private WebElement loginPassword;
   
   @FindBy(id="OtpLgnBtn")
   private WebElement loginButtonAfterEnterOTP;
   
   @FindBy(xpath="//div[contains(text(),'Password Authentication')]")
   private WebElement passwordAuthenticationText;
   
   @FindBy(xpath="//div[contains(text(),'Otp Authentication')]")
   private WebElement otpAuthenticationText;
   
   

   
//================Page Actions ====================================
   
   public void hoverOnTheLoginButton()
   {
	   Utilitites.MouseHoverAction(driver);
   }
   public void clickOnTheCustomerLoginButton()
   {
	   customerLoginButton.click();
   }
   public void enterMobileNumber()
   {
	   mobileNumberField.sendKeys("7464959384");
   }
   public void clickOnTheContinueButton()
   {
	    continueButtonOfMobileNumber.click();
	    
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		 try {
		        wait.until(ExpectedConditions.visibilityOf(passwordAuthenticationText));
		        String passwordText = passwordAuthenticationText.getText();
		        System.out.println("Displayed Option: " + passwordText);
		  
		  } catch (org.openqa.selenium.TimeoutException e ) 
		  { 
			  try{
		            wait.until(ExpectedConditions.visibilityOf(otpAuthenticationText)); 
		            String otpText = otpAuthenticationText.getText();
		            System.out.println("Displayed Option: " + otpText);
		  
		  } catch (org.openqa.selenium.TimeoutException ex) 
			 {
		       System.out.println("Neither OTP nor Password is displaying"); 
		  } 
		}
		 

   	   
   	  
   }
	
//	  public void otp_PasswordLogin() 
//	  { 
//		   
//	  }
	 
	  	
//    	if(passwordText.equalsIgnoreCase(""))
//    	{
//    		
//    	}
    	
    //}
	/*
	 * public void enterOTPField() { Utilitites.userInputAsOTP(driver);
	 * 
	 * } public void enterLoginPassword() {
	 * loginButtonAfterEnterOTP.sendKeys("Annu@123"); }
	 */
   


//==Getter & Setter Methods================================
// Login Button================================================
 public WebElement getLoginButton()
 {
	 return loginButton ;
 }
 public void setLoginButton(WebElement loginButton)
 {
	   this.loginButton = loginButton;
 }
 //== this method is using to get otp login button.........
 public WebElement getloginButtonAfterEnterOTP( )
 {
	 return loginButtonAfterEnterOTP ;
 }
  public void setloginButtonAfterEnterOTP(WebElement loginButtonAfterEnterOTP)
 {
	 this.loginButtonAfterEnterOTP=loginButtonAfterEnterOTP;
 }
   
}//======This is the Class--close Method
