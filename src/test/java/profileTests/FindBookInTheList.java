package profileTests;

import baseTest.BaseTest;

import org.junit.Assert;
import org.junit.Test;

public class FindBookInTheList extends BaseTest {

    @Test
    public void checkBookNameInTheList() {
        validLogin();

        storePage.checkNameOfHeader("Book Store")
                .checkIsGitBookDisplayed()
                .checkTheNameOfTheBook("Git Pocket Guide");

    }

    @Test
    public void findBookViaSearchField() {
        validLogin();
        storePage.checkNameOfHeader("Book Store")
                .searchFieldIsDisplayed()
                .inputBookNameIntoSearchField("Git Pocket Guide")
                .checkTheNameOfTheBook("Git Pocket Guide");
    }

    @Test
    public void returnToStoreFromBookDescription() {
        validLogin();
        storePage.checkNameOfHeader("Book Store")
                .searchFieldIsDisplayed()
                .inputBookNameIntoSearchField("Git Pocket Guide")
                .checkTheNameOfTheBook("Git Pocket Guide")
        .clickOnGitBookPage();
        bookPage.checkTitleOfTheBookDisplayed("Git Pocket Guide")
                .clickOnBackToBookStoreButton()
                .checkIsRedirectToStorePage();
    }

}
