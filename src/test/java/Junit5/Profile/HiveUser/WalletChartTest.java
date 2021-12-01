package Junit5.Profile.HiveUser;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Profile page")
public class WalletChartTest extends TestBase {
  String currency;
  int index;

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Check chart")
  @DisplayName("Change currency to CAD for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToCAD() {
    currency = "CAD";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to USD for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToUSD() {
    currency = "USD";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to UAN for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToUAH() {
    currency = "UAH";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to RUB for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToRUB() {
    currency = "RUB";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to CNY for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToCNY() {
    currency = "CNY";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to JPY for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToJPY() {
    currency = "JPY";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to GBP for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToGBP() {
    currency = "GBP";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to MXN for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToMXN() {
    currency = "MXN";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to AUD for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToAUD() {
    currency = "AUD";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Change currency to EUR for waivio via personal settings, and check " +
      "the result on wallet tab in chart")
  @Test
  void changeCurrencyToEUR() {
    currency = "EUR";

    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    settingsPage = toolsLeftSidebar.clickOnSettingsItem();
    settingsPage.clickOnBaseCurrencyDropdown();
    settingsPage.selectCurrency(currency);
    profilePage = settingsPage.clickSave();
    walletPage = profilePage.clickOnWalletProfileItem();
    boolean actualResult = walletPage.isCurrencyInPriceInChartDisplayed(currency);
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Check that Waiv chart is opened")
  @Test
  void checkWaivChartIsOpened() {
    index = 0; // index for Waiv block
    feedPage = FeedPage.openFeedPage();
    profilePage = header.clickOnAccountIcon();
    walletPage = profilePage.clickOnWalletProfileItem();
    walletPage.clickDisplayChart(index);
    boolean actualResult = walletPage.isChartDataPointPresent();
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Check that Hive chart is opened")
  @Test
  void checkHiveChartIsOpened() {
    index = 1; // index for Hive block
    feedPage = FeedPage.openFeedPage();
    profilePage = header.clickOnAccountIcon();
    walletPage = profilePage.clickOnWalletProfileItem();
    walletPage.clickDisplayChart(index);
    boolean actualResult = walletPage.isChartDataPointPresent();
    assertTrue(actualResult);
  }

  @Story("Check chart")
  @DisplayName("Check that HBD chart is opened")
  @Test
  void checkHBDChartIsOpened() {
    index = 2; // index for HBD block
    feedPage = FeedPage.openFeedPage();
    profilePage = header.clickOnAccountIcon();
    walletPage = profilePage.clickOnWalletProfileItem();
    walletPage.clickDisplayChart(index);
    boolean actualResult = walletPage.isChartDataPointPresent();
    assertTrue(actualResult);
  }
}

