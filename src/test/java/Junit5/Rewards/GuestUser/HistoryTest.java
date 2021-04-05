package Junit5.Rewards.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("History Page, Rewards")
public class HistoryTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
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

