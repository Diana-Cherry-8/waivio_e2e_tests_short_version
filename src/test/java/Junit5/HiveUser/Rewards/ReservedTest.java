package Junit5.HiveUser.Rewards;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Reserved Page, Rewards")
public class ReservedTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check reserved page is opened in Rewards")
    @Test
    void openReservedTest() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        reservedPage = rewardsLeftSidebar.clickOnReservedItems();
        String expectedResult = "Reserved rewards";
        String actualResult = reservedPage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @AfterEach
    void logout() {
        header.logOut();
    }
}
