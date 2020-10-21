package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Payables Page, Rewards")
public class PayablesTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check Payables page is opened in Rewards")
    @Test
    void openPayablesTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        payablesPage = rewardsLeftSidebar.clickOnPayablesItem();
        refreshPage();
        String expectedResult = "Total: ";
        String actualResult = payablesPage.getTitlePayables();
        assertTrue(actualResult.contains(expectedResult));
    }

}
