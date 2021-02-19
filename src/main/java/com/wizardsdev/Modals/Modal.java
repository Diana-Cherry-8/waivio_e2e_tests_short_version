package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public abstract class Modal extends Page {
  private static final By BUTTON_SUBMIT_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".ant-btn-primary");
  private static final By MODAL_WINDOW_LOCATOR = By.cssSelector(".ant-modal-content");

  //Selectors
  public static final By IMG_EXIT_LOCATOR = By.cssSelector("[title = 'Close']");
  public static final By TEXT_DESCRIPTION_LOCATOR = By.className("description");
  public static final By HEADER_LOCATOR = By.className("is-custom-modal-header__body-text");
  public static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector("button[data-button = 'submit']");
  public static final By BUTTON_CANCEL_LOCATOR = By.cssSelector("button[data-button = 'cancel']");

  protected Modal() {
    super();
  }

  @Step
  public void closeModal() {
    $(IMG_EXIT_LOCATOR).click();
    waitForDisappearModalDimmer();
  }
  
  @Step
  public void clickOnSubmitButton(Boolean waitForCloseModal) {
    $(BUTTON_SUBMIT_LOCATOR).click();
    if (waitForCloseModal) {
      waitForDisappearModalDimmer();
    }
  }
  
  @Step
  public void clickOnCancelButton(Boolean waitForCloseModal) {
    $(BUTTON_CANCEL_LOCATOR).click();
    if (waitForCloseModal) {
      waitForDisappearModalDimmer();
    }
  }

  @Step
  public void submitDeleteWeb() {
    $$(BUTTON_SUBMIT_MODAL_WINDOW_LOCATOR).get(1).shouldBe(Condition.visible).click();
    $(MODAL_WINDOW_LOCATOR).shouldBe(Condition.disappear);
  }
  
  @Step
  public String getDescription() {
    return $(TEXT_DESCRIPTION_LOCATOR).getText();
  }



}
