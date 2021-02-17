package Junit5.Feed;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class CommentsAreRevealedTest extends TestBase {
  int postIndex = (int) (Math.random() * 9);

  @BeforeAll
  static void openPage () {
    feedPage = FeedPage.openFeedPage();
  }

  @DisplayName("Check that comments are disclosed on 'Trending' feed")
  @Test
  void expandCommentsOnTrendingFeed() {
    feedLeftBar.clickOnTrendingItem();
    feedPage.clickOnCommentButton(postIndex);
    assertTrue(feedPage.isCommentExist());
  }

  @DisplayName("Check that comments are disclosed on 'Hot' feed")
  @Test
  void expandCommentsOnHotFeed() {
    feedLeftBar.clickOnHotItem();
    feedPage.clickOnCommentButton(postIndex);
    assertTrue(feedPage.isCommentExist());
  }
}
