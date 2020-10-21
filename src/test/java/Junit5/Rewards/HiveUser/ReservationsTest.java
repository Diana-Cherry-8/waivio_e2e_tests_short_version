package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class ReservationsTest extends TestBase {
    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check Reservations page is opened in Rewards")
    @Test
    void openReservations() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        reservationsPage = rewardsLeftSidebar.clickOnReservationsItem();
        refreshPage();
        String expectedResult = "History of reservations";
        String actualResult = reservationsPage.getTitleRewards();
        assertTrue(actualResult.contains(expectedResult));
    }
}
