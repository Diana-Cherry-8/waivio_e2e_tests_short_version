package Junit5.GuestUser.Profile;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Profile.FollowingPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

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
        refreshPage();
        boolean actualResult = followingPage.isButtonFollowFollowingUserExist();
        assertTrue(actualResult);
    }

    @DisplayName("Check guest user following counter") //CheckFollowingFollowersCounterGuestUserTest
    @Test
    void checkFollowingCounterTest(){
        followingPage = FollowingPage.openFollowingPage(properties.getProperty("FacebookUserName00"));
        int followingCounter = followingPage.getFollowingNumberFromMenuCounter();
        int sumFollowings = followingPage.getFollowingUsersNamesList().size()
                + followingPage.getFollowingObjectsNamesList().size();
        assert( followingCounter == sumFollowings);
    }

    @DisplayName("Check user following counter") //CheckFollowingFollowersCounterTest
    @Test
    void checkFollowingCounterTestNotGuest(){
        followingPage = FollowingPage.openFollowingPage(properties.getProperty("UserLogin00"));
        int followingCounter = followingPage.getFollowingNumberFromMenuCounter();
        int sumFollowings = followingPage.getFollowingUsersNamesList().size()
                + followingPage.getFollowingObjectsNamesList().size();
        assert( followingCounter == sumFollowings);
    }

    @AfterAll
    static void logout() {
        header.logOut();
    }

}
