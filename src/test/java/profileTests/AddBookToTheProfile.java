package profileTests;

import baseTest.BaseTest;
import org.junit.Test;

import static java.lang.Thread.sleep;

public class AddBookToTheProfile extends BaseTest {

    @Test
    public void addOneBookToTheProfileAndDeleteIt() throws InterruptedException {
        validLogin();
        storePage.checkNameOfHeader("Book Store")
                .clickOnGitBookPage();
        bookPage.checkTitleOfTheBookDisplayed("Git Pocket Guide")
                .clickOnAddToCollectionButton()
                .safeAlertAccept();
        sleep(1000);
        bookPage.checkbackToBookStoreButtonDisplayed()
                .clickOnBackToBookStoreButton();
        sleep(1000);
        storePage.clickOnProfileMenu();
        profilePage.checkBookIsAdded()
                .deleteBookFromTheProfile();
        profilePage.safeAlertAccept();
        profilePage.clickOnGoToBookStoreButton();

    }

    @Test
    public void addBooksAndClickOnDeleteAllButton() throws InterruptedException {
        validLogin();
        storePage
                .clickOnGitBookPage();
        bookPage.checkTitleOfTheBookDisplayed("Git Pocket Guide")
                .clickOnAddToCollectionButton()
                .safeAlertAccept();
        // sleep(1000);
        bookPage.checkbackToBookStoreButtonDisplayed()
                .clickOnBackToBookStoreButton();
        //  sleep(1000);
        storePage.clickOnJavaScriptBookPage();
        bookPage.clickOnAddToCollectionButton();
        sleep(2000);
        bookPage.safeAlertAccept();
        sleep(2000);
        bookPage.clickOnBackToBookStoreButton();
        sleep(2000);
        storePage.clickOnProfileMenu();

        profilePage.clickOnDeleteAllBooksButton()
                .safeAlertAccept();
        sleep(1000);


    }
}
