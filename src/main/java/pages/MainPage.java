package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MainPage  extends ParentPage{
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public void openMainPage(){
        try{
            webDriver.get("https://demoqa.com/");
            logger.info("Main Page was open");

        }catch(Exception e){
            logger.error("Can't open MainPage " + e);
            Assert.fail("Can't open MainPage " + e);

        }
    }

    public void clickOnBookStoreAppMenu() {
       // WebElement driver;
//        WebElement element = webDriver.findElement(By.xpath(".//*[@class='category-cards']/div[last()]"));
//        Actions actions = new Actions(webDriver);
//        actions.moveToElement(element);
//        actions.perform();
        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("javascript:window.scrollBy(250,350)");
        try{
            webDriver.findElement(By.xpath(".//*[@class='category-cards']/div[last()]")).isDisplayed();
            webDriver.findElement(By.xpath(".//*[@class='category-cards']/div[last()]")).click();
            logger.info("BookStoreMenu was clicked");
        }catch(Exception e){
            printErrorAndStopTest(e);
        }

    }

}
