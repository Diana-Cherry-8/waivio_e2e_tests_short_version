package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$$;

public class RewardsLeftSidebar extends Page {
    private static final By LINK_SIDE_BAR_ITEMS_REWARDS_LOCATOR = By.cssSelector(".sidenav-discover-objects__item");

    public RewardsLeftSidebar() {
        super();
    }

    public static RewardsLeftSidebar initRewardsLeftSidebar() {
        return new RewardsLeftSidebar();
    }

    public void clickOnSideBarItemRewardsByName(String itemName){
        $$(LINK_SIDE_BAR_ITEMS_REWARDS_LOCATOR).findBy(Condition.text(itemName)).click();
    }

    public static void clickOnSideBarItemRewardsByIndex(int index){
        $$(LINK_SIDE_BAR_ITEMS_REWARDS_LOCATOR).get(index).shouldBe(Condition.visible).click();
    }

    @Step
    public AllPage clickOnAllItem() {
        clickOnSideBarItemRewardsByIndex(0);
        return new AllPage();
    }

    @Step
    public EligiblePage clickOnEligibleItem() {
        clickOnSideBarItemRewardsByIndex(1);
        return new EligiblePage();
    }

    @Step
    public ReservedPage clickOnReservedItems() {
        clickOnSideBarItemRewardsByIndex(2);
        return new ReservedPage();
    }

    @Step
    public ReceivablesPage clickOnReceivablesItem() {
        clickOnSideBarItemRewardsByIndex(3);
        return new ReceivablesPage();
    }

    @Step
    public HistoryPage clickOnHistoryItem() {
        clickOnSideBarItemRewardsByIndex(4);
        return new HistoryPage();
    }

    @Step
    public ReportsPage clickOnReportsItem() {
        clickOnSideBarItemRewardsByIndex(5);
        return new ReportsPage();
    }

    @Step
    public CreatePage clickOnCreateItem() {
        clickOnSideBarItemRewardsByIndex(5);
        return new CreatePage();
    }

    @Step
    public ManagePage clickOnManageItem() {
        clickOnSideBarItemRewardsByIndex(6);
        return new ManagePage();
    }

    @Step
    public PayablesPage clickOnPayablesItem() {
        clickOnSideBarItemRewardsByIndex(7);
        return new PayablesPage();
    }

    @Step
    public ReportsPage clickOnReportsItemAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(8);
        return new ReportsPage();
    }

    @Step
    public ReservationsPage clickOnReservationsItem() {
        clickOnSideBarItemRewardsByIndex(9);
        return new ReservationsPage();
    }

    @Step
    public MessagesPage clickOnMessagesItem() {
        clickOnSideBarItemRewardsByIndex(10);
        return new MessagesPage();
    }

    @Step
    public FraudDetectionPage clickOnFraudDetectionItem() {
        clickOnSideBarItemRewardsByIndex(11);
        return new FraudDetectionPage();
    }

    @Step
    public BlacklistPage clickBlacklistItem() {
        clickOnSideBarItemRewardsByIndex(12);
        return new BlacklistPage();
    }

    @Step
    public DetailsPage clickOnDetailsItemAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(13);
        return new DetailsPage();
    }

    @Step
    public InstructionsPage clickOnInstructionsItemAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(14);
        return new InstructionsPage();
    }

    @Step
    public StatusPage clickOnStatusItemAsHiveUser() {
        clickOnSideBarItemRewardsByIndex(15);
        return new StatusPage();
    }

        @Step
    public MatchBotPage clickOnSponsorMatchBotItem() {
        clickOnSideBarItemRewardsByIndex(18);
        return new MatchBotPage();
    }

//    @Step
//    public clickTabs(String tab) {
//        $$(LINK_SIDE_BAR_ITEMS_REWARDS_LOCATOR).findBy(Condition.text(tab)).click();
//    }



    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
