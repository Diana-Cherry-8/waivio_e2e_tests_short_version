package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CommentsPage extends Page {
    private static final String PAGE_URL = "/@waivio_diana-cherednik/comments";
    private static final By USERNAME_IN_POST_LOCATOR = By.cssSelector(".username");

    public CommentsPage() {
        super(PAGE_URL);
    }

    @Step
    public static CommentsPage openCommentsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new CommentsPage();
    }

    @Step
    public String getUsernameInPost()
    {
        return $(USERNAME_IN_POST_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$().shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
