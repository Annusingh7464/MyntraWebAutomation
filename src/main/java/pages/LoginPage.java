package pages;

import java.time.Duration;
import java.util.Scanner;

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
   
   @FindBy(id="txtOTP0")
   private WebElement enterOTPFiled;
   
   @FindBy(id="OtpLgnBtn")
   private WebElement loginButtonAfterEnterOTP;
   
   

   
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
   }
   public void enterOTPField()
   {
	   Scanner sc = new Scanner(System.in);
	   System.out.println("Enter Your OTP");
	   String otp = sc.nextLine();
	   sc.close();
	   
	   if(otp.length() !=6)
	   {
		   System.out.println("You have entered wrong otp");
	   }
	   for(int i=0 ;i<otp.length(); i++)
	   {
		    
		    char digit = otp.charAt(i);
	        String xpath = "//input[@id='txtOTP" + i + "']";
	        WebElement otpbox = driver.findElement(By.xpath(xpath));// till here we have created the Xpath
		    otpbox.sendKeys(String.valueOf(otp.charAt(i)));
		    
		    
		    
		    
	   }
	  
	   loginButtonAfterEnterOTP.click();
   }
   


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
   
}//======This is the Class--close Method
