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

public class FollowersPage extends ProfilePage {
    private static final String DATA_KEY_ATTRIBUTE_NAME = "data-key";
    private static final By BUTTON_FOLLOW_FOLLOWERS_USER = By.cssSelector(".Follow--secondary");
    private static final By FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR = By.cssSelector(".UserDynamicList .username");
    private static final By USER_MENU_FOLLOWING_LOCATOR =
            Selectors.byAttribute(DATA_KEY_ATTRIBUTE_NAME, "following");
    private static final By USER_MENU_FOLLOWERS_LOCATOR =
            Selectors.byAttribute(DATA_KEY_ATTRIBUTE_NAME, "followers");
    private static final By USER_MENU_COUNTER_LOCATOR = By.className("UserMenu__badge");


    public FollowersPage(String userName) {
        super(Context.getSiteUrl()  + "/@" + userName + "/followers");
    }

    @Step
    public static FollowersPage openFollowersPage(String userName) {
        if (!url().contains(Context.getSiteUrl()  + "/@" + userName + "/followers")) {
            open(Context.getSiteUrl()  + "/@" + userName + "/followers");
        }
        return new FollowersPage(userName);
    }

    @Step
    public boolean isButtonFollowFollowersUserExist() {
        return $(BUTTON_FOLLOW_FOLLOWERS_USER).shouldBe(Condition.visible).exists();
    }

    @Step
    public List<String> getFollowerNamesList() {
        List<String> followersNamesList = new ArrayList<>();
        $(USER_MENU_FOLLOWERS_LOCATOR).click();
        $(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR).shouldBe(Condition.visible);
        ElementsCollection followerUsersList = $$(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR);
        for(WebElement element: followerUsersList){
            System.out.println(element.getText());
        }
        return followersNamesList;
    }

    @Step
    public int getFollowersNumberFromMenuCounter() {
        $(USER_MENU_FOLLOWERS_LOCATOR).click();
        return Integer.parseInt($(USER_MENU_FOLLOWERS_LOCATOR).
                shouldBe(Condition.visible).find(USER_MENU_COUNTER_LOCATOR).getText());
    }

    @Override
    protected void init() {

    }

    @Override
    protected void parsePage() {

    }
}
