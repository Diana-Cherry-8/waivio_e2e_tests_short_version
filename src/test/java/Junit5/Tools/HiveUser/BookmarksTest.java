package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Bookmarks page, Tools")
public class BookmarksTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check bookmarks page is opened in Tools, if user doesn't have bookmarks")
    @Test
    void openBookmarks() {
        draftsPage = topNavigation.clickOnToolsItem();
        bookmarksPage = toolsLeftSidebar.clickOnBookmarksItem();
        refreshPage();
        String expectedResult = "You don't have any story saved.";
        String actualResult = bookmarksPage.getMessageAnyBookmarks();
        assertEquals(expectedResult, actualResult);
    }

}