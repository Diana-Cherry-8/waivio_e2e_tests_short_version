package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignUp extends Modal {

  private static final By LINK_SING_UP_CARD_LOCATOR = By.cssSelector(".SignUpCard a");

  public SignUp() {
    super();
  }

  @Step
  public void clickOnSingUpThroughEsteem() {
    $$(LINK_SING_UP_CARD_LOCATOR).get(1).click();
  }

  @Override
  protected void init() {
    $(LINK_SING_UP_CARD_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void parsePage() {

  }
}
