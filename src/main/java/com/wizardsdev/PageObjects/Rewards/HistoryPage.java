package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class HistoryPage extends Page {
    private static final String PAGE_URL = "/rewards/history";

    public HistoryPage() {
        super(PAGE_URL);
    }

    @Step
    public static HistoryPage openHistoryPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new HistoryPage();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        String pageUrl = getCurrentPage();
        $(REWARDS_TITLE_LOCATOR).shouldBe(Condition.visible);
        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
