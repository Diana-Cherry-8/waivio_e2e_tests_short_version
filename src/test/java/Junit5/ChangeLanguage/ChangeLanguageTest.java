package Junit5.ChangeLanguage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeLanguageTest extends TestBase {
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_RUSSIAN_TEXT = "МОЯ ЛЕНТА";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_GERMAN_TEXT = "NEUIGKEITEN";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_FRENCH_TEXT = "MON FLUX";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_ENGLISH_TEXT = "MY FEED";


  @Story("Change site language")
  @DisplayName("Check change site language to Russian by not login user")
  @Test
  void changeLanguageToRussianTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnRussianLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_RUSSIAN_TEXT, topNavigation.getTopNavigationItemByIndex(0).getText());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to German by not login user")
  @Test
  void changeLanguageToGermanTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnGermanLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_GERMAN_TEXT, topNavigation.getTopNavigationItemByIndex(0).getText());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to French by not login user")
  @Test
  void changeLanguageToFrenchTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnFrenchLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_FRENCH_TEXT, topNavigation.getTopNavigationItemByIndex(0).getText());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to English by not login user")
  @Test
  void changeLanguageToEnglishTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnEnglishLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_ENGLISH_TEXT, topNavigation.getTopNavigationItemByIndex(0).getText());
  }
}
