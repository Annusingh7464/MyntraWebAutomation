package utills;

import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

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
  

}//====== Class ======
