package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.ObjectPage;
import com.wizardsdev.PageObjects.UserPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ExistPostTest extends TestBase {
  private final int postIndex = (int) (Math.random() * 9);

  @DisplayName("Check is author page is available after click on author name on main feed")
  @Test
  void clickOnPostAuthorTest() {
    feedPage = FeedPage.openFeedPage();
    String postAuthorName = feedPage.getPostAuthorName(postIndex);
    UserPage authorPage = feedPage.clickOnPostAuthorName(postIndex);
    assert(postAuthorName.equals(authorPage.getUserNameValue()));
  }

  @DisplayName("Check is object page is available after click on name of related object on main feed")
  @Test
  void clickOnPostRelatedObjectTest() {
    feedPage = FeedPage.openFeedPage();
    String postRelatedObjectTitle = feedPage.getPostRelatedObjectTitle(postIndex);
    ObjectPage objectPage = feedPage.clickOnPostRelatedObject(postIndex);
    assert(postRelatedObjectTitle.contains(objectPage.getObjectName()));
  }
}
