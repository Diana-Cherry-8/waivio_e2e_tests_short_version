package com.wizardsdev.PageObjects.Objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReviewsObjectPage extends ObjectPage{

    private static final String PAGE_URL = "/object/";



    @Step
    public static ReviewsObjectPage openReviewsObjectPage(String object) {
        if (!url().contains(PAGE_URL + object)) {
            open(PAGE_URL + object);
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
