package Junit5.Feed;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.Facebook.FacebookEditorPage;
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
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    assert(facebookEditorPage.isPostExistInFacebookEditor());
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
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    assert(facebookEditorPage.isPostExistInFacebookEditor());
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
    facebookSignPage.loginWithFacebook(login, password);
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    assert(facebookEditorPage.isPostExistInFacebookEditor());
  }

  @DisplayName("Check facebook title in post preview via feed")
  @Test
  void checkPostPreviewFacebook() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    String waivioTitle = feedPage.getPostTitle(index);
    facebookSignPage = feedPage.clickOnFacebookInPostMenu(index, newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    facebookProfilePage = facebookEditorPage.clickPublishFacebook();
    facebookProfilePage.clickUserTabInHeader();
    String facebookTitle = facebookProfilePage.getTitleForPostFacebook();
    System.out.println("Waivio title: " + waivioTitle);
    System.out.println("Facebook title: " + facebookTitle);
    assertTrue(facebookTitle.contains(waivioTitle));
  }

  @DisplayName("Check facebook title in post preview via modal window")
  @Test
  void checkPostPreviewFacebookViaPostModalWindow() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    String waivioTitle = feedPage.getPostTitle(index);
    post = feedPage.openPost(index);
    facebookSignPage = post.clickFacebookIcon(newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    facebookProfilePage = facebookEditorPage.clickPublishFacebook();
    facebookProfilePage.clickUserTabInHeader();
    String facebookTitle = facebookProfilePage.getTitleForPostFacebook();
    System.out.println("Waivio title: " + waivioTitle);
    System.out.println("Facebook title: " + facebookTitle);
    assertTrue(facebookTitle.contains(waivioTitle));
  }

  @DisplayName("Check facebook title in post preview via full screen")
  @Test
  void checkPostPreviewFacebookViaFullScreen() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    String waivioTitle = feedPage.getPostTitle(index);
    post = feedPage.openPost(index);
    post.clickOnPostFullScreen();
    facebookSignPage = post.clickOnFacebookThoughThreeDots(newWindow);
    facebookSignPage.loginWithFacebook(login, password);
    facebookEditorPage = FacebookEditorPage.openFacebookEditorPage();
    facebookProfilePage = facebookEditorPage.clickPublishFacebook();
    facebookProfilePage.clickUserTabInHeader();
    String facebookTitle = facebookProfilePage.getTitleForPostFacebook();
    System.out.println("Waivio title: " + waivioTitle);
    System.out.println("Facebook title: " + facebookTitle);
    assertTrue(facebookTitle.contains(waivioTitle));
  }
}
