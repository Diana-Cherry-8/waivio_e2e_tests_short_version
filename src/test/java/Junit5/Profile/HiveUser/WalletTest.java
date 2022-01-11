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
    String swapHive = "SWAP.HIVE";
    String swapLtc = "SWAP.LTC";
    String swapBtc = "SWAP.BTC";
    String swapEth = "SWAP.ETH";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
    }

    @Story("Open page")
    @DisplayName("Check wallet page is opened. Hive tab")
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
        walletPage.chooseCurrency(currencyWaiv);
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
        walletPage.openWaivWalletTab();
        boolean actualResult = walletPage.isCurrencyInHistoryDisplayed(currencyWaiv, currencyWaivPower, "");
        assertTrue(actualResult);
    }

    @Story("Check transfer history. HIVE")
    @DisplayName("Check transfer history. HIVE")
    @Test
    void checkTransferHistoryForHiveHiveUser() {
        walletPage.openHiveWalletTab();
        refreshPage(); //refresh page - because without it, locators began not from 0 index, but continuing waiv tab
        boolean actualResult = walletPage.isCurrencyInHistoryDisplayed(currencyHive, currencyHivePower, currencyHBD);
        assertTrue(actualResult);
    }

    @Story("Check currency in Hive Engine wallet (Swap.hive, swap.ltc, swap.btc, swap.eth")
    @DisplayName("Check currency in Hive Engine")
    @Test
    void checkDefaultCurrenciesHiveEngine() {
        walletPage.openHiveEngineWalletTab();
        boolean actualResult = walletPage.isCurrencyInHiveEngineWalletDisplayed(swapHive, swapLtc, swapBtc, swapEth); // it is our default currencies
        assertTrue(actualResult);
    }

    @AfterEach
    void returnBack() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
    }
}
