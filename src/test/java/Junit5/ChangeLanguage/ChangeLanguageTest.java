package Junit5.ChangeLanguage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeLanguageTest extends TestBase {
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_RUSSIAN_TEXT = "МОЯ ЛЕНТА";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_GERMAN_TEXT = "NEUIGKEITEN";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_FRENCH_TEXT = "MON FLUX";
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_ENGLISH_TEXT = "MY FEED";

  @BeforeAll
  static void openFeed() {
    FeedPage.openFeedPage();
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Russian by not login user")
  @Test
  void changeLanguageToRussianTest() {
    header.clickOnChangeLanguageIcon();
    header.clickOnRussianLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_RUSSIAN_TEXT, topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to German by not login user")
  @Test
  void changeLanguageToGermanTest() {
    header.clickOnChangeLanguageIcon();
    header.clickOnGermanLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_GERMAN_TEXT, topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to French by not login user")
  @Test
  void changeLanguageToFrenchTest() {
    header.clickOnChangeLanguageIcon();
    header.clickOnFrenchLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_FRENCH_TEXT, topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to English by not login user")
  @Test
  void changeLanguageToEnglishTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnEnglishLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_ENGLISH_TEXT, topNavigation.getFeedTabName());
  }
}
