package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class GuestsSettingsPage extends Page {
    private static final String PAGE_URL = "/guests-settings";
    private static final By SECTION_SETTINGS_LOCATOR = By.cssSelector(".Settings__section"); //находит 2 секции

    public GuestsSettingsPage() {
        super(PAGE_URL);
    }

    @Step
    public GuestsSettingsPage openGuestsSettingsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new GuestsSettingsPage();
    }

    @Override
    protected void init() {
//        String pageUrl = getCurrentPage();
//        $(SECTION_SETTINGS_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}



