package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.NewSitePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ShareToTwitterFromDiningGiftsTest extends TestBase {
  static String websiteName = "";
  static String templateName = properties.getProperty("TemplateNameProd");
  int index = 0;
  String twitterUsername = properties.getProperty("TwitterUsername00");
  String twitterPassword = properties.getProperty("TwitterPass00");

  @Disabled
  @BeforeEach
  void openSite() {
    newSitePage = NewSitePage.openDiningGifts(websiteName, templateName);
    newSitePage.closeCookiesWindow();
  }

  @Disabled
  @DisplayName("Check that twitter opens after clicking on share to twitter via the " +
      "three dots button in feed")
  @Test
  void checkTwitterShare() {
    objectPage = newSitePage.clickOnDesktopLogo();
    reviewsObjectPage = objectPage.clickOnReviewsItem();
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    twitterPage = reviewsObjectPage.clickOnTwitterInPostMenu(index);
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @Disabled
  @Story("Website dining.gifts")
  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post modal window, through object page")
  @Test
  void checkTwitterShareThroughModalWindowFromRestaurantReviewTab() {
    objectPage = newSitePage.clickOnDesktopLogo();
    reviewsObjectPage = objectPage.clickOnReviewsItem();
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    post = reviewsObjectPage.openPost(index);
    twitterPage = post.clickTwitterIcon();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @Disabled
  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post full screen")
  @Test
  void checkTwitterShareThroughFullScreen() {
    objectPage = newSitePage.clickOnDesktopLogo();
    reviewsObjectPage = objectPage.clickOnReviewsItem();
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    post = reviewsObjectPage.openPost(index);
    post.clickOnPostFullScreen();
    twitterPage = post.clickOnTwitterThoughThreeDots();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @AfterEach
  void deleteTwitterPost() {
    twitterPage.deleteTwitterPost();
  }
}
