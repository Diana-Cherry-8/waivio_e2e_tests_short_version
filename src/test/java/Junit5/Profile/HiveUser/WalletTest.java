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
    String hiveUserName = "x6oc5";

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
        walletPage.setHiveUserName(hiveUserName);
        walletPage.setAmount(amountForTransfer);
        walletPage.clickContinueAsHiveUser();
        refreshPage();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }
}
