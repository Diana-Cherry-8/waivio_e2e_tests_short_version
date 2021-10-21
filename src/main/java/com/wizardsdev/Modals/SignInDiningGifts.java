package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.PageObjects.FacebookSignPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignInDiningGifts extends Modal{
  //steemconnect page ellements
  private static final By HIVESIGNER_USERNAME_LOCATOR = By.id("username");
  private static final By HIVESIGNER_PASSWORD_LOCATOR = By.id("password");
  private static final By HIVESIGNER_GET_STARTED_BUTTON_LOCATOR = (By.tagName("button"));
  private static final By HIVESIGNER_ENCRYPT_YOUR_KEYS = By.cssSelector(".checkbox");
  private static final By HIVESIGNER_DROPDOWN_USER_LOCATOR = By.cssSelector(".select");
  private static final By BUTTONS_SOCIAL_LOCATOR = By.cssSelector(".SocialButton");

  public SignInDiningGifts() {
    $(BUTTONS_SOCIAL_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void signInWithHiveSigner(String login, String password) {
    $$(BUTTONS_SOCIAL_LOCATOR).get(0).shouldBe(Condition.visible).click();
    if($(HIVESIGNER_DROPDOWN_USER_LOCATOR).exists()) {
      $(HIVESIGNER_GET_STARTED_BUTTON_LOCATOR).click();
    }
    else {
      $(HIVESIGNER_USERNAME_LOCATOR).setValue(login);
      $(HIVESIGNER_PASSWORD_LOCATOR).setValue(password);
      $(HIVESIGNER_ENCRYPT_YOUR_KEYS).click();
      $(HIVESIGNER_GET_STARTED_BUTTON_LOCATOR).click();
    }
  }


  @Step
  public FacebookSignPage clickOnSignInFacebook(boolean newWindow) {
    $$(BUTTONS_SOCIAL_LOCATOR).get(2).shouldBe(Condition.visible).click();
    return new FacebookSignPage(newWindow);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
