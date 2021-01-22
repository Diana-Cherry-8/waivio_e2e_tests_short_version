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

@Feature("Receivables Page, Rewards")
public class ReceivablesTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check receivables page is opened in Rewards")
    @Test
    void openReceivablesTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        receivablesPage = rewardsLeftSidebar.clickOnReceivablesItem();
        refreshPage(); /*После обновления вкладки Receivables происходит переход на вкладку Eligible
         (или на Reserved если есть резервации) баг*/
        String expectedResult = "Total: ";
        String actualResult = receivablesPage.getTitleReceivables();
        assertTrue(actualResult.contains(expectedResult));
    }

}

