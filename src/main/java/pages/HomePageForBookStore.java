package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageForBookStore extends ParentPage{
    @FindBy(xpath = ".//*[@id='submit']")
    private WebElement logOutButton;

    public HomePageForBookStore(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean  isButtonLogOutDisplayed() {
        try {
            return isElementDisplayed(logOutButton);
        } catch (Exception e) {
            return false;
        }
    }

    public HomePageForBookStore checkIsButtonLogOutDisplayed(){
        Assert.assertTrue("Button log out is not displayed ", isButtonLogOutDisplayed() );
        return this;
    }

}
