package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class PayablesPage extends Page {
    private static final String PAGE_URL = "/rewards/payables";
    private static final By TITLE_TOTAL_LOCATOR = By.cssSelector(".Debts__information-row");

    public PayablesPage() {
        super(PAGE_URL);
    }

    @Step
    public static PayablesPage openPayablesPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new PayablesPage();
    }

    @Step
    public String getTitlePayables()
    {
        return $(TITLE_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
//        String pageUrl = getCurrentPage();
//        $(TITLE_TOTAL_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}