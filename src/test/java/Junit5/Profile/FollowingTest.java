package Junit5.Profile;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import com.wizardsdev.PageObjects.UserPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FollowingTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @Story("Open page")
    @DisplayName("Check following page is opened")
    @Test
    void openFollowing() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        postsPage = header.clickOnAccountIcon();
        followingPage = postsPage.clickOnFollowingProfileItem();
        refresh();
        boolean actualResult = followingPage.isButtonFollowFollowingUserExist();
        assertTrue(actualResult);
    }

    @DisplayName("Check guest user following counter") //CheckFollowingFollowersCounterGuestUserTest
    @Test
    void checkFollowingCounterTest(){
        profilePage = ProfilePage.openProfilePage(properties.getProperty("FacebookUserName00"));
        int followingCounter = profilePage.getFollowingNumberFromMenuCounter();
        int sumFollowings = profilePage.getFollowingUsersNamesList().size()
                + profilePage.getFollowingObjectsNamesList().size();
        assert( followingCounter == sumFollowings);
    }

    @DisplayName("Check guest user followers counter") //CheckFollowingFollowersCounterGuestUserTest
    @Test
    void checkFollowersCounterTest() {
        profilePage = ProfilePage.openProfilePage(properties.getProperty("FacebookUserName00"));
        int followersCounter = profilePage.getFollowersNumberFromMenuCounter();
        int followersListSize = profilePage.getFollowerNamesList().size();
        assert(followersCounter == followersListSize);
    }

    @DisplayName("Check user following counter") //CheckFollowingFollowersCounterTest
    @Test
    void checkFollowingCounterTestNotGuest(){
        profilePage = ProfilePage.openProfilePage(properties.getProperty("UserLogin00"));
        int followingCounter = profilePage.getFollowingNumberFromMenuCounter();
        int sumFollowings = profilePage.getFollowingUsersNamesList().size()
                + profilePage.getFollowingObjectsNamesList().size();
        assert( followingCounter == sumFollowings);
    }

    @DisplayName("Check user following counter") //CheckFollowingFollowersCounterTest
    @Test
    void checkFollowersCounterTestNotGuest() {
        profilePage = ProfilePage.openProfilePage(properties.getProperty("UserLogin00"));
        int followersCounter = profilePage.getFollowersNumberFromMenuCounter();
        int followersListSize = profilePage.getFollowerNamesList().size();
        assert(followersCounter == followersListSize);
    }


}
