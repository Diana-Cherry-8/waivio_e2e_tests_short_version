package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

@Feature("History Page, Rewards")
public class HistoryTest extends TestBase {

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Story("Open page")
    @DisplayName("Check history page is opened in Rewards")
    @Test
    void openHistory() {
        feedPage = header.clickOnLogo();
        eligiblePage = topNavigation.clickOnRewardsItem();
        historyPage = rewardsLeftSidebar.clickOnHistoryItem();
        refreshPage();
        String expectedResult = "History and sponsor communications";
        String actualResult = historyPage.getTitleRewards();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check post about rewards reservations is opened")
    @Test
    void openViewReservation() {
        feedPage = header.clickOnLogo();
        eligiblePage = topNavigation.clickOnRewardsItem();
        historyPage = rewardsLeftSidebar.clickOnHistoryItem();
        historyPage.clickButtonMore();
        fullScreenOfTheReservationPost = historyPage.clickOnItemViewReservation();
        refreshPage();
        String expectedResult = "Rewards reservations";
        String actualResult = fullScreenOfTheReservationPost.getTitleRewardsReservations();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check post about rewards reservations is opened")
    @Test
    void checkPostRewardsReservationsDoesNotContainUndefined() {
        feedPage = header.clickOnLogo();
        eligiblePage = topNavigation.clickOnRewardsItem();
        historyPage = rewardsLeftSidebar.clickOnHistoryItem();
        historyPage.clickButtonMore();
        fullScreenOfTheReservationPost = historyPage.clickOnItemViewReservation();
        refreshPage();
        String expectedResult = "undefined";
        String actualResult = fullScreenOfTheReservationPost.getContentPage();
        assertFalse(actualResult.contains(expectedResult));
    }
}

