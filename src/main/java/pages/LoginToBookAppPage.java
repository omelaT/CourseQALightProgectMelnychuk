package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginToBookAppPage  extends ParentPage{
    public LoginToBookAppPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void enterUserName(String login) {
        try{
            webDriver.findElement(By.xpath(".//*[@placeholder='UserName']")).clear();
            webDriver.findElement(By.xpath(".//*[@placeholder='UserName']")).sendKeys(login);
            logger.info(login + "Username/login was inputed");

        }catch(Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void enterUserPassword(String password) {
        try{
            webDriver.findElement(By.xpath(".//*[@placeholder='Password']")).clear();
            webDriver.findElement(By.xpath(".//*[@placeholder='Password']")).sendKeys(password);
            logger.info(password + "password was inputed");

        }catch(Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void clickOnLogInButton(){
        try{
            webDriver.findElement(By.xpath(".//*[@id='login']")).click();
            logger.info("Log In button was clicked");
        }catch(Exception e){
            printErrorAndStopTest(e);
        }
    }



}
