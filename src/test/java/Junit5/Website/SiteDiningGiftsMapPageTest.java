package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.MapPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class SiteDiningGiftsMapPageTest extends TestBase {

  static String websiteName = "";
  static String templateName = "dining.gifts";

  @BeforeAll
  static void openSite() {
    mapPage = MapPage.openDiningGiftsMap(websiteName, templateName);
  }

  @Story("Website dining.gifts")
  @DisplayName("Check objects mark are exist on the map")
  @Test
  void checkObjectsMarksAreExist() {
    assert(mapPage.areObjectsMarksExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check button my location is exist on the map")
  @Test
  void checkButtonMyLocationIsExist(){
    assert(mapPage.isButtonMyLocationExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check buttons for zoom are exist on the map")
  @Test

  void checkButtonsForZoomAreExist() {
    assert(mapPage.areButtonsForZoomExist());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check search panel is opened")
  @Test
  void checkSearchPanelIsOpened() {
    mapPage.clickSearchPanel();
    assert(mapPage.isSearchPanelOpen());
  }

  @Story("Website dining.gifts")
  @DisplayName("Check dish tab is opened")
  @Test
  void checkDishTab() {
    mapPage.clickSearchPanel();
    mapPage.clickDishTab();
    String expectedResult = "Dish";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check restaurant tab is opened")
  @Test
  void checkRestaurantTab() {
    mapPage.clickSearchPanel();
    mapPage.clickRestaurantTab();
    String expectedResult = "Restaurant";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check drink tab is opened")
  @Test
  void checkDrinkTab() {
    mapPage.clickSearchPanel();
    mapPage.clickDrinkTab();
    String expectedResult = "Drink";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("Website dining.gifts")
  @DisplayName("Check users tab is opened")
  @Test
  void checkUsersTab() {
    mapPage.clickSearchPanel();
    mapPage.clickUsersTab();
    assert(mapPage.areUsersListOpen());
  }
}
