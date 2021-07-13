package Junit5.Profile.HiveUser;

import Junit5.TestBase;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

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
        Assertions.assertTrue(advancedPage.isButtonSubmitExist());
    }

    @Story("Check advanced report")
    @DisplayName("Check own advanced report")
    @Test
    void checkOwnAdvancedReport() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .enterDateOfStart()
                .enterDateOfEnd()
                .choseCurrency()
                .clickButtonSubmit();
        Assertions.assertTrue(advancedPage.waitUntilReportToBeCounted());
    }

    @Story("Check advanced report for multiple amount of users")
    @DisplayName("Check advanced report for many users")
    @Test
    void checkAdvancedReportForManyUsers() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(advancedPage.isReportCompletedForMultipleUsers(username));
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of deposit")
    @Test
    void checkTotalForDeposit() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        Assertions.assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("D"))
        );
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of Withdrawal")
    @Test
    void checkTotalWithdrawal() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        Assertions.assertTrue(
                advancedPage.totalText()
                        .contains(advancedPage.counterTotal("W"))
        );
    }

    @AfterEach
    void returnBack() {
        Selenide.back();
    }
}
