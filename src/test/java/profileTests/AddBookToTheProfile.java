package profileTests;

import baseTest.BaseTest;
import org.junit.Test;

public class AddBookToTheProfile extends BaseTest {

    @Test
    public void addOneBookToTheProfileAndDeleteIt(){
        validLogin();
        storePage.checkNameOfHeader("Book Store")
                .clickOnGitBookPage();
        bookPage.checkTitleOfTheBookDisplayed("Git Pocket Guide")
                .clickOnAddToCollectionButton()
                .safeAlertAccept();
        bookPage.checkbackToBookStoreButtonDisplayed()
                .clickOnBackToBookStoreButton();
        storePage.clickOnProfileMenu();
        profilePage.checkBookIsAdded();

        // обработать алерт для удаления
           //     .deleteBookFromTheProfile();






    }
}
