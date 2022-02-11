package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPageBeforeLogin extends ParentPage {

    @FindBy(xpath =".//*[@id='login']" )
    private WebElement loginButton;

    public BooksPageBeforeLogin(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }

    public LoginToBookAppPage clickOnLoginButtonToLogInUser() {
      clickOnElement(loginButton);
      return new LoginToBookAppPage(webDriver);
    }




}
