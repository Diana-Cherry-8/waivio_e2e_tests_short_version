package Junit5.Rewards;

import Junit5.TestBase;
import com.wizardsdev.Components.RewardsLeftSidebar;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Rewards.AllPage;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import com.wizardsdev.PageObjects.Rewards.ReportsPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Feature("Reports Page, Rewards")
public class ReportsTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check report page is opened in Rewards")
    @Test
    void openReportsTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        reportsPage = rewardsLeftSidebar.clickOnReportsItem();
        refresh();
        String expectedResult = "Reports :";
        String actualResult = reportsPage.getTitleReportsRewards();
        assertEquals(expectedResult, actualResult);
    }
}
