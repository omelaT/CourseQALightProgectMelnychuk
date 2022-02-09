package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePageForBookStore extends ParentPage{
    public HomePageForBookStore(WebDriver webDriver) {
        super(webDriver);
    }

    public boolean isButtonLogOutDisplayed() {
        try {
            return webDriver.findElement(By.xpath(".//*[@id='submit']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
