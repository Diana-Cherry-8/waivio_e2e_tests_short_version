package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FollowingPage extends Page {
    private static final String PAGE_URL = "/@waivio_diana-ch/following";
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER = By.cssSelector(".Follow--secondary");

    public FollowingPage() {
        super(PAGE_URL);
    }

    @Step
    public static FollowingPage openFollowingPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new FollowingPage();
    }

    @Step
    public boolean isButtonFollowFollowingUserExist() {
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
