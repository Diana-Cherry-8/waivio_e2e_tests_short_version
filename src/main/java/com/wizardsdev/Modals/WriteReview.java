package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.EditorPage;
import com.wizardsdev.PageObjects.Rewards.ReservedPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class WriteReview extends Modal {

  private static final By BUTTON_WRITE_REVIEW_IN_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".Details__footer .ant-btn-primary");

  @Step
  public EditorPage clickWriteReviewInModalWindow() {
    $(BUTTON_WRITE_REVIEW_IN_MODAL_WINDOW_LOCATOR).shouldBe(Condition.visible).click();
    return new EditorPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
