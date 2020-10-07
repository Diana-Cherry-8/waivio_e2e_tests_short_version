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

@Feature("Eligible Page, Rewards")
public class EligibleTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check eligible page is opened in Rewards")
    @Test
    void openEligiblePageTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        String expectedResult = "Eligible rewards";
        String actualResult = eligiblePage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}
