package loginTests;

import baseTest.BaseTest;
import org.junit.Assert;
import org.junit.Test;

public class LoginToBookAppTest extends BaseTest {
    @Test
    public void validLoginTest(){
        mainPage.openMainPage();
        mainPage.clickOnBookStoreAppMenu();
        bookStoreAppLoginPage.clickOnLoginButtonForLogInUser();
        loginToBookAppPage.enterUserName("omela");
       loginToBookAppPage.enterUserPassword("123456Qwerty!");
       loginToBookAppPage.clickOnLogInButton();

        Assert.assertTrue("Buttom Log out is NOT Displayed ", homePageForBookStore.isButtonLogOutDisplayed() );





    }



}

