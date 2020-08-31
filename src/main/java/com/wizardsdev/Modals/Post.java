package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.wizardsdev.PageObjects.ObjectPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import com.wizardsdev.PageObjects.UserPage;
import io.qameta.allure.Step;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Post extends Modal {

  private static final By OBJECT_RELATED_BY_TAGS_LOCATOR = By.className("ant-collapse-header");
  private static final By OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR = By.className("ObjectCardView__name-truncated");
  private static final By BUTTON_CLOSE_LOCATOR = By.className("PostModal__action");
  private static final By POST_AUTHOR_LOCATOR = By.cssSelector(".StoryFull .username");

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
    $(POST_AUTHOR_LOCATOR).shouldBe(Condition.visible);
    return  $(POST_AUTHOR_LOCATOR).getText();
  }

  @Step
  public ProfilePage clickOnPostAuthorName() {
    $(POST_AUTHOR_LOCATOR).click();
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
    $(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR).shouldBe(Condition.visible);
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
    $$(OBJECT_RELATED_BY_TAGS_NAMES_LOCATOR).get(objectIndex).click();
    return new ObjectPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }

}
