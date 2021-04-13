package Junit5.Feed;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ReviewsObjectPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ShareToTwitterTest extends TestBase {
  int index = 0;
  String twitterUsername = properties.getProperty("TwitterUsername00");
  String twitterPassword = properties.getProperty("TwitterPass00");
  static String restaurantObject = properties.getProperty("RestaurantObject");

  @DisplayName("Check that twitter opens after clicking on share to twitter via the " +
      "three dots button in feed")
  @Test
  void checkTwitterShare() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    String expectedResult = feedPage.getPostTitle(index);
    twitterPage = feedPage.clickOnTwitterInPostMenu(index);
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post modal window ")
  @Test
  void checkTwitterShareThroughModalWindow() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    String expectedResult = feedPage.getPostTitle(index);
    post = feedPage.openPost(index);
    twitterPage = post.clickTwitterIcon();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post full screen")
  @Test
  void checkTwitterShareThroughFullScreen() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnHotItem();
    String expectedResult = feedPage.getPostTitle(index);
    post = feedPage.openPost(index);
    post.clickOnPostFullScreen();
    twitterPage = post.clickOnTwitterThoughThreeDots();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @DisplayName("Check that twitter opens after clicking on share to twitter via the " +
      "three dots button in object restaurant feed")
  @Test
  void checkTwitterShareThroughFeedFromRestaurantReviewTab() {
    reviewsObjectPage = ReviewsObjectPage.openObjectPage(restaurantObject);
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    twitterPage = reviewsObjectPage.clickOnTwitterInPostMenu(index);
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post modal window, through object restaurant page")
  @Test
  void checkTwitterShareThroughModalWindowFromRestaurantReviewTab() {
    reviewsObjectPage = ReviewsObjectPage.openObjectPage(restaurantObject);
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    post = reviewsObjectPage.openPost(index);
    twitterPage = post.clickTwitterIcon();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

  @DisplayName("Check that twitter opens after clicking on share to twitter via twitter icon, " +
      "in post full screen")
  @Test
  void checkTwitterShareThroughFullScreenFromRestaurantReviewTab() {
    reviewsObjectPage = ReviewsObjectPage.openObjectPage(restaurantObject);
    String expectedResult = reviewsObjectPage.getPostTitle(index);
    post = reviewsObjectPage.openPost(index);
    post.clickOnPostFullScreenReviewTab();
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
