package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SettingsPage extends Page {
    private static final String PAGE_URL = "/settings";
    private static final By BUTTON_SAVE_NOTIFICATION_SETTINGS = By.cssSelector(".Action--primary");

    public SettingsPage() {
        super(PAGE_URL);
    }

    @Step
    public SettingsPage openSettingsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new SettingsPage();
    }

    @Override
    protected void init() {
        String pageUrl = getCurrentPage();
        $(BUTTON_SAVE_NOTIFICATION_SETTINGS).shouldBe(Condition.visible);
        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}


