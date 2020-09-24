package com.wizardsdev.PageObjects.Objects;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class DrinkObjectPage extends Page {

    static String drinkObject = properties.getProperty("DrinkObject");
    private static final String PAGE_URL = "/object/" + drinkObject;
    public DrinkObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReviewsObjectPage openDrinkObjectPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ReviewsObjectPage();
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {
    }
}