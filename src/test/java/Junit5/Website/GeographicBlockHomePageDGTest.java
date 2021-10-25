package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GeographicBlockHomePageDGTest extends TestBase {
  static String websiteName = "";
  static String templateName = "dining.gifts";

  String additionalPartUrlLocationVancouver =
      "/map?center=49.25997734756513%2C-123.16840544074762&zoom=13&showPanel=true&type=restaurant";
  String additionalPartUrlLocationWestVancouver =
      "/map?center=49.33061827957905%2C-123.18634405463922&zoom=14&showPanel=true&type=restaurant";
  String additionalPartUrlLocationNorthVancouver =
      "/map?center=49.31637722345304%2C-123.0999432123893&zoom=14&showPanel=true&type=restaurant";
  String additionalPartUrlLocationRichmond =
      "/map?center=49.15654895003815%2C-123.18692234433014&zoom=13&showPanel=true&type=restaurant";
  String additionalPartUrlLocationCoquitlam =
      "/map?center=49.27851295365915%2C-122.83756272769995&zoom=13&showPanel=true&type=restaurant";
  String additionalPartUrlLocationBurnaby =
      "/map?center=49.26696%2C-123.00594&zoom=12.211063673604194&showPanel=true&type=restaurant";


  @BeforeEach
  void openSite() {
    homePage = HomePage.openDiningGiftsHomePage(websiteName, templateName);
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the Vancouver link Geographic block")
  @Test
  void openMapViaVancouverLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 0);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationVancouver));
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the West Vancouver link Geographic block")
  @Test
  void openMapViaWestVancouverLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 1);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationWestVancouver));
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the North Vancouver link Geographic block")
  @Test
  void openMapViaNorthVancouverLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 2);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationNorthVancouver));
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the Richmond link Geographic block")
  @Test
  void openMapViaRichmondLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 3);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationRichmond));
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the Coquitlam link Geographic block")
  @Test
  void openMapViaCoquitlamLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 4);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationCoquitlam));
  }

  @Story("Website dining.gifts. Home page. Geographic")
  @DisplayName("Check Map open via click on the Burnaby link Geographic block")
  @Test
  void openMapViaBurnabyLinkInGeographicBlock() {
    mapPage = homePage.clickOnCityLinkOnGeographicBlock(websiteName, templateName, 5);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlLocationBurnaby));
  }


  @AfterEach
  void openHomePage() {
    headerDiningGifts.clickOnLogo();
  }

}

