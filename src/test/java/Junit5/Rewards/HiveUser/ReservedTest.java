package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.clearBrowserCookies;
import static com.codeborne.selenide.Selenide.clearBrowserLocalStorage;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Reserved Page, Rewards")
public class ReservedTest extends TestBase {
    String sponsorName = "daine-cherry2";

    @BeforeAll
    static void login() {
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

    @Story("Make a reservation")
    @DisplayName("Check the possibility of reservation")
    @Test
    void makeAReservation() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        rewardsLeftSidebar.clickOnEligibleItem();
        eligiblePage.clickOnSpecificSponsorInFilter(sponsorName);
        eligiblePage.clickEarnButton();
        String expectedResult = eligiblePage.getTitleSecondaryObject();
        reservation = eligiblePage.clickReserveButtonInCard();
        reservedPage = reservation.clickReserveButtonInModalWindow();
        sleep(15000);
        refreshPage();
        String actualResult = reservedPage.getTitleObjectCardName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Released a reservation")
    @DisplayName("Check the possibility of canceling the reservation")
    @Test
    void releasedAReservation() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        reservedPage = rewardsLeftSidebar.clickOnReservedItems();
        reservedPage.clickOnTheFirstButtonMore();
        reservedPage.clickOnItemRelease();
        sleep(5000);
        reservedPage.clickOnOkButton();
        sleep(10000);
        rewardsLeftSidebar.clickOnReservedItems();
        String expectedResult = "No reward matches the criteria";
        String actualResult = reservedPage.getTextNoReward();
        assertEquals(expectedResult, actualResult);
    }
}
