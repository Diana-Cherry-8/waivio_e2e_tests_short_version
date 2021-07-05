package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Settings page, Tools")
public class SettingsTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;
    String currency;

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Open page")
    @DisplayName("Check all page is opened in Tools")
    @Test
    void openSettingsTools() {
        feedPage = FeedPage.openFeedPage();
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        refreshPage();
        String expectedResult = "Settings";
        String actualResult = settingsPage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to canadian dollar for waivio via personal settings, and check " +
        "the result on profile post feed")
    @Test
    void changeCurrencyToCanadianDollar() {
        currency = "CAD";
        feedPage = FeedPage.openFeedPage();
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to usd dollar for waivio via personal settings, and check " +
        "the result on profile post feed")
    @Test
    void changeCurrencyToUsdDollar() {
        currency = "USD";
        feedPage = FeedPage.openFeedPage();
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }
}



