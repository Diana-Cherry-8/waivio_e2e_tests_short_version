package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Create Page, Rewards")
public class CreateTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check create page is opened in Rewards")
    @Test
    void openCreateTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        createPage = rewardsLeftSidebar.clickOnCreateItem();
        String expectedResult = "Campaign name (create a duplicate)";
        String actualResult = createPage.getTitleCampaignName();
        assertEquals(expectedResult, actualResult);
    }

}