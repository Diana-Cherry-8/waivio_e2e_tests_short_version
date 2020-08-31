package Junit5.ModalExistPost;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ModalExistPostTest extends TestBase {
  private final int postIndex = (int) (Math.random() * 9);

  @Story("Exist Post")
  @DisplayName("Check is author page is available after click on author name on post modal")
  @Test
  void clickOnPostAuthorName() {
    feedPage = FeedPage.openFeedPage();
    post = feedPage.openPost(postIndex);
    String authorName = post.getPostAuthorName();
    profilePage = post.clickOnPostAuthorName();
    assert (profilePage.getUserNameValue().equals(authorName));
  }

  @Story("Exist Post")
  @DisplayName("Check is object page is available after click on name of related object")
  @Test
  void clickOnFirstRelatedObjectTest() {
    feedPage = FeedPage.openFeedPage();
    post = feedPage.openPost(postIndex);
    post.expandCollapseObjectRelatedList();
    String firstRelatedObjectName = post.getFirstRelatedObjectName();
    objectPage = post.clickOnRelatedObjectName(0);
    assert (objectPage.getObjectName().equals(firstRelatedObjectName));
  }
}
