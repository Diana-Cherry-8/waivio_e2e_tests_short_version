package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.wizardsdev.PageObjects.FacebookSignPage;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import com.wizardsdev.PageObjects.TwitterPage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Post extends Modal {

  private static final By OBJECT_RELATED_BY_TAGS_LOCATOR = By.className("ant-collapse-header");
  private static final By OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR =
      By.cssSelector(".ObjectCardView__name-truncated");
  private static final By BUTTON_CLOSE_LOCATOR = By.className("PostModal__action");
  private static final By POST_AUTHOR_LOCATOR = By.cssSelector(".StoryFull .username");
  private static final By TWITTER_ICON_LOCATOR = By.cssSelector(".icon-twitter.PostModal__icon");
  private static final By FACEBOOK_ICON_LOCATOR = By.cssSelector(".icon-facebook.PostModal__icon");
  private static final By POST_FULL_SCREEN_ICON_LOCATOR =
      By.cssSelector(".icon-send.PostModal__icon");
  private static final By TREE_DOTS_LOCATOR = By.cssSelector(".StoryFull__header__more");
  private static final By TWITTER_ICON_IN_MENU_THREE_DOTS_LOCATOR = By.cssSelector(".icon-twitter");
  private static final By FACEBOOK_ICON_IN_MENU_THREE_DOTS_LOCATOR = By.cssSelector(".icon-facebook");

  @Step
  public void expandCollapseObjectRelatedList() {
    $(OBJECT_RELATED_BY_TAGS_LOCATOR).click();
  }

  @Step
  public void clickOnCloseButton() {
    $(BUTTON_CLOSE_LOCATOR).click();
  }

  @Step
  public String getPostAuthorName() {
    $(POST_AUTHOR_LOCATOR).scrollTo().shouldBe(Condition.visible);
    return  $(POST_AUTHOR_LOCATOR).getText();
  }

  @Step
  public ProfilePage clickOnPostAuthorName() {
    $(POST_AUTHOR_LOCATOR).shouldBe(Condition.visible).click();
    return new ProfilePage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Step
  public List<String> getObjectsRelatedNameList() {
    List<String> objectsRelatedNameList = new ArrayList<>();
    $(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR).scrollTo().shouldBe(Condition.visible);
    ElementsCollection objectsRelatedList = $$(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR);
    for(WebElement element: objectsRelatedList){
      objectsRelatedNameList.add(element.getText());
    }
    return objectsRelatedNameList;
  }

  @Step
  public String getFirstRelatedObjectName() {
    return $(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public ObjectPage clickOnRelatedObjectName(int objectIndex) {
    $$(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR).get(objectIndex).shouldBe(Condition.visible).click();
    return new ObjectPage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Step
  public TwitterPage clickTwitterIcon() {
    $(TWITTER_ICON_LOCATOR).shouldBe(Condition.visible).click();
    return new TwitterPage();
  }

  @Step
  public FacebookSignPage clickFacebookIcon(boolean newWindow) {
    $(FACEBOOK_ICON_LOCATOR).shouldBe(Condition.visible).click();
    return new FacebookSignPage(newWindow);
  }

  @Step
  public Post clickOnPostFullScreen() {
    $(POST_FULL_SCREEN_ICON_LOCATOR).shouldBe(Condition.visible).click();
    return new Post();
  }

  @Step
  public Post clickOnPostFullScreenReviewTab() {
    $$(POST_FULL_SCREEN_ICON_LOCATOR).get(1).shouldBe(Condition.visible).click();
    return new Post();
  }

  @Step
  public void clickOnThreeDots() {
    $(TREE_DOTS_LOCATOR).shouldBe(Condition.visible).click();
  }

  @Step
  public TwitterPage clickOnTwitterThoughThreeDots() {
    clickOnThreeDots();
    $(TWITTER_ICON_IN_MENU_THREE_DOTS_LOCATOR).shouldBe(Condition.visible).click();
    return new TwitterPage();
  }

  @Step
  public FacebookSignPage clickOnFacebookThoughThreeDots(boolean newWindow) {
    clickOnThreeDots();
    $(FACEBOOK_ICON_IN_MENU_THREE_DOTS_LOCATOR).shouldBe(Condition.visible).click();
    return new FacebookSignPage(newWindow);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }

}
