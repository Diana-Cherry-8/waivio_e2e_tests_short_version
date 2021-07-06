package Junit5.Profile.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Profile page")
public class WalletTest extends TestBase {
    String amountForTransfer = "0.001";
    Float amount = Float.parseFloat(amountForTransfer);
    String hiveUserName1 = "dv56d";
    String hiveUserName2 = "wiv01";
    String guestUserName = "waivio_dianach";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check wallet page is opened")
    @Test
    void openWallet() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        refreshPage();
        boolean actualResult = walletPage.isButtonsForTransferExist();
        assertTrue(actualResult);
    }

    @Story("Check transfer")
    @DisplayName("Check transfer from hive-user to hive-user")
    @Test
    void checkTransfer() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        Float expectedFloat = walletPage.getHiveAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setUserNameForWalletSearch(hiveUserName2);
        walletPage.setAmountAsHive(amountForTransfer);
        walletPage.clickContinueAsHiveUser();
        sleep(4000);
        refreshPage();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }

    @Story("Check transfer")
    @DisplayName("Check transfer from hive-user to guest-user")
    @Test
    void checkTransferFromHiveUserToGuest() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        Float expectedFloat = walletPage.getHiveAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setUserNameForWalletSearch(guestUserName);
        walletPage.setAmountAsHive(amountForTransfer);
        walletPage.clickContinueAsHiveUser();
        refreshPage();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }

    @Story("Open advanced page")
    @DisplayName("Check that advanced page is opening")
    @Test
    void openAdvancedPage() {
        openWallet();
        sleep(100);
        advancedPage = walletPage.clickOnLinkAdvancedReport();
        boolean actualResult = advancedPage.isButtonSubmitExist();
        assertTrue(actualResult);
    }
    @Story("Fill the fields")
    @DisplayName("Fill every field to receive report")
    @Test
    void fillFields() {
        openAdvancedPage();
        advancedPage.addUsers(1, 0);
        advancedPage.inputFromDate(0);
        advancedPage.inputToDate(1);
        advancedPage.dropdownCurrency(0);
            }
    @Story("Check hive user advanced report")
    @DisplayName("Check own advanced report")
    @Test
    void checkOwnAdvancedReport() {
        openAdvancedPage();
        advancedPage.inputFromDate(0);
        advancedPage.inputToDate(1);
        advancedPage.dropdownCurrency(0);
        sleep(1000);
        advancedPage.clickButtonSubmit();
        sleep(90000);
        boolean actualResult = advancedPage.isCompleted();
        assertTrue(actualResult);
    }

    @Story("Check advanced report for multiple amount of users")
    @DisplayName("Check advanced report for many users")
    @Test
    void checkAdvancedReportForManyUsers() {
        fillFields();
        advancedPage.clickButtonSubmit();
        sleep(90000);
        boolean actualResult = advancedPage.isCompletedForMultiply();
        assertTrue(actualResult);
    }

    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of deposit")
    @Test
    void CheckTotalForDeposit() {
        fillFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        sleep(1000);
        advancedPage.isCountedCorrectDeposit();
        float floatActual = advancedPage.isCountedCorrectDeposit();
        String actualResult = Float.toString(floatActual);
        String expectedResult = advancedPage.totalText();
        expectedResult.contentEquals(actualResult);
    }
    @Story("Check if TOTAL counts correct")
    @DisplayName("Check TOTAL of deposit")
    @Test
    void CheckTotalWithdrawal() {
        fillFields();
        advancedPage.clickClearButton();
        advancedPage.clickButtonSubmit();
        sleep(1000);
        advancedPage.isCountedCorrectWithdrawal();
        float floatActual = advancedPage.isCountedCorrectDeposit();
        String actualResult = Float.toString(floatActual);
        String expectedResult = advancedPage.totalText();
        expectedResult.contentEquals(actualResult);
    }
    }

