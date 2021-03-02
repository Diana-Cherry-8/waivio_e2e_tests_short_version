package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Rewards.ReservedPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class Reservation extends Modal {

  private static final By BUTTON_RESERVE_IN_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".Details__footer-reserve-btn .ant-btn-primary");
  private static final By BUTTON_RESERVE_WITH_LOADING_IN_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".Details__footer-reserve-btn .ant-btn-loading");

  @Step
  public ReservedPage clickReserveButtonInModalWindow() {
    $(BUTTON_RESERVE_IN_MODAL_WINDOW_LOCATOR).shouldBe(Condition.visible).click();
    $(BUTTON_RESERVE_WITH_LOADING_IN_MODAL_WINDOW_LOCATOR).shouldBe(Condition.disappear);
    $(TITLE_REWARDS_LOCATOR).shouldBe(Condition.visible);
    return new ReservedPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
