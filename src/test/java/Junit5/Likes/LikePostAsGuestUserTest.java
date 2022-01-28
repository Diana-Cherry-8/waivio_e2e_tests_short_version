package Junit5.Likes;

import static org.junit.jupiter.api.Assertions.assertTrue;

import Junit5.TestBase;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Feature("Guest user")
public class LikePostAsGuestUserTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  //private final int postIndex = (int) (Math.random() * 9);
  int postIndex = 0;

  static boolean newWindow = true;
  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    feedLeftBar.clickOnHotItem();
  }

  @Story("Likes")
  @DisplayName("Check is post like counter increment after guest user like")
  @Test
  void likePostAsFBGuestUserTest()  {
    int postLikeCountBeforeLike = feedPage.getPostLikeCount(postIndex);
    feedPage.clickOnPostLikeButton(postIndex);
    //refreshPage();// нужно так как подставляется фек-данные об количесвах лайков
    int postLikeCountAfterLike = feedPage.getPostLikeCount(postIndex);
    assertTrue(postLikeCountBeforeLike < postLikeCountAfterLike);
  }

}
