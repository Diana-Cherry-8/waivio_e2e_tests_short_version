package Junit5.Rewards.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Details Page, Rewards")
public class DetailsTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check details page is opened in Rewards")
    @Test
    void openDetails() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        detailsPage = rewardsLeftSidebar.clickOnDetailsItem();
        refreshPage();
        String expectedResult = "Referral program details:";
        String actualResult = detailsPage.getTitleDetailsRewards();
        assertEquals(expectedResult, actualResult);
    }
}
