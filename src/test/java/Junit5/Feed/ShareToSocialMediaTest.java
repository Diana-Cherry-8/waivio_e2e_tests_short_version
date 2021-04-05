package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ShareToSocialMediaTest extends TestBase {
  int index = 0;
  String login = "jasecarmel@gmail.com";
  String password = "qweqwe123QWE";
  boolean newWindow = false;

  @DisplayName("Check that twitter opens after clicking on share to twitter via the three dots button")
  @Test
  void checkTwitterOpen() {
    feedPage = FeedPage.openFeedPage();
    twitterPage = feedPage.clickOnTwitterInPostMenu(index);
    assert(twitterPage.isEmailFieldExist());
  }

  @DisplayName("Check that facebook opens in editor with post")
  @Test
  void checkFaceebookOpen() {
    feedPage = FeedPage.openFeedPage();
    facebookSignPage = feedPage.clickOnFacebookInPostMenu(index, newWindow);
    facebookSignPage.setLogin(login);
    facebookSignPage.setPassword(password);
    facebookSignPage.clickOnLogIn();
    assert(facebookSignPage.isPostExistInFacebookEditor());
  }
}
