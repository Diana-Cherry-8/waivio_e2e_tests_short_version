package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Match Bot Page, Rewards")
public class MatchBotTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check receivables page is opened in Rewards")
    @Test
    void openMatchBot() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        matchBotPage = rewardsLeftSidebar.clickOnMatchBotItem();
        refreshPage();
        String expectedResult = "Manage match bot";
        String actualResult = matchBotPage.getTitleMatchBot();
        assertTrue(actualResult.contains(expectedResult));
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}
