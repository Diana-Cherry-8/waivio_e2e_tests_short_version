package com.wizardsdev.PageObjects.Rewards;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReceivablesPage extends Page {
    private static final String PAGE_URL = "/rewards/receivables";

    public ReceivablesPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReceivablesPage openReceivablesPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ReceivablesPage();
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

