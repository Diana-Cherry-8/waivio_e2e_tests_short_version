package Junit5.Feed;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ShareToTwitterTest extends TestBase {
  int index = 0;
  String twitterUsername = properties.getProperty("TwitterUsername00");
  String twitterPassword = properties.getProperty("TwitterPass00");

  @DisplayName("Check that twitter opens after clicking on share to twitter via the " +
      "three dots button in feed")
  @Test
  void checkTwitterOpen() {
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
  void checkTwitterOpenThroughModalWindow() {
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
  void checkTwitterOpenThroughFullScreen() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnHotItem();
    post = feedPage.openPost(index);
    String expectedResult = feedPage.getPostTitle(index);
    post.clickOnPostFullScreen();
    twitterPage = post.clickOnTwitterThoughThreeDots();
    twitterPage.twitterLogin(twitterUsername, twitterPassword);
    twitterPage.publishInTwitter();
    String actualResult = twitterPage.getTitle();
    assertTrue((actualResult).contains(expectedResult));
  }

}
