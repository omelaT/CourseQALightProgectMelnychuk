package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends ParentPage {
    public BookPage(WebDriver webDriver) {
        super(webDriver);
    }
    @FindBy(xpath= ".//*[@class='text-right fullButton']")
    private WebElement addToTourCollectionButton;

    @FindBy(xpath=".//*[@class='text-left fullButton']")
    private WebElement backToBookStoreButton;
}
