package Junit5.Profile.HiveUser;

import Junit5.TestBase;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AdvancedReportTest extends TestBase {


    @Story("Open advanced page")
    @DisplayName("Check that advanced page is opening")
    @Test
    void openAdvancedPage() {

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
        advancedPage.clickButtonSubmit();
        sleep(80000);
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
        //sleep(1000);
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
