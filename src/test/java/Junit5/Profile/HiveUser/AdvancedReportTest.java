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

    String username = "waiviotest2";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open advanced page")
    @DisplayName("Check that advanced page is opening")
    @Test
    void openAdvancedPage() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        assertTrue(advancedPage.isButtonSubmitExist());
    }

    @Story("Accounts validation")
    @DisplayName("Check impossibility of generating report with no user")
    @Test
    void checkReportCantBeGeneratedWithNoUser() {
        openAdvancedPage();
        advancedPage
                .fillTheFields()
                .clearFirstUser()
                .clickButtonSubmit();
        assertEquals(advancedPage.TOTAL_INFO_DEFAULT, advancedPage.getStringTotal());
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Deposits for default user")
    @Test
    void checkTotalDepositsDefaultUser() {
        openAdvancedPage();
        advancedPage
                .fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("D"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Withdrawals for default user")
    @Test
    void checkTotalWithdrawalsDegaultUser() {
        openAdvancedPage();
        advancedPage
                .fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("W"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Withdrawals for two users")
    @Test
    void checkTotalDepositsTwoUsers() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("D"))
        );
    }

    @Story("Total values counting")
    @DisplayName("Check total value of Withdrawals for two users")
    @Test
    void checkTotalWithdrawalsTwoUsers() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("W"))
        );
    }

    @AfterEach
    void returnBack() {
        Selenide.back();
    }
}
