package com.wizardsdev.PageObjects.DiningGifts;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

import com.wizardsdev.Modals.SignInDiningGifts;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public abstract class GeneralInfoPage extends Page {
  private static final String PAGE_URL = "https://";
  private static final By BUTTON_CLOSE_FOR_COOKIES_WINDOW = By.cssSelector(".ant-modal-close-x");
  private static final By BUTTON_SIGN_IN_DINING_GIFTS_LOCATOR =
      By.cssSelector(".ModalSignIn__link-type");


  protected GeneralInfoPage(String siteName, String template) {
    super(PAGE_URL + siteName + template);
  }

  @Step
  public SignInDiningGifts openSignInModalWindowDiningGifts() {
    $(BUTTON_SIGN_IN_DINING_GIFTS_LOCATOR).shouldBe(visible).click();
    return new SignInDiningGifts();
  }



  @Step
  public static void closeCookiesWindow() {
    if($(BUTTON_CLOSE_FOR_COOKIES_WINDOW).exists()) {
      $(BUTTON_CLOSE_FOR_COOKIES_WINDOW).click();
    }
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
