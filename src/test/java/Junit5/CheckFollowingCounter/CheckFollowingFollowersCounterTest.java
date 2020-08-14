package Junit5.CheckFollowingCounter;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.UserPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Story("User page")
public class CheckFollowingFollowersCounterTest extends TestBase {

  @BeforeEach
  void getData(){
    userPage = UserPage.openUserPage(properties.getProperty("UserLogin00"));
  }

  @DisplayName("Check user following counter")
  @Test
  void checkFollowingCounterTest(){
    int followingCounter = userPage.getFollowingNumberFromMenuCounter();
    int sumFollowings = userPage.getFollowingUsersNamesList().size()
        + userPage.getFollowingObjectsNamesList().size();
    assert( followingCounter == sumFollowings);
  }

  @DisplayName("Check user followers counter")
  @Test
  void checkFollowersCounterTest() {
    int followersCounter = userPage.getFollowersNumberFromMenuCounter();
    int followersListSize = userPage.getFollowerNamesList().size();
    assert(followersCounter == followersListSize);
  }
}
