package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Details Page, Rewards")
public class DetailsTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check details page is opened in Rewards")
    @Test
    void openDetails() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        detailsPage = rewardsLeftSidebar.clickOnDetailsItemAsHiveUser();
        refreshPage();
        String expectedResult = "Referral program details:";
        String actualResult = detailsPage.getTitleDetailsRewards();
        assertEquals(expectedResult, actualResult);
    }
}
