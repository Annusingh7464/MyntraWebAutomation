package utills;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import pages.LoginPage;

public class Utilitites {
	
	
 public static void ThreadSleepTimeOut()
 {  try {
	 Thread.sleep(5000);
    }catch(Exception e)
 {
    	e.printStackTrace();
 }
 }
 public static  void MouseHoverAction(WebDriver driver)
 {       LoginPage lp = new LoginPage(driver);
	     Actions action = new Actions(driver);
	    action.moveToElement(lp.getLoginButton()).build().perform();
 }

}
