package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HiveOnBoardPage extends Page{

  private static final By CONTINUE_BUTTONS = By.cssSelector(".MuiButtonBase-root");
  private static final By LEARN_LABEL_LOCATOR =
      By.cssSelector(".jss15 .MuiCardContent-root .MuiButton-label");

  @Step
  public String getContinueButtonText() {
    return $$(CONTINUE_BUTTONS).get(12).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getLearnLabelText() {
    return $(LEARN_LABEL_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
