package Junit5.Profile.HiveUser;

import Junit5.TestBase;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Profile page")
public class AdvancedReportTest extends TestBase {

    String username = "wiv01";
    String startDate = "08/01/2021";
    // you can enter date or "Account Creation"
    String endDate = "Today";
    // you can enter date or "Today"
    String currency = "USD";
    String totalDataDefaultState = "TOTAL: Deposits: -. Withdrawals: -. (Totals can be calculated only for a defined from-till period.)";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
    }

    @Story("Open advanced page")
    @DisplayName("Check that advanced page is opening")
    @Test
    void openAdvancedPage() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        assertTrue(advancedPage.isButtonSubmitExist());
    }

    @Story("Accounts validation")
    @DisplayName("Check impossibility of generating report with no user")
    @Test
    void checkReportCantBeGeneratedWithNoUser() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        advancedPage.fillTheFields(startDate, endDate, currency);
        advancedPage.clearFirstUser();
        advancedPage.clickButtonSubmit();
        assertEquals(totalDataDefaultState,
                advancedPage.getStringTotalData());
    }

    @Story("Show more option")
    @DisplayName("Check the appearing of Show more button")
    @Test
    void checkAppearingShowMoreButton() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        assertTrue(advancedPage.isShowMoreButtonExists());
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Deposits for default user")
    @Test
    void checkTotalDepositsDefaultUser() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        advancedPage.fillTheFields(startDate, endDate, currency);
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.getCountedTotal()
                        .contains(advancedPage.getCounterTotal("D"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Withdrawals for default user")
    @Test
    void checkTotalWithdrawalsDefaultUser() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        advancedPage.fillTheFields(startDate, endDate, currency);
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.getCountedTotal()
                        .contains(advancedPage.getCounterTotal("W"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Deposits for two users")
    @Test
    void checkTotalDepositsTwoUsers() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        advancedPage.addUsers(username);
        advancedPage.fillTheFields(startDate, endDate, currency);
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.getCountedTotal()
                        .contains(advancedPage.getCounterTotal("D"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Withdrawals for two users")
    @Test
    void checkTotalWithdrawalsTwoUsers() {
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        advancedPage.addUsers(username);
        advancedPage.fillTheFields(startDate, endDate, currency);
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.getCountedTotal()
                        .contains(advancedPage.getCounterTotal("W"))
        );
    }

    @AfterEach
    void returnBack() {
        Selenide.back();
    }
}
