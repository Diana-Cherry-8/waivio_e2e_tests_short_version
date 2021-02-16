package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Drafts page, Tools")
public class DraftsTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check drafts page is opened in Tools")
    @Test
    void openDrafts() {
        draftsPage = topNavigation.clickOnToolsItem();
        draftsPage = toolsLeftSidebar.clickOnDraftsItem();
        refreshPage();
        String expectedResult = "Drafts";
        String actualResult = draftsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }

}

