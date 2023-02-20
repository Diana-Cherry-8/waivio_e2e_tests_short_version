package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.DiscoverPage;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class DiscoverLeftSidebar extends Page {
    private static final By LINK_SIDE_BAR_ITEMS_DISCOVER_LOCATOR = By.cssSelector(".sidenav-discover-objects__item");
    private static final By BUTTON_SHOW_MORE_LOCATOR = By.cssSelector(".sidenav-discover-objects__show-more");

    public DiscoverLeftSidebar() {
        super();
    }

    public static DiscoverLeftSidebar initDiscoverLeftSidebar() {
        return new DiscoverLeftSidebar();
    }

    public static void clickOnSideBarItemDiscoverByIndex(int index){
        $(LINK_SIDE_BAR_ITEMS_DISCOVER_LOCATOR).shouldBe(Condition.visible);
        $$(LINK_SIDE_BAR_ITEMS_DISCOVER_LOCATOR).get(index).click();
    }

    @Step
    public DiscoverPage clickOnRestaurantObjectItem() {
        clickOnSideBarItemDiscoverByIndex(0);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnDishObjectItems() {
        clickOnSideBarItemDiscoverByIndex(1);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnDrinkObjectItem() {
        clickOnSideBarItemDiscoverByIndex(2);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnListObjectItem() {
        clickOnSideBarItemDiscoverByIndex(3);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPageObjectItem() {
        clickOnSideBarItemDiscoverByIndex(4);
        return new DiscoverPage();
    }

    public DiscoverPage clickOnBookObjectItem() {
        clickOnSideBarItemDiscoverByIndex(5);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnHashtagObjectItem() {
        clickOnSideBarItemDiscoverByIndex(6);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnBusinessObjectItem() {
        clickOnSideBarItemDiscoverByIndex(7);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnProductObjectItem() {
        clickOnSideBarItemDiscoverByIndex(8);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPersonObjectItem() {
        clickOnSideBarItemDiscoverByIndex(9);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCompanyObjectItem() {
        clickOnSideBarItemDiscoverByIndex(10);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnOrganizationObjectItem() {
        clickOnSideBarItemDiscoverByIndex(11);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnServiceObjectItem() {
        clickOnSideBarItemDiscoverByIndex(12);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnAppObjectItem() {
        clickOnSideBarItemDiscoverByIndex(13);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCryptoObjectItem() {
        clickOnSideBarItemDiscoverByIndex(14);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnIndicesObjectItem() {
        clickOnSideBarItemDiscoverByIndex(15);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCommodityObjectItem() {
        clickOnSideBarItemDiscoverByIndex(16);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCurrencyObjectItem() {
        clickOnSideBarItemDiscoverByIndex(17);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnStocksObjectItem() {
        clickOnSideBarItemDiscoverByIndex(18);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnCurrenciesObjectItem() {
        clickOnSideBarItemDiscoverByIndex(19);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnPlaceObjectItem() {
        clickOnSideBarItemDiscoverByIndex(20);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnHotelObjectItem() {
        clickOnSideBarItemDiscoverByIndex(21);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnMotelObjectItem() {
        clickOnSideBarItemDiscoverByIndex(22);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnResortItem() {
        clickOnSideBarItemDiscoverByIndex(23);
        return new DiscoverPage();
    }

    @Step
    public DiscoverPage clickOnBAndBObjectItem() {
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
    }


    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}


