package Junit5.HiveUser.Rewards;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("All Page, Rewards")
public class AllTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check all page is opened in Rewards")
    @Test
    void openAllTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        allPage = rewardsLeftSidebar.clickOnAllItem();
        String expectedResult = "All rewards";
        String actualResult = allPage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}
