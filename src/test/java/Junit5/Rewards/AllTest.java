package Junit5.Rewards;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("All Page, Rewards. User not login")
public class AllTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        eligiblePage = topNavigation.clickOnRewardsItem();
        allPage = rewardsLeftSidebar.clickOnAllItem();
    }

    @Story("Open page")
    @DisplayName("Check all page is opened in Rewards")
    @Test
    void openAllTest() {
        String expectedResult = "All rewards";
        String actualResult = allPage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check all page has campaign cards in Rewards")
    @Test
    void checkCampaignCardsAllTab() {
        boolean actualResult = allPage.isCampaignCardPresent();
        assertTrue(actualResult);
    }
}
