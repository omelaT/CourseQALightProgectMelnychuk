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

    @FindBy(xpath = ".//*[@class='main-header']")
    protected WebElement storeHeader;


    public LoginToBookAppPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }

    public LoginToBookAppPage enterUserName(String login) {
         enterTextInToElement(inputUserNameToLoginField,login);
         return this;
    }

    public LoginToBookAppPage enterUserPassword(String password) {
     enterTextInToElement(inputPasswordToLoginField,password);
     return this;
    }

    public StorePage clickOnLogInButton(){
        clickOnElement(loginButton);
        return new StorePage(webDriver);
    }

    public StorePage logInToBookAppWithValidCred(){
        enterUserName(TestData.VALID_LOGIN);
        enterUserPassword(TestData.VALID_PASSWORD);
        clickOnLogInButton();
        logger.info("login button clicked");
        return new StorePage(webDriver);
    }

    public LoginToBookAppPage checkWarningTextaboutInvalidLogIn(String text){
        Assert.assertEquals("Text in warning ",text, warningTextInvalidLogin.getText() );
        return  this;
    }
    public LoginToBookAppPage checkNameOfHeader(String text){
        Assert.assertEquals("menuheader text ",text, storeHeader.getText());
        return this;
    }


}
