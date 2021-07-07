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
        advancedPage.enterDateOfStart();
        advancedPage.enterDateOfEnd();
        advancedPage.choseCurrency();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        boolean actualResult = advancedPage.waitUntilReportToBeCounted();
        assertTrue(actualResult);
    }

    @Story("Check advanced report for multiple amount of users")
    @DisplayName("Check advanced report for many users")
    @Test
    void checkAdvancedReportForManyUsers() {
        openAdvancedPage();
        advancedPage.fillTheFields();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        boolean actualResult = advancedPage.isReportCompletedForMultipleUsers();
        assertTrue(actualResult);
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of deposit")
    @Test
    void CheckTotalForDeposit() {
        openAdvancedPage();
        advancedPage.fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.countTotalDeposit();
        float floatActual = advancedPage.countTotalDeposit();
        String actualResult = Float.toString(floatActual);
        String expectedResult = advancedPage.totalText();
        expectedResult.contentEquals(actualResult);
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of Withdrawal")
    @Test
    void CheckTotalWithdrawal() {
        openAdvancedPage();
        advancedPage.fillTheFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        advancedPage.waitUntilReportToBeCounted();
        advancedPage.countTotalWithdrawal();
        float floatActual = advancedPage.countTotalDeposit();
        String actualResult = Float.toString(floatActual);
        String expectedResult = advancedPage.totalText();
        expectedResult.contentEquals(actualResult);
    }

    @AfterEach
    void logOut() {
        header.logOut();
    }
}
