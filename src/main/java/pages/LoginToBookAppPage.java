package pages;

import libs.TestData;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginToBookAppPage  extends ParentPage{

    @FindBy(xpath = ".//*[@placeholder='UserName']")
    private WebElement inputUserNameToLoginField;

    @FindBy(xpath = ".//*[@placeholder='Password']")
    private WebElement inputPasswordToLoginField;

    @FindBy(xpath = ".//*[@id='login']")
    private WebElement loginButton;

    @FindBy(xpath = ".//*[@id='name']")
    private WebElement warningTextInvalidLogin;


    public LoginToBookAppPage(WebDriver webDriver) {
        super(webDriver);
    }

    public LoginToBookAppPage enterUserName(String login) {
         enterTextInToElement(inputUserNameToLoginField,login);
         return this;
    }

    public LoginToBookAppPage enterUserPassword(String password) {
     enterTextInToElement(inputPasswordToLoginField,password);
     return this;
    }

    public HomePageForBookStore clickOnLogInButton(){
        clickOnElement(loginButton);
        return new HomePageForBookStore(webDriver);
    }

    public HomePageForBookStore logInToBookAppWithValidCred(){
        enterUserName(TestData.VALID_LOGIN);
        enterUserPassword(TestData.VALID_PASSWORD);
        clickOnLogInButton();
        return new HomePageForBookStore(webDriver);
    }

    public LoginToBookAppPage checkWarningTextaboutInvalidLogIn(String text){
        Assert.assertEquals("Text in warning ",text, warningTextInvalidLogin.getText() );
        return  this;
    }







}
