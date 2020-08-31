package Junit5.Feed;

import Junit5.TestBase;
import com.wizardsdev.Keywords;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.UserPage;
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
    profilePage = header.clickOnAccountIcon();
    followingObjectsNameList = profilePage.getFollowingObjectsNamesList(); // не правильно исправить
    followingUsersNameList = profilePage.getFollowingUsersNamesList(); //не правильно исправить вместо юзер профайл
    feedPage = header.clickOnLogo();
  }

  @DisplayName("Check is all post on 'My Feed' contains following object or user")
  @Test
  void myFeedAddictionTest(){
    assert(feedPage.isMyFeedFoundedOnFollowList(followingObjectsNameList, followingUsersNameList));
  }
}
