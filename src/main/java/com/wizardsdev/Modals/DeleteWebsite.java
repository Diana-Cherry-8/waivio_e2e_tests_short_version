package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DeleteWebsite extends Modal{
  private static final By BUTTON_RE_BLOG_IN_RE_BLOG_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".ant-btn-primary");
  private static final By MODAL_WINDOW_RE_BLOG_LOCATOR = By.cssSelector(".ant-modal-content");

  @Step
  public void submitDelete() {
    $(BUTTON_RE_BLOG_IN_RE_BLOG_MODAL_WINDOW_LOCATOR).shouldBe(Condition.visible).click();
    $(MODAL_WINDOW_RE_BLOG_LOCATOR).shouldBe(Condition.disappear);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
