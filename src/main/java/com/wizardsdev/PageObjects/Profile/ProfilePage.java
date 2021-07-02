package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


import static com.codeborne.selenide.Selenide.*;

public abstract class ProfilePage {
    private static final ThreadLocal<String> currentPage = new ThreadLocal<>();
    private static final By BUTTON_EDIT_PROFILE_LOCATOR = By.cssSelector(".Action");
    private static final By TOP_NAVIGATION_PROFILE_PAGE = By.cssSelector(".UserMenu__item");
    private static final By USERNAME_LOCATOR = By.cssSelector(".UserHeader__row.UserHeader__handle");
    private static final By FOLLOW_UNFOLLOW_BUTTON_LOCATOR =
        By.cssSelector(".UserHeader__user__button button");
    private static final By PAYOUT_POST_LOCATOR = By.cssSelector(".Payout");

    @Step
    public String getUserNameValue() {
        return $(USERNAME_LOCATOR)
                .scrollTo()
                .shouldBe(Condition.visible)
                .getText()
                .replace("@","")
                .replace(" (guest)", "");
    }

    @Step
    public void clickOnFollowUnfollowButton() {
        $(FOLLOW_UNFOLLOW_BUTTON_LOCATOR).click();
    }

    @Step
    public WebElement getTopNavigationProfileItemByIndex(int index) {
        return  $$(TOP_NAVIGATION_PROFILE_PAGE).get(index).shouldBe(Condition.visible);
    }

    @Step
    public PostsPage clickOnPostsProfileItem() {
        getTopNavigationProfileItemByIndex(0).click();
        return new PostsPage(getUserNameValue());
    }

    @Step
    public CommentsPage clickOnCommentsProfileItem() {
        getTopNavigationProfileItemByIndex(1).click();
        return new CommentsPage(getUserNameValue());
    }

    @Step
    public FollowersPage clickOnFollowersProfileItem() {
        getTopNavigationProfileItemByIndex(2).click();
        return new FollowersPage(getUserNameValue());
    }

    @Step
    public FollowingPage clickOnFollowingProfileItem() {
        getTopNavigationProfileItemByIndex(3).click();
        return new FollowingPage(getUserNameValue());
    }

    @Step
    public ExpertisePage clickOnExpertiseProfileItem() {
        getTopNavigationProfileItemByIndex(4).click();
        return new ExpertisePage(getUserNameValue());
    }

    @Step
    public WalletPage clickOnWalletProfileItem() {
        getTopNavigationProfileItemByIndex(5).click();
        return new WalletPage(getUserNameValue());
    }

    protected ProfilePage(String pageUrl) {
        currentPage.set(pageUrl);
        init();
        parsePage();
    }

    protected ProfilePage() {
        init();
    }

    @Step
    public boolean isButtonEditProfileExist() {
        return $(BUTTON_EDIT_PROFILE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public boolean isPostPayoutDisplayed(String currency) {
        if (currency.equals("CAD")) {
            return $$(PAYOUT_POST_LOCATOR).get(0).shouldBe(Condition.matchText("CA")).exists();
        }
        if (currency.equals("USD")) {
            return $$(PAYOUT_POST_LOCATOR).get(0).shouldBe(Condition.matchText("$")).exists();
        }
        return true;
    }


    protected abstract void init();

    protected abstract void parsePage();

    public static String getCurrentPage() {
        return Context.getSiteUrl() + currentPage.get();
    }

}
