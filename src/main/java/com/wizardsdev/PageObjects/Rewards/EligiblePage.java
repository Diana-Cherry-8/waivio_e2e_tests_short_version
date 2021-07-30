package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Modals.Reservation;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EligiblePage extends Page {
    private static final String PAGE_URL = "/rewards/active";
    private static final By BUTTON_CAMPAIGN_EARN_REFACTOR_LOCATOR = By.cssSelector(".Campaign__button");
    private static final By BUTTONS_RESERVE_LOCATOR = By.cssSelector(".ant-btn-primary");
    private static final By TITLE_SECONDARY_OBJECT_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");
    private static final By FILTER_LOCATOR = By.cssSelector(".RewardsFiltersPanel__item-wrap");

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
        $$(BUTTON_CAMPAIGN_EARN_REFACTOR_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public Reservation clickReserveButtonInCard() {
        $$(BUTTONS_RESERVE_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return new Reservation();
    }

    @Step
    public String getTitleSecondaryObject() {
        return $(TITLE_SECONDARY_OBJECT_NAME_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public void clickOnSpecificSponsorInFilter(String sponsorName) {
        $$(FILTER_LOCATOR).findBy(Condition.text(sponsorName)).shouldBe(Condition.visible)
            .findElement(By.cssSelector(".ant-checkbox")).click();
        $(By.cssSelector(".ant-checkbox-checked")).shouldBe(Condition.visible);
        sleep(3000);
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
