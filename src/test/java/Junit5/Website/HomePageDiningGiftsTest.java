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
    assertTrue(headerDiningGifts.isLinkCorrect(objectPermlink, additionalPartUrlReviewsTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page")
  @DisplayName("Check Partners tab")
  @Test
  void checkPartnersTab() {
    objectPage = headerDiningGifts.clickPartnersLink();
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(objectPermlink, additionalPartUrlPartnersTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @AfterEach
  void openHomePage() {
    headerDiningGifts.clickOnLogo();
  }

}
