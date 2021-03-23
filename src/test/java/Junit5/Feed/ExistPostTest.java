package Junit5.Feed;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class ExistPostTest extends TestBase {
  private final int postIndex = (int) (Math.random() * 9);

  @DisplayName("Check is author page is available after click on author name on main feed")
  @Test
  void clickOnPostAuthorTest() {
    feedPage = FeedPage.openFeedPage();
    String expectedAuthorName = feedPage.getPostAuthorName(postIndex);
    ProfilePage profilePage = feedPage.clickOnPostAuthorName(postIndex);
    String actualAuthorName = profilePage.getUserNameValue();
    assertEquals(expectedAuthorName, actualAuthorName);
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
