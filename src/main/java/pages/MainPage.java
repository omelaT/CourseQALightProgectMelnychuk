package pages;

import org.junit.Assert;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage  extends ParentPage{

    @FindBy(xpath =".//*[@class='category-cards']/div[last()]" )
    private WebElement bookStoreMenu;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openMainPage(){
        try{
            webDriver.get("https://demoqa.com/");
            logger.info("Main Page was open");

        }catch(Exception e){
            logger.error("Can't open MainPage " + e);
            Assert.fail("Can't open MainPage " + e);
        }
    }

    public BooksPage clickOnBookStoreAppMenu() {

        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        clickOnElement(bookStoreMenu);
        logger.info("BookStoreMenu was clicked, Book Store app where user can start Log in opened");
        return new BooksPage(webDriver);
    }

    public BooksPage openBookAppLoginPage(){
        openMainPage();
        clickOnBookStoreAppMenu();
        return new BooksPage(webDriver);
    }

}
