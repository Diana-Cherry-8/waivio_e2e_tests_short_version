package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class PageObjectPage extends ObjectPage{
    private static final String PAGE_URL = "/object/";
    private static final By CENTRAL_FEED_IN_PAGE_LOCATOR = By.cssSelector(".Body--full");


    public PageObjectPage() {
        super(PAGE_URL);
    }

    @Step
    public static PageObjectPage openPageObjectPage(String pageObject) {
        if (!url().contains(PAGE_URL + pageObject)) {
            open(PAGE_URL + pageObject);
        }
        return new PageObjectPage();
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
    public String getContentPage() {
        return $(CENTRAL_FEED_IN_PAGE_LOCATOR).shouldHave(Condition.visible).getText();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

