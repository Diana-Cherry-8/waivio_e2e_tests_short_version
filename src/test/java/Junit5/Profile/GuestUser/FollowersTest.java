package Junit5.Profile.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Profile.FollowersPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Profile page")
public class FollowersTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @Story("Open page")
    @DisplayName("Check followers page is opened")
    @Test
    void openFollowers() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        postsPage = header.clickOnAccountIcon();
        followersPage = postsPage.clickOnFollowersProfileItem();
        refreshPage();
        boolean actualResult = followersPage.isButtonFollowFollowersUserExist();
        assertTrue(actualResult);
    }

    @DisplayName("Check guest user followers counter") //CheckFollowingFollowersCounterGuestUserTest
    @Test
    void checkFollowersCounterTest() {
        followersPage = FollowersPage.openFollowersPage(properties.getProperty("FacebookUserName00"));
        int followersCounter = followersPage.getFollowersNumberFromMenuCounter();
        int followersListSize = followersPage.getFollowerNamesList().size();
        assertEquals(followersCounter, followersListSize);
    }

    @DisplayName("Check user follower counter") //CheckFollowingFollowersCounterTest
    @Test
    void checkFollowersCounterTestNotGuest() {
        followersPage = FollowersPage.openFollowersPage(properties.getProperty("UserLogin00"));
        int followersCounter = followersPage.getFollowersNumberFromMenuCounter();
        int followersListSize = followersPage.getFollowerNamesList().size();
        assert(followersCounter == followersListSize);
    }

}
