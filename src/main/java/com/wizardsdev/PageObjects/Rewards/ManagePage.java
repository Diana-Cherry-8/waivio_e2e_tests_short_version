package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ManagePage extends Page {
    private static final String PAGE_URL = "/rewards/manage";
    private static final By TITLE_ACCOUNT_BALANCE_LOCATOR = By.cssSelector(".Manage__account-balance-wrap-title");

    public ManagePage() {
        super(PAGE_URL);
    }

    @Step
    public static ManagePage openManagePage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ManagePage();
    }

    @Step
    public String getTitleAccountBalance()
    {
        return $(TITLE_ACCOUNT_BALANCE_LOCATOR).shouldBe(Condition.visible).getText();
    }
    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
