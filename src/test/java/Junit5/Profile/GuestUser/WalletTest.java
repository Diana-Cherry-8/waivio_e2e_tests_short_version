package Junit5.Profile.GuestUser;

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
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    String amountForTransfer = "0.001";
    Float amount = Float.parseFloat(amountForTransfer);
    String sponsorName = properties.getProperty("HiveAccountName");
    static boolean newWindow = true;

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
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
    @DisplayName("Check transfer from guest to hive-user")
    @Test
    void checkTransfer() {
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        Float expectedFloat = walletPage.getHiveAmount() - amount;
        expectedFloat = (float) (Math.round(expectedFloat * 1000.0) / 1000.0);
        walletPage.clickOnTransferButton();
        walletPage.setAmountAsGuest(amountForTransfer, sponsorName);
        walletPage.clickContinueAsGuest();
        sleep(4000);
        refreshPage();
        Float actualFloat = walletPage.getHiveAmount();
        assertEquals(expectedFloat, actualFloat);
    }
}

