package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.Profile.FollowingPage;
import io.qameta.allure.Feature;
import java.util.List;

import org.junit.jupiter.api.*;

@Feature("Main feed")
public class MyFeedAddictionTest extends TestBase {
  private List<String> followingObjectsNameList;
  private List<String> followingUsersNameList;

  @BeforeEach
  void getData() {
    keywords.loginAs(0);
    postsPage = header.clickOnAccountIcon();
    followingPage = postsPage.clickOnFollowingProfileItem();
    followingObjectsNameList = followingPage.getFollowingObjectsNamesList();
    followingUsersNameList = followingPage.getFollowingUsersNamesList();
    feedPage = header.clickOnLogo();
  }

  @DisplayName("Check is all post on 'My Feed' contains following object or user")
  @Test
  void myFeedAddictionTest() {
    assert (feedPage.isMyFeedFoundedOnFollowList(followingObjectsNameList, followingUsersNameList));
  }
}

