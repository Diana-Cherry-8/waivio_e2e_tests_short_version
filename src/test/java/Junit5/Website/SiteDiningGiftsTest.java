package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGiftsPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SiteDiningGiftsTest extends TestBase {

  @BeforeAll
  static void openSite() {
    diningGiftsPage = DiningGiftsPage.openDiningGiftsPage();
  }

  @Story("Website dining.gifts")
  @DisplayName("Check objects mark are exist on the map")
  @Test
  void checkObjectsMarksAreExist() {
    assert(diningGiftsPage.areObjectsMarksExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check website logo is exist on the map")
  @Test
  void checkDesktopLogoIsExist() {
    assert(diningGiftsPage.isWebsiteDesktopLogoExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check button my location is exist on the map")
  @Test
  void checkButtonMyLocationIsExist() {
    assert(diningGiftsPage.isButtonMyLocationExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check buttons for zoom are exist on the map")
  @Test
  void checkButtonsForZoomAreExist() {
    assert(diningGiftsPage.areButtonsForZoomExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check search panel is opened")
  @Test
  void checkSearchPanelIsOpened() {
    diningGiftsPage.clickSearchPanel();
    assert(diningGiftsPage.isSearchPanelOpen());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check dish tab is opened")
  @Test
  void checkDishTab() {
    diningGiftsPage.clickSearchPanel();
    diningGiftsPage.clickDishTab();
    String expectedResult = "Dish";
    String actualResult = diningGiftsPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check restaurant tab is opened")
  @Test
  void checkRestaurantTab() {
    diningGiftsPage.clickSearchPanel();
    diningGiftsPage.clickRestaurantTab();
    String expectedResult = "Restaurant";
    String actualResult = diningGiftsPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check drink tab is opened")
  @Test
  void checkDrinkTab() {
    diningGiftsPage.clickSearchPanel();
    diningGiftsPage.clickDrinkTab();
    String expectedResult = "Drink";
    String actualResult = diningGiftsPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check users tab is opened")
  @Test
  void checkUsersTab() {
    diningGiftsPage.clickSearchPanel();
    diningGiftsPage.clickUsersTab();
    assert(diningGiftsPage.areUsersListOpen());
  }

}
