package pages;

import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;

import org.openqa.selenium.*;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;


import static org.hamcrest.CoreMatchers.containsString;


abstract public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;



 public static ConfigProperties configProperties =
         ConfigFactory.create(ConfigProperties.class);

    protected String baseUrl=configProperties.base_url();

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


    abstract String getRelativeUrl();
    protected void checkUrlWithPattern(){
        System.out.println(baseUrl);
        Assert.assertThat("Invalid page",webDriver.getCurrentUrl()
                ,containsString("https://demoqa.com/books"));

    }

    protected void checkUrl() {
        Assert.assertEquals("Invalid page"
                , baseUrl + getRelativeUrl()
                , webDriver.getCurrentUrl());
    }

    protected void scroll() {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("javascript:window.scrollBy(250,350)");
    }

    public void safeAlertAccept() {
        try {
            webDriver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // ничего не делаем, алерта итак нет
        }
    }

}
