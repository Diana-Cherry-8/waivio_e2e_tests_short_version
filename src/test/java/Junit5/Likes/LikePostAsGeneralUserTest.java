package Junit5.Likes;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LikePostAsGeneralUserTest extends TestBase {
  private final int postIndex = (int) (Math.random() * 9);

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Likes")
  @DisplayName("Check is post like counter increment after user like")
  @Test
  void likePostAsGeneralUserTest()  {
    int postLikeCountBeforeLike = feedPage.getPostLikeCount(postIndex);
    feedPage.clickOnPostLikeButton(postIndex);
    int postLikeCountAfterLike = feedPage.getPostLikeCount(postIndex);
    assert(postLikeCountBeforeLike < postLikeCountAfterLike);
  }

}
