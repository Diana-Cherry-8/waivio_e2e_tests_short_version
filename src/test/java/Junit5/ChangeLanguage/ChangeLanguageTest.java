package Junit5.ChangeLanguage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeLanguageTest extends TestBase {
  String language;

  @BeforeAll
  static void openFeed() {
    FeedPage.openFeedPage();
  }

  @Story("Change site language")
  @DisplayName("Check change site language to English by not login user")
  @Test
  void changeLanguageToEnglishTest() {
    language = "English";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Indonesian by not login user")
  @Test
  void changeLanguageToIndonesianTest() {
    language = "Indonesian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Malay by not login user")
  @Test
  void changeLanguageToMalayTest() {
    language = "Malay";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Catalan by not login user")
  @Test
  void changeLanguageToCatalanTest() {
    language = "Catalan";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Czech by not login user")
  @Test
  void changeLanguageToCzechTest() {
    language = "Czech";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Danish by not login user")
  @Test
  void changeLanguageToDanishTest() {
    language = "Danish";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to German by not login user")
  @Test
  void changeLanguageToGermanTest() {
    language = "German";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Estonian by not login user")
  @Test
  void changeLanguageToEstonianTest() {
    language = "Estonian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Spanish by not login user")
  @Test
  void changeLanguageToSpanishTest() {
    language = "Spanish";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Filipino by not login user")
  @Test
  void changeLanguageToFilipinoTest() {
    language = "Filipino";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to French by not login user")
  @Test
  void changeLanguageToFrenchTest() {
    language = "French";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Croatian by not login user")
  @Test
  void changeLanguageToCroatianTest() {
    language = "Croatian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Italian by not login user")
  @Test
  void changeLanguageToItalianTest() {
    language = "Italian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Hungarian by not login user")
  @Test
  void changeLanguageToHungarianTest() {
    language = "Hungarian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Polish by not login user")
  @Test
  void changeLanguageToPolishTest() {
    language = "Polish";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Portuguese by not login user")
  @Test
  void changeLanguageToPortugueseTest() {
    language = "Portuguese";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Russian by not login user")
  @Test
  void changeLanguageToRussianTestNew() {
    language = "Russian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Ukrainian by not login user")
  @Test
  void changeLanguageToUkrainianTestNew() {
    language = "Ukrainian";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Arabic by not login user")
  @Test
  void changeLanguageToArabicTestNew() {
    language = "Arabic";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Hindi by not login user")
  @Test
  void changeLanguageToHindiTestNew() {
    language = "Hindi";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Korean by not login user")
  @Test
  void changeLanguageToKoreanTestNew() {
    language = "Korean";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Japanese by not login user")
  @Test
  void changeLanguageToJapaneseTestNew() {
    language = "Japanese";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Afrikaans by not login user")
  @Test
  void changeLanguageToAfrikaansTestNew() {
    language = "Afrikaans";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }

  @Story("Change site language")
  @DisplayName("Check change site language to Chinese by not login user")
  @Test
  void changeLanguageToChineseTestNew() {
    language = "Chinese";
    header.clickOnChangeLanguageIcon();
    header.chooseLanguage(language);
    assertEquals(header.expectedLanguage(language), topNavigation.getFeedTabName());
  }
}
