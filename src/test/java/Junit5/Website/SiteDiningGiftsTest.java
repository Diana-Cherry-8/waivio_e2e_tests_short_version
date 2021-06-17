package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.NewSitePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SiteDiningGiftsTest extends TestBase {
  static String websiteName = "";
  static String templateName = properties.getProperty("TemplateNameProd");

  @BeforeAll
  static void openSite() {
    newSitePage = NewSitePage.openDiningGifts(websiteName, templateName);
    NewSitePage.closeCookiesWindow();
  }

  @Story("Website dining.gifts")
  @DisplayName("Check objects mark are exist on the map")
  @Test
  void checkObjectsMarksAreExist() {
    assert(newSitePage.areObjectsMarksExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check website logo is exist on the map")
  @Test
  void checkDesktopLogoIsExist() {
    assert(newSitePage.isWebsiteDesktopLogoExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check button my location is exist on the map")
  @Test
  void checkButtonMyLocationIsExist() {
    assert(newSitePage.isButtonMyLocationExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check buttons for zoom are exist on the map")
  @Test
  void checkButtonsForZoomAreExist() {
    assert(newSitePage.areButtonsForZoomExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check search panel is opened")
  @Test
  void checkSearchPanelIsOpened() {
    newSitePage.clickSearchPanel();
    assert(newSitePage.isSearchPanelOpen());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check dish tab is opened")
  @Test
  void checkDishTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickDishTab();
    String expectedResult = "Dish";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check restaurant tab is opened")
  @Test
  void checkRestaurantTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickRestaurantTab();
    String expectedResult = "Restaurant";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check drink tab is opened")
  @Test
  void checkDrinkTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickDrinkTab();
    String expectedResult = "Drink";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check users tab is opened")
  @Test
  void checkUsersTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickUsersTab();
    assert(newSitePage.areUsersListOpen());
  }
}
