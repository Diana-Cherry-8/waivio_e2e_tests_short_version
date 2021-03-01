package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EligiblePage extends Page {
    private static final String PAGE_URL = "/rewards/active";
    private static final By BUTTON_CAMPAIGN_EARN_REFACTOR_LOCATOR = By.cssSelector(".Campaign__button");
    private static final By BUTTONS_RESERVE_LOCATOR = By.cssSelector(".ant-btn-primary");
    private static final By BUTTON_RESERVE_IN_MODAL_WINDOW_LOCATOR =
            By.cssSelector(".Details__footer-reserve-btn .ant-btn-primary");
    private static final By BUTTON_RESERVE_WITH_LOADING_IN_MODAL_WINDOW_LOCATOR =
        By.cssSelector(".Details__footer-reserve-btn .ant-btn-loading");
    private static final By TITLE_SECONDARY_OBJECT_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");

    public EligiblePage() {
        super(PAGE_URL);
    }

    @Step
    public static EligiblePage openEligiblePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new EligiblePage();
    }

    @Step
    public void clickEarnButton() {
        $(BUTTON_CAMPAIGN_EARN_REFACTOR_LOCATOR).click();
    }

    @Step
    public ReservationsPage clickReserveButtonInCard() {
        $$(BUTTONS_RESERVE_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return new ReservationsPage();
    }

    @Step
    public ReservedPage clickReserveButtonInModalWindow() {
        $(BUTTON_RESERVE_IN_MODAL_WINDOW_LOCATOR).shouldBe(Condition.visible).click();
        $(BUTTON_RESERVE_WITH_LOADING_IN_MODAL_WINDOW_LOCATOR).shouldBe(Condition.disappear);
        $(TITLE_REWARDS_LOCATOR).shouldBe(Condition.visible);
        return new ReservedPage();
    }


    @Step
    public String getTitleSecondaryObject() {
        return $(TITLE_SECONDARY_OBJECT_NAME_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$().shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
