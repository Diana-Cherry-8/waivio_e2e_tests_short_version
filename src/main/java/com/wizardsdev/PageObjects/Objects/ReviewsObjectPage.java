package com.wizardsdev.PageObjects.Objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReviewsObjectPage extends ObjectPage{

    private static final String PAGE_URL = "/object/" + restaurantObject;

    public ReviewsObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReviewsObjectPage openReviewsObjectPage() {
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
