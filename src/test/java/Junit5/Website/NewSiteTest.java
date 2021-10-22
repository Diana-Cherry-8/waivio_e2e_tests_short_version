package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.MapPage;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Website")

public class NewSiteTest extends TestBase {

  static int templateIndex = 0;
  static String websiteName = "data20543656createnewsite";
  static String templateName = "dining.gifts";

  @BeforeAll
  static void loginAndCreateSite() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    draftsPage = topNavigation.clickOnToolsItem();
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    createWebsitePage.clickOnSelectWebsiteInput();
    createWebsitePage.clickOnOptionInSelectWebsiteDropDownMenu(templateIndex);
    createWebsitePage.setWebsiteName(websiteName);
    createWebsitePage.clickOnAgreementCheckbox();
    configurationWebsitePage =
        createWebsitePage.clickOnCreateNewWebsiteButton(websiteName, templateName);
    toolsLeftSidebar.refreshIfPageWithoutLeftTabs();//sometimes it happens - bug
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    manageWebsitePage.clickCheckboxSiteActivation();
    toolsLeftSidebar.openAdditionalTabs();//sometimes it happens - bug
    areasPage = toolsLeftSidebar.clickOnAreasWebsite(templateName, websiteName);
    areasPage.clickClickChoseAreaButton();
    mapPage = MapPage.openDiningGiftsMap(websiteName, templateName);
  }

  @Story("New website")
  @DisplayName("Check button my location is exist on the map")
  @Test
  void checkButtonMyLocationIsExist() {
    assert(mapPage.isButtonMyLocationExist());
  }

  @Story("New website")
  @DisplayName("Check buttons for zoom are exist on the map")
  @Test
  void checkButtonsForZoomAreExist() {
    assert(mapPage.areButtonsForZoomExist());
  }

  @Story("New website")
  @DisplayName("Check search panel is opened")
  @Test
  void checkSearchPanelIsOpened() {
    mapPage.clickSearchPanel();
    assert(mapPage.isSearchPanelOpen());
  }

  @Story("New website")
  @DisplayName("Check dish tab is opened")
  @Test
  void checkDishTab() {
    mapPage.clickSearchPanel();
    mapPage.clickDishTab();
    String expectedResult = "Dish";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check restaurant tab is opened")
  @Test
  void checkRestaurantTab() {
    mapPage.clickSearchPanel();
    mapPage.clickRestaurantTab();
    String expectedResult = "Restaurant";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check drink tab is opened")
  @Test
  void checkDrinkTab() {
    mapPage.clickSearchPanel();
    mapPage.clickDrinkTab();
    String expectedResult = "Drink";
    String actualResult = mapPage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check users tab is opened")
  @Test
  void checkUsersTab() {
    mapPage.clickSearchPanel();
    mapPage.clickUsersTab();
    assert(mapPage.areUsersListOpen());
  }

  @AfterAll
  static void delete() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    manageWebsitePage.clickCheckboxSiteForDeactivation();
    deleteWebsite = manageWebsitePage.clickDelete();
    deleteWebsite.submitDeleteWebsite();
  }

}
