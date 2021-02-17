package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Invite page, Tools")
public class InviteTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check invite page is opened in Tools")
    @Test
    void openInvite() {
        draftsPage = topNavigation.clickOnToolsItem();
        invitePage = toolsLeftSidebar.clickOnInviteItemAsHiveUser();
        refreshPage();
        String expectedResult = "Copy link";
        String actualResult = invitePage.getNameCopyLinkButton();
        assertEquals(expectedResult, actualResult);
    }
}
