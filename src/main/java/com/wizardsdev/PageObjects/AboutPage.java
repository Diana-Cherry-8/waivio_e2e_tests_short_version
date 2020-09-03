package com.wizardsdev.PageObjects;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class AboutPage extends Page{
    private static final String PAGE_URL = "/object/ylr-waivio";
    private static final By BUTTON_FOLLOW_LOCATOR = By.cssSelector(".Follow");
    private static final By TOP_NAVIGATION_ABOUT_PAGE_LOCATOR = By.cssSelector(".ObjectMenu__item");
    private static final By BUTTON_WRITE_A_NEW_REVIEW = By.cssSelector(".icon-button");
    private static final By SORTING_FOLLOWERS_LOCATOR = By.cssSelector(".SortSelector");
    private static final By BUTTON_FOLLOW_SECONDARY_LOCATOR = By.cssSelector(".Follow--secondary");

    public AboutPage() {
        super(PAGE_URL);
    }

    @Step
    public boolean isFollowButtonExist() {
        return $(BUTTON_FOLLOW_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public WebElement getTopNavigationAboutPageItemByIndex(int index) {
        return  $$(TOP_NAVIGATION_ABOUT_PAGE_LOCATOR).get(index).shouldBe(Condition.visible);
    }

    @Step
    public AboutPage clickOnReviewsItem() {
        getTopNavigationAboutPageItemByIndex(1).click();
        return new AboutPage();
    }

    @Step
    public AboutPage clickOnGalleryItem() {
        getTopNavigationAboutPageItemByIndex(2).click();
        return new AboutPage();
    }

    @Step
    public AboutPage clickOnUpdatesItem() {
        getTopNavigationAboutPageItemByIndex(3).click();
        return new AboutPage();
    }

    @Step
    public AboutPage clickOnFollowersItem() {
        getTopNavigationAboutPageItemByIndex(4).click();
        return new AboutPage();
    }

    @Step
    public AboutPage clickOnExpertiseItem() {
        getTopNavigationAboutPageItemByIndex(5).click();
        return new AboutPage();
    }

    @Step
    public boolean isButtonWriteReviewExist() {
        return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getTextButton() {
            return $(BUTTON_WRITE_A_NEW_REVIEW).shouldBe(Condition.visible).getText();
        }

    @Step
    public boolean isSortingInFollowersExist() {
        return $(SORTING_FOLLOWERS_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public boolean isButtonFollowSecondaryExist() {
        return $(BUTTON_FOLLOW_SECONDARY_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
