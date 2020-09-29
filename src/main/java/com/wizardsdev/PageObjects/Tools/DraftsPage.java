package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class DraftsPage extends Page {
    private static final String PAGE_URL = "/drafts";
    private static final By LINK_DELETE_SELECTED_LOCATOR = By.cssSelector(".Drafts__toolbar__delete span");

    public DraftsPage() {
        super(PAGE_URL);
    }

    @Step
    public DraftsPage openDraftsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new DraftsPage();
    }

    @Override
    protected void init() {
//        String pageUrl = getCurrentPage();
//        $(LINK_DELETE_SELECTED_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}
