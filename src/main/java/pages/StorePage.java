package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class StorePage extends ParentPage {

    public StorePage(WebDriver webDriver) {
        super(webDriver);
    }

    @FindBy(xpath = ".//*[@id='see-book-Git Pocket Guide']")
    protected WebElement gitBookName;

    @FindBy(xpath = ".//*[@id='see-book-Learning JavaScript Design Patterns']")
    protected WebElement javaScriptBookName;

    @FindBy(xpath = ".//*[@id='searchBox']")
    protected WebElement searchField;

    @FindBy(xpath = ".//*[@class='main-header']")
    protected WebElement storeHeader;

    @FindBy(xpath = ".//*[contains(text(),'Profile')]")
    protected WebElement profileMenu;

    public StorePage checkIsGitBookDisplayed() {
        isElementDisplayed(gitBookName);
        return this;
    }

    public StorePage checkIsJavaScriptBookDisplayed() {
        isElementDisplayed(javaScriptBookName);
        return this;
    }

    public BookPage clickOnGitBookPage() {
        clickOnElement(gitBookName);
        return new BookPage(webDriver);
    }

    public BookPage clickOnJavaScriptBookPage() {
        clickOnElement(javaScriptBookName);
        return new BookPage(webDriver);
    }

    public StorePage checkTheNameOfTheBook(String text) {
        Assert.assertEquals("Git Pocket Guide", text, gitBookName.getText());
        return this;
    }
    public StorePage checkTheNameOfTheJavaScriptBook(String text) {
        Assert.assertEquals("Learning JavaScript Design Patterns", text, javaScriptBookName.getText());
        return this;
    }


    public StorePage searchFieldIsDisplayed() {
        isElementDisplayed(searchField);
        logger.info("search field displayed");
        return this;

        }


    public StorePage inputBookNameIntoSearchField(String text) {
        enterTextInToElement(searchField, text);
        return this;
    }
    public StorePage checkNameOfHeader(String text){
        Assert.assertEquals("menuheader text ",text, storeHeader.getText());
        return this;
    }

    public ProfilePage clickOnProfileMenu(){
        scroll();
        clickOnElement(profileMenu);
        return new ProfilePage(webDriver);
    }

    @Override
    String getRelativeUrl() {
        return "https://demoqa.com/books";
    }
    public  StorePage checkIsRedirectToStorePage(){
        checkUrlWithPattern();
      //  Assert.assertTrue("Edit Button is not displayed. ",  (editButton));
        return this;
    }




}
