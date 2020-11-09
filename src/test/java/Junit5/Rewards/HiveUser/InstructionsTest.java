package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Instructions Page, Rewards")
public class InstructionsTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check instructions page is opened in Rewards")
    @Test
    void openInstructions() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        instructionsPage = rewardsLeftSidebar.clickOnInstructionsItemAsHiveUser();
        refreshPage();
        String expectedResult = "Referral instructions:";
        String actualResult = instructionsPage.getTitleInstructionsRewards();
        assertEquals(expectedResult, actualResult);
    }
}