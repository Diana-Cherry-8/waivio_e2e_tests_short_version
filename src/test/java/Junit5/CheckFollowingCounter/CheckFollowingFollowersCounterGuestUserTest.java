package Junit5.CheckFollowingCounter;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.UserPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Guest user")
@Story("User page")
public class CheckFollowingFollowersCounterGuestUserTest extends TestBase {

  @BeforeEach
  void getData(){
    userPage = UserPage.openUserPage(properties.getProperty("FacebookUserName00"));
  }

  @DisplayName("Check guest user following counter")
  @Test
  void checkFollowingCounterTest(){
    int followingCounter = userPage.getFollowingNumberFromMenuCounter();
    int sumFollowings = userPage.getFollowingUsersNamesList().size()
        + userPage.getFollowingObjectsNamesList().size();
    assert( followingCounter == sumFollowings);
  }

  @DisplayName("Check guest user followers counter")
  @Test
  void checkFollowersCounterTest() {
    int followersCounter = userPage.getFollowersNumberFromMenuCounter();
    int followersListSize = userPage.getFollowerNamesList().size();
    assert(followersCounter == followersListSize);
  }
}
