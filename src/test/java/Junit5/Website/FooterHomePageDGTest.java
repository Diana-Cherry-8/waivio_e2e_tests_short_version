package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FooterHomePageDGTest extends TestBase {
  static String websiteName = "";
  static String templateName = "dining.gifts";
  String objectPermlink = "mds-dining-gifts";
  String expectedObjectNameDiningGifts = "Dining.Gifts";
  String additionalPartUrlReviewsTab = "/page#dpg-tutorials/cwo-users/wdh-about";
  String additionalPartUrlFAQ = "/page#dpg-tutorials/cwo-users/dyq-faq";
  String additionalPartUrlFreeCards = "/form/diningguide-n7qpvl8bgie";
  String additionalPartUrlRestaurants = "/menu#dpg-tutorials/qsa-restaurants";
  String additionalPartUrlGuides = "/menu#dpg-tutorials/ebq-guides";
  String additionalPartUrlInfluencers = "/menu#dpg-tutorials/lgl-influencers";
  String additionalPartUrlTerms = "/page#ljc-legal/xrj-terms-and-conditions";
  String additionalPartUrlPrivacyPolicy = "/page#ljc-legal/poi-privacy-policy";
  String additionalPartUrlCookiesPolicy = "/page#ljc-legal/uid-cookies-policy";
  String discordLink = "https://discord.com/invite/Rr9zG7fH";
  String githubLink = "https://github.com/Waiviogit/waivio";
  String twitterLink = "https://twitter.com/WaivioLabs";
  String waivioLink = "https://www.waivio.com/@waiviolabs";


  @BeforeEach
  void openSite() {
    homePage = HomePage.openDiningGiftsHomePage(websiteName, templateName);
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check About open via link in footer")
  @Test
  void openAbout() {
    objectPage = homePage.clickOnLinkInFooter( 0);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlReviewsTab)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check FAQ open via link in footer")
  @Test
  void openFAQ() {
    objectPage = homePage.clickOnLinkInFooter( 1);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlFAQ)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Free cards open via link in footer")
  @Test
  void openFreeCards() {
    objectPage = homePage.clickOnLinkInFooter( 2);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlFreeCards)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Restaurants open via link in footer")
  @Test
  void openRestaurants() {
    objectPage = homePage.clickOnLinkInFooter( 3);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlRestaurants)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Guides open via link in footer")
  @Test
  void openGuides() {
    objectPage = homePage.clickOnLinkInFooter( 4);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlGuides)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Influencers open via link in footer")
  @Test
  void openInfluencers() {
    objectPage = homePage.clickOnLinkInFooter( 5);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlInfluencers)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Terms and Conditions open via link in footer")
  @Test
  void openTermsAndConditions() {
    objectPage = homePage.clickOnLinkInFooter( 6);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlTerms)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Privacy Policy open via link in footer")
  @Test
  void openPrivacyPolicy() {
    objectPage = homePage.clickOnLinkInFooter( 7);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlPrivacyPolicy)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Cookies Policy open via link in footer")
  @Test
  void openCookiesPolicy() {
    objectPage = homePage.clickOnLinkInFooter( 8);
    String actualObjectName = objectPage.getObjectName();
    assertTrue(headerDiningGifts.isLinkCorrect(templateName, objectPermlink,
        additionalPartUrlCookiesPolicy)
        && headerDiningGifts.isObjectNameCorrect(actualObjectName, expectedObjectNameDiningGifts));
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Discord open via link in footer")
  @Test
  void openDiscordLink() {
    objectPage = homePage.clickOnLinkInFooter( 9);
    String actualLink = headerDiningGifts.getLink();
    assertEquals(discordLink, actualLink);
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Github open via link in footer")
  @Test
  void openGithubLink() {
    objectPage = homePage.clickOnLinkInFooter( 10);
    String actualLink = headerDiningGifts.getLink();
    assertEquals(githubLink, actualLink);
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Twitter open via link in footer")
  @Test
  void openTwitterLink() {
    objectPage = homePage.clickOnLinkInFooter( 11);
    String actualLink = headerDiningGifts.getLink();
    assertEquals(twitterLink, actualLink);
  }

  @Story("Website dining.gifts. Home page. Footer")
  @DisplayName("Check Waivio open via link in footer")
  @Test
  void openWaivioLink() {
    objectPage = homePage.clickOnLinkInFooter( 12);
    String actualLink = headerDiningGifts.getLink();
    assertEquals(waivioLink, actualLink);
  }


  @AfterEach
  void openHomePage() {
    headerDiningGifts.clickOnLogo(websiteName, templateName);
  }

}
