package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class UpdatesObjectPage extends ObjectPage{
    private static final By BUTTON_WRITE_A_NEW_REVIEW = By.cssSelector(".icon-button");

    @Step
    public String getButtonText() {
        return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).getText();
    }

    @Override
    protected void init() {
        $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible);
    }

    @Override
    protected void parsePage() {

    }
}
