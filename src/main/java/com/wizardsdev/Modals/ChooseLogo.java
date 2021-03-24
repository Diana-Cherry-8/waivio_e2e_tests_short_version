package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ChooseLogo extends Modal{
  private static final By INPUT_FOR_LINK_LOCATOR = By.cssSelector(".input-upload__item");

  @Step
  public void addImage(String imageLink) {
    $(INPUT_FOR_LINK_LOCATOR).shouldBe(Condition.visible).setValue(imageLink);
    $$(BUTTON_SUBMIT_LOCATOR).get(4).shouldBe(Condition.visible).click();
  }

  @Override
  protected void init() {
  $(INPUT_FOR_LINK_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {



  }
}
