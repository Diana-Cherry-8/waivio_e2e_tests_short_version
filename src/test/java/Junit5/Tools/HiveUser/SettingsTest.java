package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Settings page, Tools")
public class SettingsTest extends TestBase {
    String currency;

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check Settings page is opened in Tools")
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
        boolean actualResult = profilePage.isPostPayoutWithCanadianDollarDisplayed();
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
        boolean actualResult = profilePage.isPostPayoutWithDollarDisplayed();
        assertTrue(actualResult);
    }

}



