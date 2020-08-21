package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class EligiblePage extends Page {
    private static final String PAGE_URL = "/rewards/active";
    private static final By OBJECT_CARD_VIEW = By.cssSelector(".ObjectCardView");



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

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$(OBJECT_CARD_VIEW).shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
