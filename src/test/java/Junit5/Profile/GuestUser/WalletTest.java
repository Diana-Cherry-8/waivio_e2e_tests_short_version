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

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
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
        String amountForTransfer = "0.001";
        postsPage = header.clickOnAccountIcon();
        walletPage = postsPage.clickOnWalletProfileItem();
        String expectedString = walletPage.getHiveAmount();
        String deleteText = " HIVE";
        String replace = "";
        String deleteHive = expectedString.replaceAll(deleteText, replace);
        double expectedDouble = Double.parseDouble(deleteHive) - 0.001;
        walletPage.clickOnTransferButton();
        walletPage.setAmount(amountForTransfer);
        walletPage.clickContinueAsGuest();
        refreshPage();
        sleep(10000);
        refreshPage();
        String actualString = walletPage.getHiveAmount();
        String deleteHiveForActual = actualString.replaceAll(deleteText, replace);
        double actualDouble = Double.parseDouble(deleteHiveForActual);
        assertEquals(expectedDouble, actualDouble);
    }
}

