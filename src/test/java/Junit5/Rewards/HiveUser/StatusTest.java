package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Status Page, Rewards")
public class StatusTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check status page is opened in Rewards")
    @Test
    void openStatus() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        statusPage = rewardsLeftSidebar.clickOnStatusItemAsHiveUser();
        refreshPage();
        String expectedResult = "Referral status:";
        String actualResult = statusPage.getTitleStatusRewards();
        assertEquals(expectedResult, actualResult);
    }
}