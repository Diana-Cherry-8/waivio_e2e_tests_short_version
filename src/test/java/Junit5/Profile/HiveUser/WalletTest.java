package Junit5.Profile.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.open;
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
    String currencyWaiv = "WAIV";
    String currencyWaivPower = "WP";
    String currencyHive = "HIVE";
    String currencyHivePower = "HP";
    String currencyHBD = "HBD";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
    }

    @Story("Open page")
    @DisplayName("Check wallet page is opened")
    @Test
    void openWallet() {
        refreshPage();
        walletPage.openHiveWalletTab();
        boolean actualResult = walletPage.isButtonsForTransferExist();
        assertTrue(actualResult);
    }

    @Story("Check transfer. HIVE")
    @DisplayName("Check transfer from hive-user to hive-user. HIVE")
    @Test
    void checkTransfer() {
        walletPage.openHiveWalletTab();
        Float expectedFloat = walletPage.getHiveAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setUserNameForWalletSearch(hiveUserName2);
        walletPage.setAmountAsHive(amountForTransfer);
        walletPage.clickContinueAsHiveUser();
        sleep(10000);
        refreshPage();
        walletPage.openHiveWalletTab();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }

    @Story("Check transfer. HIVE")
    @DisplayName("Check transfer from hive-user to guest-user. HIVE")
    @Test
    void checkTransferFromHiveUserToGuest() {
        walletPage.openHiveWalletTab();
        Float expectedFloat = walletPage.getHiveAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setUserNameForWalletSearch(guestUserName);
        walletPage.setAmountAsHive(amountForTransfer);
        walletPage.clickContinueAsHiveUser();
        sleep(10000);
        refreshPage();
        walletPage.openHiveWalletTab();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }

    @Story("Check transfer. WAIV")
    @DisplayName("Check transfer from hive-user to hive-user. WAIV")
    @Test
    void checkTransferWaivFromHiveUserToHiveUser() {
        walletPage.openWaivWalletTab();
        Float expectedFloat = walletPage.getWaivAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setUserNameForWalletSearch(hiveUserName2);
        walletPage.setAmountAsHive(amountForTransfer);
        walletPage.choseCurrency(currencyWaiv);
        walletPage.clickContinueAsHiveUser();
        sleep(10000);
        refreshPage();
        walletPage.openWaivWalletTab();
        Float actualFloat = walletPage.getWaivAmount();
        assertEquals(expectedFloat, actualFloat);
    }

    @Story("Check transfer history. WAIV")
    @DisplayName("Check transfer history. WAIV")
    @Test
    void checkTransferHistoryForWaivHiveUser() {
        String link = "https://www.waivio.com/@dia-monds/transfers?type=WAIV";
        open(link);
        walletPage.openWaivWalletTab();
        boolean actualResult = walletPage.isCurrencyInHistoryWaivDisplayed(currencyWaiv, currencyWaivPower, "");
        assertTrue(actualResult);
    }

    @Story("Check transfer history. HIVE")
    @DisplayName("Check transfer history. HIVE")
    @Test
    void checkTransferHistoryForHiveHiveUser() {
        String link = "https://www.waivio.com/@dia-monds/transfers?type=HIVE";
        open(link);
        boolean actualResult = walletPage.isCurrencyInHistoryWaivDisplayed(currencyHive, currencyHivePower, currencyHBD);
        assertTrue(actualResult);
    }

    @AfterEach
    void returnBack() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        walletPage.openHiveWalletTab();
    }
}
