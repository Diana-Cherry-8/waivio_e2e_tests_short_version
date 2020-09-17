package Junit5.Rewards;

import Junit5.TestBase;
import com.wizardsdev.Components.RewardsLeftSidebar;
import com.wizardsdev.Components.ToolsLeftSidebar;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import com.wizardsdev.PageObjects.Rewards.ReceivablesPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Receivables Page, Rewards")
public class ReceivablesTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check receivables page is opened in Rewards")
    @Test
    void openReceivablesTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        receivablesPage = rewardsLeftSidebar.clickOnReceivablesItem();
        refreshPage();
        String expectedResult = "Total: ";
        String actualResult = receivablesPage.getTitleReceivables();
        assertTrue(actualResult.contains(expectedResult));
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}

