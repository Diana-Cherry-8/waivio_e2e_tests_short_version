package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.NewSitePage;
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
  static String templateName = properties.getProperty("TemplateNameProd");
  static String hiveUserEmail = properties.getProperty("UserLogin03");
  static String hivePasswordPassword = properties.getProperty("LoginPassword03");

  @BeforeAll
  static void createAndOpenSite() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(hiveUserEmail, hivePasswordPassword);
    draftsPage = topNavigation.clickOnToolsItem();
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    createWebsitePage.clickOnSelectWebsiteInput();
    createWebsitePage.clickOnOptionInSelectWebsiteDropDownMenu(templateIndex);
    createWebsitePage.setWebsiteName(websiteName);
    createWebsitePage.clickOnAgreementCheckbox();
    configurationWebsitePage =
        createWebsitePage.clickOnCreateNewWebsiteButton(websiteName, templateName);
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    manageWebsitePage.clickCheckboxSiteActivation();
    areasPage = toolsLeftSidebar.clickOnAreasWebsite(templateName, websiteName);
    areasPage.clickClickChoseAreaButton();
    newSitePage = NewSitePage.openNewSitePage(websiteName, templateName);
    NewSitePage.closeCookiesWindow();
  }

  @Story("New website")
  @DisplayName("Check button my location is exist on the map")
  @Test
  void checkButtonMyLocationIsExist() {
    assert(newSitePage.isButtonMyLocationExist());
  }

  @Story("New website")
  @DisplayName("Check buttons for zoom are exist on the map")
  @Test
  void checkButtonsForZoomAreExist() {
    assert(newSitePage.areButtonsForZoomExist());
  }

  @Story("New website")
  @DisplayName("Check search panel is opened")
  @Test
  void checkSearchPanelIsOpened() {
    newSitePage.clickSearchPanel();
    assert(newSitePage.isSearchPanelOpen());
  }

  @Story("New website")
  @DisplayName("Check dish tab is opened")
  @Test
  void checkDishTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickDishTab();
    String expectedResult = "Dish";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check restaurant tab is opened")
  @Test
  void checkRestaurantTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickRestaurantTab();
    String expectedResult = "Restaurant";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check drink tab is opened")
  @Test
  void checkDrinkTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickDrinkTab();
    String expectedResult = "Drink";
    String actualResult = newSitePage.getTagName();
    assertTrue(actualResult.contains(expectedResult));
  }

  @Story("New website")
  @DisplayName("Check users tab is opened")
  @Test
  void checkUsersTab() {
    newSitePage.clickSearchPanel();
    newSitePage.clickUsersTab();
    assert(newSitePage.areUsersListOpen());
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