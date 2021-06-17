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
}
