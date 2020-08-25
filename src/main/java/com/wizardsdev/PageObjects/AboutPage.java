package com.wizardsdev.PageObjects;

import com.wizardsdev.PageObjects.Tools.SettingsPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class AboutPage extends Page{
    private static final String PAGE_URL = "/bookmarks";

    public AboutPage() {
        super(PAGE_URL);
    }

    @Step
    public AboutPage openAboutPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new AboutPage();
    }
    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
