package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class BookmarksPage extends Page {
    private static final String PAGE_URL = "/bookmarks";
    private static final By MESSAGE_ANY_BOOKMARKS = By.cssSelector(".center h3");

    public BookmarksPage() {
        super(PAGE_URL);
    }

    @Step
    public BookmarksPage openBookmarksPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new BookmarksPage();
    }

    @Step
    public String getMessageAnyBookmarks() {
        return $(MESSAGE_ANY_BOOKMARKS).getText();
    }

    @Override
    protected void init() {
        String pageUrl = getCurrentPage();
        $(MESSAGE_ANY_BOOKMARKS).shouldBe(Condition.visible);
        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}
