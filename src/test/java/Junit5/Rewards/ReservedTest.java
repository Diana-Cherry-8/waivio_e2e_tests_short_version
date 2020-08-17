package Junit5.Rewards;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Rewards.AllPage;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@Feature("RewardsPage, eligible page")
public class ReservedTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check reserved page is opened in Rewards")
    @Test
    void openReservedTest() {
        eligiblePage = EligiblePage.openEligiblePage();
        reservedPage = eligiblePage.clickReservedPage();
        String expectedResult = "Reserved rewards";
        String actualResult = reservedPage.getTitleRewards();

        assertEquals(expectedResult, actualResult);
    }
}
