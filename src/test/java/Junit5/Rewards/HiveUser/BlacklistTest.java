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

@Feature("Blacklist Page, Rewards")
public class BlacklistTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check blacklist page is opened in Rewards")
    @Test
    void openBlacklist() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        blacklistPage = rewardsLeftSidebar.clickBlacklistItem();
        refreshPage();
        String expectedResult = "Blacklist";
        String actualResult = blacklistPage.getTitleBlacklist();
        assertTrue(actualResult.contains(expectedResult));
    }
}

