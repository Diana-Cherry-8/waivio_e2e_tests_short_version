package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NotificationsPage extends Page{

  private static final By NOTIFICATIONS_PAGE_CONTENT_LOCATOR = By.className("NotificationsPage__content");

  @Step
  public boolean isNotificationsPageContentEmpty() {
    $(NOTIFICATIONS_PAGE_CONTENT_LOCATOR).shouldBe(Condition.visible);
    return $(NOTIFICATIONS_PAGE_CONTENT_LOCATOR)
        .getText().contains("You currently have no notifications.");
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
