package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class PageObjectPage extends ObjectPage{
    static String pageObject = properties.getProperty("PageObject");
    private static final String PAGE_URL = "/object/" + pageObject;


    public PageObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public ReviewsObjectPage clickOnReviewsItemPage() {
        getTopNavigationObjectItemByIndex(2).click();
        return new ReviewsObjectPage();
    }

    @Step
    public UpdatesObjectPage clickOnUpdatesItemPage() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(5).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(3).click();
        return new UpdatesObjectPage();
    }

    @Step
    public FollowersObjectPage clickOnFollowersItemPage() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(5).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(4).click();
        return new FollowersObjectPage();
    }

    @Step
    public ExpertsObjectPage clickOnExpertiseItemPage() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(5).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(5).click();
        return new ExpertsObjectPage();
    }

    @Step
    public static PageObjectPage openPageObjectPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new PageObjectPage();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

