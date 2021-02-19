package Junit5.ReBlog.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Profile page")
public class ReBlogTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  int postIndexInMyFeed = (int) (Math.random() * 9);
  int postIndexInPosts = 0;

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword);
    feedLeftBar.clickOnNewItem();
  }

  @Story("Re-blog")
  @DisplayName("Check re-blog")
  @Test
  void checkReBlog() {
    String expectedPostTitle = feedPage.getPostTitle(postIndexInMyFeed);
    reBlog = feedPage.clickOnReBlog(postIndexInMyFeed);
    reBlog.submitAction();
    postsPage = header.clickOnAccountIcon();
    refreshPage();
    String actualPostTitle = postsPage.getPostTitle(postIndexInPosts);
    assertEquals(expectedPostTitle, actualPostTitle);
  }

}