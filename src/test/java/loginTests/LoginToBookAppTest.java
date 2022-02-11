package loginTests;

import baseTest.BaseTest;
import libs.TestData;
import org.junit.Assert;
import org.junit.Test;

public class LoginToBookAppTest extends BaseTest {
    @Test
    public void validLoginTest() {
        mainPage.openMainPage();
        mainPage.clickOnBookStoreAppMenu();
        booksPage.clickOnLoginButtonToLogInUser();
        loginToBookAppPage.enterUserName(TestData.VALID_LOGIN);
        loginToBookAppPage.enterUserPassword(TestData.VALID_PASSWORD);
        loginToBookAppPage.clickOnLogInButton();

        Assert.assertTrue("Button Log out is NOT Displayed ",
                profilePage.isButtonLogOutDisplayed());
    }


    @Test
    public void validLoginTest2() {
        mainPage.openBookAppLoginPage();
        loginToBookAppPage.clickOnLogInButton();
        booksPage.clickOnLoginButtonToLogInUser();
        loginToBookAppPage.logInToBookAppWithValidCred();

        Assert.assertTrue("Button Log out is NOT Displayed ",
                profilePage.isButtonLogOutDisplayed());
    }
    @Test
    public void validLogInTest3(){
        validLogin();
        Assert.assertTrue("Button Log out is NOT Displayed ",
                profilePage.isButtonLogOutDisplayed());
    }

    @Test
    public void invalidUsernameWhileLogIn(){
        mainPage.openBookAppLoginPage();
        loginToBookAppPage.clickOnLogInButton();
        booksPage.clickOnLoginButtonToLogInUser();
        loginToBookAppPage.enterUserName(TestData.INVALID_LOGIN)
                .enterUserPassword(TestData.VALID_PASSWORD)
                .clickOnLogInButton();
        loginToBookAppPage.checkWarningTextaboutInvalidLogIn("Invalid username or password!");

        Assert.assertFalse("Button Log out is  Displayed ",
                profilePage.isButtonLogOutDisplayed());




    }







}

