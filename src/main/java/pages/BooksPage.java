package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BooksPage extends ParentPage {

    @FindBy(xpath =".//*[@id='login']" )
    private WebElement loginButton;

    public BooksPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginToBookAppPage clickOnLoginButtonToLogInUser() {
      clickOnElement(loginButton);
      return new LoginToBookAppPage(webDriver);

    }



}
