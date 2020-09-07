package Junit5.Rewards;

import Junit5.TestBase;
import com.wizardsdev.Components.RewardsLeftSidebar;
import com.wizardsdev.Components.ToolsLeftSidebar;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Rewards.AllPage;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Feature("History Page, Rewards")
public class HistoryTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check history page is opened in Rewards")
    @Test
    void openHistory() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        historyPage = rewardsLeftSidebar.clickOnHistoryItem();
        refreshPage();
        String expectedResult = "History and sponsor communications";
        String actualResult = historyPage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}

