package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

public class UseCookies extends Modal{
  private static final By BUTTON_CROSS_CLOSE_MODAL_WINDOW = By.cssSelector(".ant-modal-close");

  public static void closeModalWindowUseCookies() {
    sleep(2000);
    if ($(BUTTON_CROSS_CLOSE_MODAL_WINDOW).exists()) {
      $(BUTTON_CROSS_CLOSE_MODAL_WINDOW).shouldBe(Condition.visible).click();
    }
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
