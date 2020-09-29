package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class ListObjectPage extends ObjectPage{
    static String listObject = properties.getProperty("ListObject");
    private static final String PAGE_URL = "/object/" + listObject + "/list";


    public ListObjectPage() {
        super(PAGE_URL);
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

    @Step
    public static ListObjectPage openListObjectPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ListObjectPage();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}

