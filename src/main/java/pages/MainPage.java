package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage  extends ParentPage{

    @FindBy(xpath =".//*[@class='category-cards']/div[last()]" )
    private WebElement bookStoreMenu;

    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
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

    public BooksPageBeforeLogin clickOnBookStoreAppMenu() {

        scroll();
        clickOnElement(bookStoreMenu);
        logger.info("BookStoreMenu was clicked, Book Store app where user can start Log in opened");
        return new BooksPageBeforeLogin(webDriver);
    }

    public BooksPageBeforeLogin openBookAppLoginPage(){
        openMainPage();
        clickOnBookStoreAppMenu();
        return new BooksPageBeforeLogin(webDriver);
    }

}
