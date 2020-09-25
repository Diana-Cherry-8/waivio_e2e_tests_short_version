package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class UpdatesObjectPage extends ObjectPage{
    static String RestaurantAddress = properties.getProperty("RestaurantObject");
    private static final String PAGE_URL = "/object/" + RestaurantAddress;
    private static final By TITLE_TOTAL_LOCATOR = By.cssSelector(".Debts__information-row");
    private static final By BUTTON_WRITE_A_NEW_REVIEW = By.cssSelector(".icon-button");

    public UpdatesObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static UpdatesObjectPage openUpdatesObjectPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new UpdatesObjectPage();
    }

    @Step
    public String getButtonText() {
        return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
