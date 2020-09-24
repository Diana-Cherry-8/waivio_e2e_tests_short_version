package com.wizardsdev.PageObjects.Objects;

import org.openqa.selenium.By;

public class AboutPage extends ObjectPage {
    private static final String PAGE_URL = "/object/ylr-waivio";
    private static final By BUTTON_FOLLOW_LOCATOR = By.cssSelector(".Follow");

    public AboutPage() {
        super(PAGE_URL);
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
