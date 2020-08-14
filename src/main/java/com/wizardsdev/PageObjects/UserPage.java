package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class UserPage extends Page {
  private static final String DATA_KEY_ATTRIBUTE_NAME = "data-key";

  private static final By USERNAME_LOCATOR = By.cssSelector(".UserHeader__row.UserHeader__handle");
  private static final By FOLLOWING_SUB_TAB_LOCATOR = By.className("UserFollowing__item");
  private static final By FOLLOWING_OBJECTS_NAMES_LOCATOR = By.cssSelector(".ObjectDynamicList .ObjectCard__name-short");
  private static final By FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR = By.cssSelector(".UserDynamicList .username");
  private static final By FOLLOW_UNFOLLOW_BUTTON_LOCATOR = By.cssSelector(".UserHeader__user__button button");
  private static final By USER_MENU_FOLLOWING_LOCATOR = Selectors.byAttribute(DATA_KEY_ATTRIBUTE_NAME, "followed");
  private static final By USER_MENU_FOLLOWERS_LOCATOR = Selectors.byAttribute(DATA_KEY_ATTRIBUTE_NAME, "followers");
  private static final By USER_MENU_COUNTER_LOCATOR = By.className("UserMenu__badge");
  private static final By POST_LOCATOR = By.className("Story");

  @Step
  public static UserPage openUserPage(String userName) {
    open(Context.getSiteUrl()  + "/@" + userName);
    return new UserPage();
  }

  @Step
  public String getUserNameValue() {
    return $(USERNAME_LOCATOR)
        .shouldBe(Condition.visible)
        .getText()
        .replace("@","")
        .replace(" (guest)", "");
  }

  @Step
  public void clickOnFollowingSubMenuItemByIndex(int subMenuItemIndex) {
    $$(FOLLOWING_SUB_TAB_LOCATOR).get(subMenuItemIndex).click();
  }

  @Step
  public void clickOnFollowUnfollowButton() {
    $(FOLLOW_UNFOLLOW_BUTTON_LOCATOR).click();
  }

  @Step
  public List<String> getFollowingObjectsNamesList() {
    List<String> followingObjectsNameList = new ArrayList<>();
    $(USER_MENU_FOLLOWING_LOCATOR).click();
    clickOnFollowingSubMenuItemByIndex(0);
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
    clickOnFollowingSubMenuItemByIndex(1);
    $(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection followingUsersList = $$(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR);
    for(WebElement element: followingUsersList){
      followingUsersNamesList.add(element.getText());
    }
    return followingUsersNamesList;
  }

  @Step
  public List<String> getFollowerNamesList() {
    List<String> followersNamesList = new ArrayList<>();
    $(USER_MENU_FOLLOWERS_LOCATOR).click();
    $(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection followerUsersList = $$(FOLLOWING_FOLLOWERS_USERS_NAMES_LOCATOR);
    for(WebElement element: followerUsersList){
      followersNamesList.add(element.getText());
    }
    return followersNamesList;
  }

  @Step
  public int getFollowingNumberFromMenuCounter() {
    return Integer.parseInt($(USER_MENU_FOLLOWING_LOCATOR).
        shouldBe(Condition.visible).find(USER_MENU_COUNTER_LOCATOR).getText());
  }

  @Step
  public int getFollowersNumberFromMenuCounter() {
    $(USER_MENU_FOLLOWERS_LOCATOR).click();
    return Integer.parseInt($(USER_MENU_FOLLOWERS_LOCATOR).
        shouldBe(Condition.visible).find(USER_MENU_COUNTER_LOCATOR).getText());
  }

  @Override
  protected void init() {
    $(USERNAME_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {

  }
}
