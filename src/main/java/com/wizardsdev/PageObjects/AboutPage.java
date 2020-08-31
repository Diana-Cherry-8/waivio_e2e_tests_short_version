package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Tools.SettingsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AboutPage extends Page{
    private static final String PAGE_URL = "/object/ylr-waivio";
    private static final By BUTTON_FOLLOW = By.cssSelector(".Follow");

    public AboutPage() {
        super(PAGE_URL);
    }

    @Step
    public boolean isFollowButtonExist() {
        return $(BUTTON_FOLLOW).shouldBe(Condition.visible).exists();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
