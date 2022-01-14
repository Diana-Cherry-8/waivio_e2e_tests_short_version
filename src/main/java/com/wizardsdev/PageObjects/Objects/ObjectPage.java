package com.wizardsdev.PageObjects.Objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.wizardsdev.Context;
import com.wizardsdev.Modals.Post;
import com.wizardsdev.Modals.UpdateObject;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.TwitterPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public abstract class ObjectPage extends Page {
    private static final ThreadLocal<String> currentPage = new ThreadLocal<>();
    private static final By BUTTON_FOLLOW_LOCATOR = By.cssSelector(".Follow");
    private static final By BUTTON_WRITE_A_NEW_REVIEW = By.cssSelector(".icon-button");
    private static final By SORTING_FOLLOWERS_LOCATOR = By.cssSelector(".SortSelector");
    private static final By BUTTON_FOLLOW_SECONDARY_LOCATOR = By.cssSelector(".Follow--secondary");
    private static final By OBJECT_TYPE_LOCATOR = By.cssSelector(".ObjectType");
    private static final String PAGE_URL = "/object/";
    private static final By POST_TITLE_LOCATOR = By.cssSelector(".Story__content h2");
    private static final By SOCIAL_ITEMS_LOCATOR = By.cssSelector(".Popover__shared-link");
    private static final By TREE_DOTS_BUTTON_LOCATOR = By.cssSelector(".Buttons__post-menu");
    private static final By POST_LOCATOR = By.className("Story");
    private static final By BUTTON_EDIT_LOCATOR = By.cssSelector(".ObjectHeader__controls .ant-btn");
    private static final By LEFT_SIDEBAR_LINKS_LOCATOR =
        By.cssSelector(".object-sidebar .icon-button__icon");

    protected ObjectPage(String objectName) {
        super(Context.getSiteUrl()  + "/object/" + objectName);
    }

    @Step
    public static ReviewsObjectPage openObjectPage(String objectName) {
        if (!url().contains(PAGE_URL + objectName)) {
            open(PAGE_URL + objectName);
        }
        return new ReviewsObjectPage();
    }

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
        return $(BUTTON_FOLLOW_SECONDARY_LOCATOR).exists();
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

    @Step
    public String getPostTitle(int postIndex) {
        return $$(POST_TITLE_LOCATOR).get(postIndex).getText();
    }

    @Step
    public void clickOnTreeDotsButton(int index) {
        $$(TREE_DOTS_BUTTON_LOCATOR).get(index).shouldBe(Condition.visible).click();
    }

    @Step
    public TwitterPage clickOnTwitterInPostMenu(int index) {
        clickOnTreeDotsButton(index);
        $$(SOCIAL_ITEMS_LOCATOR).get(1).shouldBe(Condition.visible).click();
        return new TwitterPage();
    }

    @Step
    public Post openPost(int postIndex) {
        $$(POST_LOCATOR).get(postIndex).$(POST_TITLE_LOCATOR).click();
        return new Post();
    }

    @Step
    public void clickEditButton() {
        scrollToTopPage();
        $(BUTTON_EDIT_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public UpdateObject clickAddButtonViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(3).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddDescriptionViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(9).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddPriceViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(14).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddHoursViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(15).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddAddressViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(16).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddMapViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(17).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddWebsiteViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(18).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddPhoneViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(19).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddEmailViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(20).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public UpdateObject clickAddTitleViaLeftSidebar() {
        $$(LEFT_SIDEBAR_LINKS_LOCATOR).get(23).shouldBe(Condition.visible).click();
        return new UpdateObject();
    }

    @Step
    public void scrollToTopPage() {
        ((JavascriptExecutor) WebDriverRunner.getWebDriver()).executeScript("window.scrollTo(0, 0);");
    }

    public static String getCurrentPage() {
        return Context.getSiteUrl() + currentPage.get();
    }

    protected abstract void init();

    protected abstract void parsePage();

}

