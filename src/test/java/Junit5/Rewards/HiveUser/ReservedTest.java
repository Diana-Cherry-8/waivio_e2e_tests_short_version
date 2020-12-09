package Junit5.Rewards.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Reserved Page, Rewards")
public class ReservedTest extends TestBase {
    private static final By TITLE_OBJECT_CARD_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");

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
        eligiblePage.clickEarnButton();
        String expectedResult = eligiblePage.getTitleSecondaryObject();
        eligiblePage.clickReserveButtonInCard();
        reservedPage = eligiblePage.clickReserveButtonInModalWindow();
        waiter.until(ExpectedConditions.visibilityOf($(TITLE_OBJECT_CARD_NAME_LOCATOR)));
        //sleep(10000);
        refreshPage();
        String actualResult = reservedPage.getTitleObjectCardName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Released a reservation")
    @DisplayName("Check the possibility of canceling the reservation")
    @Test
    void releasedAReservation() {
        eligiblePage = topNavigation.clickOnRewardsItem();
        reservedPage = rewardsLeftSidebar.clickOnReservedItems();
        reservedPage.clickButtonMore();
        reservedPage.clickOnItemRelease();
        reservedPage.clickOnOkButton();
        sleep(10000);
        rewardsLeftSidebar.clickOnReservedItems();
        String expectedResult = "No reward matches the criteria";
        String actualResult = reservedPage.getTextNoReward();
        assertEquals(expectedResult, actualResult);
    }
}
