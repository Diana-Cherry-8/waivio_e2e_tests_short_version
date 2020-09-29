package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.wizardsdev.Context.properties;

public abstract class ObjectPage extends Page {
    private static final ThreadLocal<String> currentPage = new ThreadLocal<>();
    private static final By BUTTON_FOLLOW_LOCATOR = By.cssSelector(".Follow");
    private static final By BUTTON_WRITE_A_NEW_REVIEW = By.cssSelector(".icon-button");
    private static final By SORTING_FOLLOWERS_LOCATOR = By.cssSelector(".SortSelector");
    private static final By BUTTON_FOLLOW_SECONDARY_LOCATOR = By.cssSelector(".Follow--secondary");
    private static final By OBJECT_TYPE_LOCATOR = By.cssSelector(".ObjectType");

    static String restaurantObject = properties.getProperty("RestaurantObject");

    protected ObjectPage() {
        init();
    }

    @Step
    public WebElement getTopNavigationObjectItemByIndex(int index) {
        return  $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(index).shouldBe(Condition.visible);
    }

    @Step
    public ReviewsObjectPage clickOnReviewsItem() {
        getTopNavigationObjectItemByIndex(1).click();
        return new ReviewsObjectPage();
    }

    @Step
    public GalleryObjectPage clickOnGalleryItem() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(4).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(2).click();
        return new GalleryObjectPage();
    }

    @Step
    public UpdatesObjectPage clickOnUpdatesItem() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(4).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(3).click();
        return new UpdatesObjectPage();
    }

    @Step
    public FollowersObjectPage clickOnFollowersItem() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(4).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(4).click();
        return new FollowersObjectPage();
    }

    @Step
    public ExpertsObjectPage clickOnExpertiseItem() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(5).shouldBe(Condition.visible);
        getTopNavigationObjectItemByIndex(5).click();
        return new ExpertsObjectPage();
    }

    @Step
    public boolean isSortingInFollowersExist() {
        return $(SORTING_FOLLOWERS_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public boolean isButtonFollowSecondaryExist() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(5).shouldBe(Condition.visible);
        return $(BUTTON_FOLLOW_SECONDARY_LOCATOR).shouldBe(Condition.visible).exists();
    }

    protected ObjectPage(String pageUrl) {
        currentPage.set(pageUrl);
        init();
        parsePage();
    }

    @Step
    public WebElement getTopNavigationAboutPageItemByIndex(int index) {
        return  $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(index).shouldBe(Condition.visible);
    }

    @Step
    public boolean isButtonWriteReviewExist() {
        $$(TOP_NAVIGATION_OBJECT_PAGE_LOCATOR).get(4).shouldBe(Condition.visible);
        return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getButtonText() {
        return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).getText();
    }

    @Step
    public boolean isFollowButtonExist() {
        sleep(6000);
        return $(BUTTON_FOLLOW_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getObjectTypeName() {
        return $(OBJECT_TYPE_LOCATOR).shouldBe(Condition.visible).getText();
    }

    public static String getCurrentPage() {
        return Context.getSiteUrl() + currentPage.get();
    }

    protected abstract void init();

    protected abstract void parsePage();

}

