package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ShareToFacebookTest extends TestBase {
  int index = 0;
  String login = properties.getProperty("FacebookUserEmail00");
  String password = properties.getProperty("FacebookUserPass00");
  boolean newWindow = false;

  @DisplayName("Check that facebook opens in editor with post")
  @Test
  void checkFacebookOpen() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    facebookSignPage = feedPage.clickOnFacebookInPostMenu(index, newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    assert(facebookSignPage.isPostExistInFacebookEditor());
  }

  @DisplayName("Check that facebook opens after clicking on share to facebook via facebook icon, " +
      "in post modal window ")
  @Test
  void checkFacebookOpenThroughModalWindow() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnHotItem();
    post = feedPage.openPost(index);
    facebookSignPage = post.clickFacebookIcon(newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    assert(facebookSignPage.isPostExistInFacebookEditor());
  }

  @DisplayName("Check that facebook opens after clicking on share to facebook via facebook icon, " +
      "in post full screen")
  @Test
  void checkFacebookOpenThroughFullScreen() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnTrendingItem();
    post = feedPage.openPost(index);
    post.clickOnPostFullScreen();
    facebookSignPage = post.clickOnFacebookThoughThreeDots(newWindow);
    assert(facebookSignPage.isPostExistInFacebookEditor());
  }

  @DisplayName("Check that facebook opens in editor with post")
  @Test
  void checkPostPreviewFacebook() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    facebookSignPage = feedPage.clickOnFacebookInPostMenu(index, newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    facebookSignPage.clickPublishFacebook();
    facebookSignPage.clickUSerTabInHeader();
    assert(facebookSignPage.isPostExistInFacebookEditor());
  }
}
