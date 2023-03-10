package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ListObjectPage extends ObjectPage{
    private static final String PAGE_URL = "/object/";
    private static final String urlFirstTab = "/list";

    @Step
    public static ListObjectPage openListObjectPage(String listName) {
        if (!url().contains(PAGE_URL + listName + urlFirstTab)) {
            open(PAGE_URL + listName + urlFirstTab);
        }
        return new ListObjectPage();
    }

    @Step
    public ReviewsObjectPage clickOnReviewsItemList() {
        getTopNavigationObjectItemByIndex(2).click();
        return new ReviewsObjectPage();
    }

    @Step
    public GalleryObjectPage clickOnGalleryItemList() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(6).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(3).click();
        return new GalleryObjectPage();
    }

    @Step
    public UpdatesObjectPage clickOnUpdatesItemList() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(6).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(4).click();
        return new UpdatesObjectPage();
    }

    @Step
    public FollowersObjectPage clickOnFollowersItemList() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(6).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(5).click();
        return new FollowersObjectPage();
    }

    @Step
    public ExpertsObjectPage clickOnExpertiseItemList() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(6).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(6).click();
        return new ExpertsObjectPage();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

