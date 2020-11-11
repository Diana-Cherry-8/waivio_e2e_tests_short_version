package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.Components.TopNavigation;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Guests settings page, Tools")
public class GuestsSettingsTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        topNavigation = TopNavigation.initTopNavigation();
    }

    @Story("Open page")
    @DisplayName("Check guests settings page is opened in Tools")
    @Test
    void openGuestsSettingsTools() {
        draftsPage = topNavigation.clickOnToolsItem();
        guestsSettingsPage = toolsLeftSidebar.clickOnGuestsSettingsItem();
        refreshPage();
        String expectedResult = "Guests Account Settings";
        String actualResult = guestsSettingsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}



