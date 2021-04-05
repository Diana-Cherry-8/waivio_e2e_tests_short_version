package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Bookmarks page, Tools")
public class BookmarksTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
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