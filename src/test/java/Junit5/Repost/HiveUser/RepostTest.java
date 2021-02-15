package Junit5.Repost.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Profile page")
public class RepostTest extends TestBase {
  int postIndexInMyFeed = (int) (Math.random() * 9);
  int postIndexInPosts = 0;

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Repost")
  @DisplayName("Check comments page is opened")
  @Test
  void checkRepost() {
    String expectedPostTitle = feedPage.getPostTitle(postIndexInMyFeed);
    feedPage.clickOnReBlog(postIndexInMyFeed);
    postsPage = header.clickOnAccountIcon();
    String actualPostTitle = postsPage.getPostTitle(postIndexInPosts);
    refreshPage();
    assertEquals(expectedPostTitle, actualPostTitle);
  }

}