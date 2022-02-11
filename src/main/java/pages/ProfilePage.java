package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProfilePage extends ParentPage{
    @FindBy(xpath = ".//*[@id='submit']")
    private WebElement logOutButton;

    @FindBy(xpath=".//*[@id='gotoStore']")
    private WebElement goToStoreButton;

    @FindBy(xpath=".//*[@class='text-right button di']")
    private WebElement deleteAllBooksButton;

    @FindBy(xpath="")
    private WebElement deleteOneBookFromTheTableButton;




    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean  isButtonLogOutDisplayed() {
        try {
            return isElementDisplayed(logOutButton);
        } catch (Exception e) {
            return false;
        }
    }

    public ProfilePage checkIsButtonLogOutDisplayed(){
        Assert.assertTrue("Button log out is not displayed ", isButtonLogOutDisplayed() );
        return this;
    }

}
