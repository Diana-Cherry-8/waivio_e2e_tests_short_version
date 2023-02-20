package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class FollowingPage extends ProfilePage {
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER = By.cssSelector(".Follow--secondary");
    private static final By FOLLOWING_SUB_TAB_LOCATOR = By.className("UserFollowing__item");
    private static final By FOLLOWING_OBJECTS_NAMES_LOCATOR = By.cssSelector(".ObjectDynamicList .ObjectCard__name-short");
    private static final By POST_LOCATOR = By.className("Story");
    private static final By FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR = By.cssSelector(".UserDynamicList .username");
    private static final String DATA_KEY_ATTRIBUTE_NAME = "data-key";
    private static final By USER_MENU_FOLLOWING_LOCATOR =
            Selectors.byAttribute(DATA_KEY_ATTRIBUTE_NAME, "following");
    private static final By USER_MENU_COUNTER_LOCATOR = By.className("UserMenu__badge");

    public FollowingPage(String userName) {
        super(Context.getSiteUrl()  + "/@" + userName + "/following");
    }

    @Step
    public static FollowingPage openFollowingPage(String userName) {
        if (!url().contains(Context.getSiteUrl()  + "/@" + userName + "/following")) {
            open(Context.getSiteUrl()  + "/@" + userName + "/following");
        }
        return new FollowingPage(userName);
    }

    @Step
    public boolean isButtonFollowFollowingUserExist() {
        return $(BUTTON_FOLLOW_FOLLOWERS_USER).shouldBe(Condition.visible).exists();
    }

    @Step
    public List<String> getFollowingObjectsNamesList() {
        List<String> followingObjectsNameList = new ArrayList<>();
        $(USER_MENU_FOLLOWING_LOCATOR).click();
        clickOnFollowingSubMenuItemByIndex(1);
        $(FOLLOWING_OBJECTS_NAMES_LOCATOR).shouldBe(Condition.visible);
        ElementsCollection followingObjectsList = $$(FOLLOWING_OBJECTS_NAMES_LOCATOR);
        for(WebElement element: followingObjectsList){
            followingObjectsNameList.add(element.getText());
        }
        return followingObjectsNameList;
    }

    @Step
    public List<String> getFollowingUsersNamesList() {
        List<String> followingUsersNamesList = new ArrayList<>();
        $(USER_MENU_FOLLOWING_LOCATOR).click();
        clickOnFollowingSubMenuItemByIndex(0);
        $(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR).shouldBe(Condition.visible);
        ElementsCollection followingUsersList = $$(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR);
        for(WebElement element: followingUsersList){
            followingUsersNamesList.add(element.getText());
        }
        return followingUsersNamesList;
    }

    @Step
    public int getFollowingNumberFromMenuCounter() {
        return Integer.parseInt($(USER_MENU_FOLLOWING_LOCATOR).
                shouldBe(Condition.visible).find(USER_MENU_COUNTER_LOCATOR).getText());
    }

    @Step
    public void clickOnFollowingSubMenuItemByIndex(int subMenuItemIndex) {
        $$(FOLLOWING_SUB_TAB_LOCATOR).get(subMenuItemIndex).click();
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {

    }
}
