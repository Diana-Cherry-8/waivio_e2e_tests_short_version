package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Fraud detection Page, Rewards")
public class FraudDetectionTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check fraud detection page is opened in Rewards")
    @Test
    void openFraudDetection() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        fraudDetectionPage = rewardsLeftSidebar.clickOnFraudDetectionItem();
        refreshPage();
        String expectedResult = "Fraud detection assistant";
        String actualResult = fraudDetectionPage.getTitleFraudDetectionRewards();
        assertEquals(expectedResult, actualResult);
    }
}
