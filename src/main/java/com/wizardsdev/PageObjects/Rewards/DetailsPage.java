package com.wizardsdev.PageObjects.Rewards;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class DetailsPage extends Page {
    private static final String PAGE_URL = "/rewards/referral-details/" + properties.getProperty("FacebookUserEmail00");
    private static final By TITLE_DETAILS_TITLE_LOCATOR = By.cssSelector(".ReferralDetail__title");

    public DetailsPage() {
        super(PAGE_URL);
    }

    @Step
    public static DetailsPage openDetailsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new DetailsPage();
    }

    @Step
    public String getTitleDetailsRewards() {
        return $(TITLE_DETAILS_TITLE_LOCATOR).getText();
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
