package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class HomePageDiningGiftsTest extends TestBase {
  static String websiteName = "";
  static String templateName = "dining.gifts";
  String objectPermlink = "mds-dining-gifts";
  String expectedObjectNameDiningGifts = "Dining.Gifts";
  String additionalPartUrlReviewsTab = "/newsFilter/dininggifts-dw09owbl6bh";
  String additionalPartUrlPartnersTab = "/page#voy-business-3-0";
  String additionalPartUrlAboutTab = "/page#wdh-about";
  String additionalPartUrlFAQTab = "/page#dyq-faq";
  String additionalPartUrlWithoutSearchPanelRestaurant = "/map?type=restaurant";
  String additionalPartUrlWithSearchPanelRestaurant =
      "/map?showPanel=true&type=restaurant&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlWithSearchPanelDish =
      "/map?showPanel=true&type=dish&center=49.2268638%2C-123.1288576&zoom=12";

  @BeforeEach
  void openSite() {
    homePage = HomePage.openDiningGiftsHomePage(websiteName, templateName);
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Reviews tab")
  @Test
  void checkReviewsTab() {
    objectPage = headerDiningGifts.clickReviewsTab();
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink, additionalPartUrlReviewsTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Partners tab")
  @Test
  void checkPartnersTab() {
    objectPage = headerDiningGifts.clickPartnersLink();
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink, additionalPartUrlPartnersTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Map open via Find rewards button")
  @Test
  void openMapViaFindRewardsButton() {
    mapPage = homePage.clickOnHomePageToOpenMap(websiteName, templateName, 1);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist());
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check About page open via Learn More button in steps block")
  @Test
  void checkAboutPageViaLearnMoreInStepsBlock() {
    objectPage = homePage.clickOnLearnMoreInStepsBlock(2);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink, additionalPartUrlAboutTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check FAQ page open via Learn More button in withdraw block")
  @Test
  void checkAboutPageViaLearnMoreInWithdrawBlock() {
    objectPage = homePage.clickOnLearnMoreInStepsBlock(3);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink, additionalPartUrlFAQTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Map open via See All Rewards button in Geographic block")
  @Test
  void openMapViaSeeAllRewardsButtonInGeographicBlock() {
    mapPage = homePage.clickOnHomePageToOpenMap(websiteName, templateName, 4);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlWithoutSearchPanelRestaurant));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Map open via See All Restaurant button in Restaurant block")
  @Test
  void openMapViaSeeAllRestaurantButtonInRestaurantBlock() {
    mapPage = homePage.clickOnHomePageToOpenMap(websiteName, templateName, 5);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlWithSearchPanelRestaurant));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Map open via See All Restaurant button in Dish block")
  @Test
  void openMapViaSeeAllNearbyButtonInDishBlock() {
    mapPage = homePage.clickOnHomePageToOpenMap(websiteName, templateName, 6);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlWithSearchPanelDish));
  }

  @AfterEach
  void openHomePage() {
    headerDiningGifts.clickOnLogo();
  }

}
