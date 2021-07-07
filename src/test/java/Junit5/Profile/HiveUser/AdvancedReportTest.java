package Junit5.Profile.HiveUser;
import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Profile page")
public class AdvancedReportTest extends TestBase {
   String username = "waiviotest2";
    @BeforeEach
    void login() {
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
        boolean actualResult = advancedPage.isButtonSubmitExist();
        assertTrue(actualResult);
    }

    @Story(" Check advanced report")
    @DisplayName("Check own advanced report")
    @Test
    void checkOwnAdvancedReport() {
        openAdvancedPage();
        advancedPage
                .addUsers(username)
                .enterDateOfStart()
                .enterDateOfEnd()
                .choseCurrency()
                .clickButtonSubmit()
                .waitUntilReportToBeCounted();
        assertTrue(advancedPage.waitUntilReportToBeCounted());
    }

    @Story("Check advanced report for multiple amount of users")
    @DisplayName("Check advanced report for many users")
    @Test
    void checkAdvancedReportForManyUsers() {
        openAdvancedPage();
        advancedPage.addUsers(username);
        advancedPage.fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        assertTrue(advancedPage.isReportCompletedForMultipleUsers(username));
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of deposit")
    @Test
    void CheckTotalForDeposit() {
        openAdvancedPage();
        advancedPage.addUsers(username);
        advancedPage.fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.CountTotalDeposit();
        float floatActual = advancedPage.CountTotalDeposit();
        String actualResult = Float.toString(floatActual);
        advancedPage.totalText().contentEquals(actualResult);
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of Withdrawal")
    @Test
    void checkTotalWithdrawal() {
        openAdvancedPage();
        advancedPage.addUsers(username)
        .fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        advancedPage.countTotalWithdrawal();
        float floatActual = advancedPage.CountTotalDeposit();
        advancedPage.totalText().contentEquals(Float.toString(floatActual));
    }

    @AfterEach
    void logOut() {
        header.logOut();
    }
}
