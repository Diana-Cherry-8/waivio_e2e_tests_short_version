package Junit5.Likes;

import Junit5.TestBase;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Guest user")
public class LikePostAsFBGuestUserTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  private final int postIndex = (int) (Math.random() * 9);

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword);
  }

  @Story("Likes")
  @DisplayName("Check is post like counter increment after guest user like")
  @Test
  void likePostAsFBGuestUserTest()  {
    int postLikeCountBeforeLike = feedPage.getPostLikeCount(postIndex);
    feedPage.clickOnPostLikeButton(postIndex);
    Selenide.refresh(); // нужно так как подставляется фек-данные об количесвах лайков
    int postLikeCountAfterLike = feedPage.getPostLikeCount(postIndex);
    assert(postLikeCountBeforeLike < postLikeCountAfterLike);
  }
}
