package Junit5.Rewards.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Receivables Page, Rewards")
public class ReceivablesTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check receivables page is opened in Rewards")
    @Test
    void openReceivablesTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        receivablesPage = rewardsLeftSidebar.clickOnReceivablesItem();
        refreshPage();
        String expectedResult = "Total: ";
        String actualResult = receivablesPage.getTitleReceivables();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check payment history page is opened in Receivables")
    @Test
    void openPaymentHistoryPage() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        receivablesPage = rewardsLeftSidebar.clickOnReceivablesItem();
        String expectedSponsorName = receivablesPage.getSponsorNameInReceivables();
        receivablesPage.clickButtonPaymentHistory();
        refreshPage();
        String actualSponsorName = receivablesPage.getSponsorNameInPaymentHistory();
        assertEquals(expectedSponsorName, actualSponsorName);
    }

    @Story("Open page")
    @DisplayName("Check report modal window is opened in Receivables")
    @Test
    void openReportModalWindow() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        receivablesPage = rewardsLeftSidebar.clickOnReceivablesItem();
        receivablesPage.clickButtonPaymentHistory();
        receivablesPage.clickOnReportLink();
        String expectedResult = "Report";
        String actualResult = receivablesPage.getTitleReport();
        assertEquals(expectedResult, actualResult);
    }
}

