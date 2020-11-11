package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReservedPage extends Page {
    private static final String PAGE_URL = "/rewards/reserved";
    private static final By TITLE_OBJECT_CARD_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");
    private static final By BUTTONS_MORE_LOCATOR = By.cssSelector(".icon-more");
    private static final By BUTTON_THREE_POINT_LOCATOR = By.cssSelector(".PopoverMenu a");
    private static final By BUTTON_OK_LOCATOR = By.cssSelector(".ant-modal-footer .ant-btn-primary");
    private static final By TEXT_NO_REWARD_LOCATOR = By.cssSelector(".FilteredRewardsList");

    public ReservedPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReservedPage openReservedPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ReservedPage();
    }

    @Step
    public String getTitleObjectCardName() {
        return $(TITLE_OBJECT_CARD_NAME_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public void clickButtonMore() {
        $$(BUTTONS_MORE_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickOnItemRelease() {
        $$(BUTTON_THREE_POINT_LOCATOR).get(2).click();
    }

    @Step
    public void clickOnOkButton() {
        $(BUTTON_OK_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public String getTextNoReward() {
        return $(TEXT_NO_REWARD_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
//        String pageUrl = getCurrentPage();
//        $(REWARDS_TITLE_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}

