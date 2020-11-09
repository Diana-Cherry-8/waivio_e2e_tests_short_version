package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Receivables Page, Rewards")
public class ReceivablesTest extends TestBase {

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
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
        String expectedSponsorNameFull = receivablesPage.getSponsorName();
        String deleteText = "@";
        String replace = "";
        String expectedSponsorName = expectedSponsorNameFull.replaceAll(deleteText, replace);
        receivablesPage.clickButtonPaymentHistory();
        refreshPage();
        String actualSponsorName= receivablesPage.getSponsorNameInPaymentHistory();
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

