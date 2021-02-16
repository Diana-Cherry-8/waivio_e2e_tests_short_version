package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Settings page, Tools")
public class SettingsTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check all page is opened in Tools")
    @Test
    void openSettingsTools() {
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        refreshPage();
        String expectedResult = "Settings";
        String actualResult = settingsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}



