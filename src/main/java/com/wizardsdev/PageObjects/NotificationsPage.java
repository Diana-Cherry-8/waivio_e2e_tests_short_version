package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NotificationsPage extends Page{

  private static final By NOTIFICATIONS_PAGE_CONTENT_LOCATOR = By.className("NotificationsPage__content");

  @Step
  public boolean isNotificationsPageContentEmpty() {
    sleep(1000);
    $(NOTIFICATIONS_PAGE_CONTENT_LOCATOR).shouldBe(Condition.visible);
    return $(NOTIFICATIONS_PAGE_CONTENT_LOCATOR)
        .getText().contains("You currently have no notifications.");
  }

  @Step
  public boolean isNotificationPageOpened() {
    return $(NOTIFICATIONS_PAGE_CONTENT_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Override
  protected void init() {
    //$(NOTIFICATIONS_PAGE_CONTENT_LOCATOR).shouldBe(Condition.visible);
    $(By.className("center")).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {

  }
}
