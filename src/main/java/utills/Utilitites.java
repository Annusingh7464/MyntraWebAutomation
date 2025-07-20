package utills;

import java.time.Duration;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pages.LoginPage;

public class Utilitites {
	
	 public static  LoginPage lp ;
 public static void ThreadSleepTimeOut()
 {  try {
	 Thread.sleep(5000);
    }catch(Exception e)
 {
    	e.printStackTrace();
 }
 }
 //this method is for the login hover  
 public static  void MouseHoverAction(WebDriver driver)
 {        lp = new LoginPage(driver);
	      Actions action = new Actions(driver);
	      action.moveToElement(lp.getLoginButton()).build().perform();
 }
  public static void userInputAsOTP(WebDriver driver)
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
	    lp.getloginButtonAfterEnterOTP().click();
	    
 }
  public static void commonMthodForDropDown_Button(WebElement DropDownButton, int indexValue)
  {
	  Select select = new Select(DropDownButton);
	  select.selectByIndex(indexValue);
  }
  public static void ExplicitlyWait(WebDriver driver ,WebElement Afterlogin_Button)
  {
	     WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(15));
	     wait.until(ExpectedConditions.visibilityOfAllElements(Afterlogin_Button));
  }
  

}//====== Class ======
