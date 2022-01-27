package com.wizardsdev.PageObjects.Facebook;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FacebookEditorPage extends Page {
  private static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector("._51mx button");
  private static final By POST_IN_EDITOR_LOCATOR = By.cssSelector(".unclickable");

  public static FacebookEditorPage openFacebookEditorPage() {
    open();
    return new FacebookEditorPage();
  }

  public FacebookEditorPage() {
    $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public boolean isPostExistInFacebookEditor() {
    return $(POST_IN_EDITOR_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public FacebookProfilePage clickPublishFacebook() {
    $$(BUTTON_SUBMIT_LOCATOR).get(1).click();
    return new FacebookProfilePage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
