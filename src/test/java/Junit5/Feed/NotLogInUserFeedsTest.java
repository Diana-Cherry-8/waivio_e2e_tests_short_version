package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class NotLogInUserFeedsTest extends TestBase {

  @DisplayName("Check is order of post is correct on 'Trending' feed")
  @Test
  void trendingFeedOrderTest() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnTrendingItem();
    assert(feedPage.isTrendingFeedPostsOrderCorrect());
  }

  @DisplayName("Check is order of post is correct on 'New' feed")
  @Test
  void newFeedOrderTest() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnNewItem();
    assert(feedPage.isNewFeedPostsOrderCorrect());
  }

  @DisplayName("Check is order of post is correct on 'Hot' feed")
  @Test
  void hotFeedOrderTest() {
    feedPage = FeedPage.openFeedPage();
    feedLeftBar.clickOnHotItem();
    assert(feedPage.isHotFeedPostsOrderCorrect());
  }
}
