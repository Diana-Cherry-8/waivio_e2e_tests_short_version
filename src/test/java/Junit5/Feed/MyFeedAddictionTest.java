package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.Profile.FollowingPage;
import io.qameta.allure.Feature;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Main feed")
public class MyFeedAddictionTest extends TestBase {
  private List<String> followingObjectsNameList;
  private List<String> followingUsersNameList;

  @BeforeEach
  void getData() {
    keywords.loginAs(0);
    followingPage = FollowingPage.openFollowingPage(properties.getProperty("UserName"));
    followingObjectsNameList = followingPage.getFollowingObjectsNamesList();
    followingUsersNameList = followingPage.getFollowingUsersNamesList();
    feedPage = header.clickOnLogo();
  }

  @DisplayName("Check is all post on 'My Feed' contains following object or user")
  @Test
  void myFeedAddictionTest(){
    assert(feedPage.isMyFeedFoundedOnFollowList(followingObjectsNameList, followingUsersNameList));
  }
}
