package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;


public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;

    public ParentPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        //инициализирует єлементы страничек, описанне через аннотацию FindBy
        PageFactory.initElements(webDriver, this);
    }

    protected void enterTextInToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed " + webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement){
        try{
            webElement.isDisplayed();
            webElement.click();
            logger.info(webElement +" was clicked");
        }catch(Exception e){
            printErrorAndStopTest(e);
        }
    }
    protected boolean isElementDisplayed(WebElement webElement){
        try {
         return  webElement.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }

    public void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element " + e);
        Assert.fail("Can't work with element " + e);
    }


}
