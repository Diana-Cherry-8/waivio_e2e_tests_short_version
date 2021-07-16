package Junit5.Tools.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to ukrainian hryvnia for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToUkrainianHryvnia() {
        currency = "UAH";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to russian ruble for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToRussianRuble() {
        currency = "RUB";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to chinese yuan for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToChineseYuan() {
        currency = "CNY";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to japanese yen for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToJapaneseYen() {
        currency = "JPY";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to pound sterling for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToPoundSterling() {
        currency = "GBP";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to mexican peso for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToMexicanPeso() {
        currency = "MXN";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to australian dollar for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToAustralianDollar() {
        currency = "AUD";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @Story("Change currency for waivio")
    @DisplayName("Change currency to euro for waivio via personal settings, and check " +
            "the result on profile post feed")
    @Test
    void changeCurrencyToEuro() {
        currency = "EUR";
        draftsPage = topNavigation.clickOnToolsItem();
        settingsPage = toolsLeftSidebar.clickOnSettingsItem();
        settingsPage.clickOnBaseCurrencyDropdown();
        settingsPage.selectCurrency(currency);
        profilePage = settingsPage.clickSave();
        boolean actualResult = profilePage.isPostPayoutDisplayed(currency);
        assertTrue(actualResult);
    }

    @AfterEach
    void clickLogo() {
        header.clickOnLogo();
    }
}



