package com.wizardsdev.PageObjects.Objects;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class RestaurantObjectPage extends Page {

    static String restaurantObject = properties.getProperty("RestaurantObject");
    private static final String PAGE_URL = "/object/" + restaurantObject;
    public RestaurantObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static RestaurantObjectPage openRestaurantPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new RestaurantObjectPage();
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {
    }
}
