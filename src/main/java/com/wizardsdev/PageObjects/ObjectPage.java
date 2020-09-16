package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ObjectPage extends Page {

  private static final By OBJECT_NAME_LOCATOR = By.cssSelector(".ObjectHeader__text");

  @Step
  public String getObjectName() {
    return $(OBJECT_NAME_LOCATOR).getText();
  }

  @Override
  protected void init() {
  }

  @Override
  protected void parsePage() {
  }
}
