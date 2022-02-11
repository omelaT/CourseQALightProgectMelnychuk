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

    @FindBy(xpath=".//*[@id='delete-record-undefined']")
    private WebElement deleteOneBookFromTheTableButton;

    @FindBy(xpath =".//*[@id='see-book-Git Pocket Guide']")
    private WebElement bookName;




    public ProfilePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
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


    public StorePage clickOnGoToBookStoreButton() {
        clickOnElement(goToStoreButton);
        return new StorePage(webDriver);
    }

    public ProfilePage checkBookIsAdded(){
        isElementDisplayed(bookName);
         return this;
    }
    public ProfilePage deleteBookFromTheProfile(){
        clickOnElement(deleteOneBookFromTheTableButton);
        return this;
    }
}
