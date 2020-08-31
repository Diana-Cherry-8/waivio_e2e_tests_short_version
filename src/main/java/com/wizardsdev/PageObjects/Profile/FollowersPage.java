package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FollowersPage extends Page {
    private static final String PAGE_URL = "/@waivio_diana-ch/followers";
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER = By.cssSelector(".Follow--secondary");

    public FollowersPage() {
        super(PAGE_URL);
    }

    @Step
    public static FollowersPage openFollowersPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new FollowersPage();
    }

    @Step
    public boolean isButtonFollowFollowersUserExist() {
        return $(BUTTON_FOLLOW_FOLLOWERS_USER).shouldBe(Condition.visible).exists();
    }

    @Override
    protected void init() {
        String pageUrl = getCurrentPage();
        $(BUTTON_FOLLOW_FOLLOWERS_USER).shouldBe(Condition.visible);
        assert url().equals(pageUrl) : "Invalid page is opened";

    }

    @Override
    protected void parsePage() {

    }
}
