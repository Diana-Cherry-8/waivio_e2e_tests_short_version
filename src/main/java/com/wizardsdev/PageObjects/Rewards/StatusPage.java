package com.wizardsdev.PageObjects.Rewards;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class StatusPage extends Page {
    private static final String PAGE_URL = "/rewards/referral-status/" + properties.getProperty("FacebookUserEmail00");
    private static final By TITLE_STATUS_LOCATOR = By.cssSelector(".ReferralStatus__title");

    public StatusPage() {
        super(PAGE_URL);
    }

    @Step
    public static StatusPage openStatusPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new StatusPage();
    }

    @Step
    public String getTitleStatusRewards() {
        return $(TITLE_STATUS_LOCATOR).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$(REWARDS_TITLE_LOCATOR).shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
