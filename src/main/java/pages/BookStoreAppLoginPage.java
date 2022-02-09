package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BookStoreAppLoginPage extends ParentPage {
    public BookStoreAppLoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickOnLoginButtonForLogInUser() {
        try {
            webDriver.findElement(By.xpath(".//*[@id='login']")).click();
            logger.info("Log In button was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }


}
