package pages;

import org.junit.Assert;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends ParentPage {
    public BookPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return null;
    }

    @FindBy(xpath= ".//*[@class='text-right fullButton']")
    private WebElement addToTourCollectionButton;

    @FindBy(xpath=".//*[@class='text-left fullButton']")
    private WebElement backToBookStoreButton;

    @FindBy (xpath=".//*[contains(text(),'Git Pocket Guide')]")
    private WebElement gitBookName;

    public BookPage checkTitleOfTheBookDisplayed(String bookTitle) {
        Assert.assertEquals("Git Pocket Guide", bookTitle, gitBookName.getText());
        return this;
    }
    public BookPage checkbackToBookStoreButtonDisplayed(){
        isElementDisplayed(backToBookStoreButton);
        return this;
    }
    public StorePage clickOnBackToBookStoreButton(){
        clickOnElement(backToBookStoreButton);
        safeAlertAccept();
        return new StorePage(webDriver);
    }
    public BookPage clickOnAddToCollectionButton(){
        clickOnElement(addToTourCollectionButton);
        return this;
    }

//    Alert alert = (new WebDriverWait(webDriver, 5))
//            .until(ExpectedConditions.alertIsPresent());
    public void safeAlertAccept() {
        try {
            webDriver.switchTo().alert().accept();
        } catch (NoAlertPresentException e) {
            // ничего не делаем, алерта итак нет
        }
    }

}
