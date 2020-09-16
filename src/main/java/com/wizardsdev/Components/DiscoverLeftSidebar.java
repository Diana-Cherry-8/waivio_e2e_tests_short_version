package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.DiscoverPage;
import com.wizardsdev.PageObjects.NotificationsPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.*;
import com.wizardsdev.PageObjects.Tools.*;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DiscoverLeftSidebar extends Page {
    private static final By SIDE_BAR_ITEMS_LINK_DISCOVER_LOCATOR = By.cssSelector(".sidenav-discover-objects__item");
    private static final By BUTTON_SHOW_MORE_LOCATOR = By.cssSelector(".sidenav-discover-objects__show-more");

    public DiscoverLeftSidebar() {
        super();
    }

    public static DiscoverLeftSidebar initDiscoverLeftSidebar() {
        return new DiscoverLeftSidebar();
    }

//    public void clickOnSideBarItemDiscoverByName(String itemName){
//        $$(SIDE_BAR_ITEMS_LINK_DISCOVER_LOCATOR).findBy(Condition.text(itemName)).click();
//    }
    public static void clickOnSideBarItemDiscoverByIndex(int index){
        $(SIDE_BAR_ITEMS_LINK_DISCOVER_LOCATOR).shouldBe(Condition.visible);
        $$(SIDE_BAR_ITEMS_LINK_DISCOVER_LOCATOR).get(index).click();
    }

    @Step
    public DiscoverPage clickOnAllObjectsItem() {
        clickOnSideBarItemDiscoverByIndex(0);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnHashtagObjectItem() {
        clickOnSideBarItemDiscoverByIndex(1);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnRestaurantObjectItems() {
        clickOnSideBarItemDiscoverByIndex(2);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnDishObjectItem() {
        clickOnSideBarItemDiscoverByIndex(3);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnBusinessObjectItem() {
        clickOnSideBarItemDiscoverByIndex(4);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnProductObjectItem() {
        clickOnSideBarItemDiscoverByIndex(5);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnDrinkObjectItem() {
        clickOnSideBarItemDiscoverByIndex(6);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPlaceObjectItem() {
        clickOnSideBarItemDiscoverByIndex(7);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnListObjectItem() {
        clickOnSideBarItemDiscoverByIndex(8);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPageObjectItem() {
        clickOnSideBarItemDiscoverByIndex(9);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCryptoObjectItem() {
        clickOnSideBarItemDiscoverByIndex(10);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnIndicesObjectItem() {
        clickOnSideBarItemDiscoverByIndex(11);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCommodityObjectItem() {
        clickOnSideBarItemDiscoverByIndex(12);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCurrencyObjectItem() {
        clickOnSideBarItemDiscoverByIndex(13);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnStocksObjectItem() {
        clickOnSideBarItemDiscoverByIndex(14);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnAppObjectItem() {
        clickOnSideBarItemDiscoverByIndex(15);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCurrenciesObjectItem() {
        clickOnSideBarItemDiscoverByIndex(16);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnServiceObjectItem() {
        clickOnSideBarItemDiscoverByIndex(17);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCompanyObjectItem() {
        clickOnSideBarItemDiscoverByIndex(18);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnOrganizationObjectItem() {
        clickOnSideBarItemDiscoverByIndex(19);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnHotelObjectItem() {
        clickOnSideBarItemDiscoverByIndex(20);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnMotelObjectItem() {
        clickOnSideBarItemDiscoverByIndex(21);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnResortObjectItem() {
        clickOnSideBarItemDiscoverByIndex(22);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnBAndBObjectItem() {
        clickOnSideBarItemDiscoverByIndex(23);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPersonObjectItem() {
        clickOnSideBarItemDiscoverByIndex(24);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCarObjectItem() {
        clickOnSideBarItemDiscoverByIndex(25);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnTestObjectItem() {
        clickOnSideBarItemDiscoverByIndex(26);
        return new DiscoverPage();
    }


    @Step
    public void clickOnShowMoreButton() {
        $(BUTTON_SHOW_MORE_LOCATOR).shouldBe(Condition.visible).click();
        //return new DiscoverPage();
    }

//    @Step
//    public InvitePage clickOnInviteItem() {
//        clickOnSideBarItemDiscoverByIndex(6);
//        return new InvitePage();
//    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


