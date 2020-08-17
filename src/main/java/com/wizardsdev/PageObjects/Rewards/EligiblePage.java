package com.wizardsdev.PageObjects.Rewards;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EligiblePage extends Page {
    private static final String PAGE_URL = "/rewards/active";
    private static final By ALL_PAGE_LOCATOR = By.cssSelector("#app > section > div > div.Rewards > div > div > div.leftContainer > div > div > ul > li:nth-child(2) > a");
    private static final By RESERVED_PAGE_LOCATOR = By.cssSelector("#app > section > div > div.Rewards > div > div > div.leftContainer > div > div > ul > li:nth-child(4) > a");
    private static final By RECEIVABLES_PAGE_LOCATOR = By.cssSelector("#app > section > div > div.Rewards > div > div > div.leftContainer > div > div > ul > li:nth-child(5) > a");
    private static final By REPORTS_PAGE_LOCATOR = By.cssSelector("#app > section > div > div.Rewards > div > div > div.leftContainer > div > div > ul > li:nth-child(6) > a");


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
    public AllPage clickAllPage() {
        $(ALL_PAGE_LOCATOR).click();
        return new AllPage();
    }

    @Step
    public ReservedPage clickReservedPage() {
        $(RESERVED_PAGE_LOCATOR).click();
        return new ReservedPage();
    }

    @Step
    public ReceivablesPage clickReceivablesPage() {
        $(RECEIVABLES_PAGE_LOCATOR).click();
        return new ReceivablesPage();
    }

    @Step
    public ReportsPage clickReportsPage() {
        $(REPORTS_PAGE_LOCATOR).click();
        return new ReportsPage();
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
