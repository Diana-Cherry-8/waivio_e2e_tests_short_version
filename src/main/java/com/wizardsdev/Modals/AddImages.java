package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.EditorPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class AddImages extends Modal {
  private static final By INPUT_FOR_LINK_LOCATOR = By.cssSelector(".input-upload__item");

  @Step
  public void pasteImageLink() {
    $(INPUT_FOR_LINK_LOCATOR).shouldBe(Condition.visible).sendKeys(Keys.CONTROL + "v");
    sleep(3000);
  }

  @Step
  public EditorPage clickOk() {
    $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
    return new EditorPage();
  }

  @Override
  protected void init() {
    $(INPUT_FOR_LINK_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {
  }
}