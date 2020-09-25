package com.wizardsdev.PageObjects.Objects;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class DishObjectPage extends ObjectPage {

    static String dishObject = properties.getProperty("DishObject");
    private static final String PAGE_URL = "/object/" + dishObject;
    public DishObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReviewsObjectPage openDishObjectPage() {
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
