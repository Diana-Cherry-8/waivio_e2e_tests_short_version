package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Notifications page, Tools")
public class NotificationsTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check notifications page is opened in Tools")
    @Test
    void openNotificationsTools() {
        draftsPage = topNavigation.clickOnToolsItem();
        toolsNotificationsPage = toolsLeftSidebar.clickOnNotificationsItem();
        refreshPage();
        String expectedResult = "Notification Settings";
        String actualResult = toolsNotificationsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}




