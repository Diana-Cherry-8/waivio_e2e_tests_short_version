package com.wizardsdev.PageObjects.Tools;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ToolsNotificationsPage extends Page {
    private static final String PAGE_URL = "/notification-settings";
    private static final By BUTTON_SAVE_NOTIFICATION_SETTINGS = By.cssSelector(".Action--primary");

    public ToolsNotificationsPage() {
        super(PAGE_URL);
    }

    @Step
    public ToolsNotificationsPage openNotificationsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ToolsNotificationsPage();
    }

    @Override
    protected void init() {
//        String pageUrl = getCurrentPage();
//        $(BUTTON_SAVE_NOTIFICATION_SETTINGS).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}
