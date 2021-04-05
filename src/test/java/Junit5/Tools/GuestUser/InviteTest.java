package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Invite page, Tools")
public class InviteTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Open page")
    @DisplayName("Check invite page is opened in Tools")
    @Test
    void openInvite() {
        draftsPage = topNavigation.clickOnToolsItem();
        invitePage = toolsLeftSidebar.clickOnInviteItemAsGuest();
        refreshPage();
        String expectedResult = "Copy link";
        String actualResult = invitePage.getNameCopyLinkButton();
        assertEquals(expectedResult, actualResult);
    }
}
