package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Notifications page, Tools")
public class NotificationsTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Open page")
    @DisplayName("Check notifications page is opened in Tools")
    @Test
    void openNotificationsTools() {
        draftsPage = topNavigation.clickOnToolsItem();
        toolsNotificationsPage = toolsLeftSidebar.clickOnNotificationsItemAsGuest();
        refreshPage();
        String expectedResult = "Notification Settings";
        String actualResult = toolsNotificationsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}




