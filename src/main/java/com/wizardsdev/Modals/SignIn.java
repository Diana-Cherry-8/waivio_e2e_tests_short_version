package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.PageObjects.FacebookSignPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignIn extends Modal{
  //steemconnect page ellements
  private static final By HIVESIGNER_CONTINUE_BUTTON_LOCATOR = By.cssSelector(".btn-blue.mb-2");
  private static final By HIVESIGNER_USERNAME_LOCATOR = By.id("username");
  private static final By HIVESIGNER_PASSWORD_LOCATOR = By.id("password");
  private static final By HIVESIGNER_GET_STARTED_BUTTON_LOCATOR = (By.tagName("button"));
  private static final By HIVESIGNER_ENCRYPT_YOUR_KEYS = By.cssSelector("input[type='checkbox']");

  private static final By MODAL_SING_IN_TITLE_LOCATOR = By.className("ModalSignIn__title");
  private static final By HIVESIGNER_SING_IN_LOCATOR = By.className("ModalSignIn__signin");
  private static final By GOOGLE_SING_IN_LOCATOR = By.className("ModalSignUp__social-btn");
  private static final By FACEBOOK_SING_IN_ENABLED_LOCATOR
      = Selectors.byAttribute ("style", "transition: opacity 0.5s ease 0s;");


  public SignIn() {
    $(MODAL_SING_IN_TITLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void signInWithHiveSigner(String login, String password) {
    $(HIVESIGNER_SING_IN_LOCATOR).click();
    $(HIVESIGNER_CONTINUE_BUTTON_LOCATOR).click();
    $(HIVESIGNER_USERNAME_LOCATOR).setValue(login);
    $(HIVESIGNER_PASSWORD_LOCATOR).setValue(password);
    $(HIVESIGNER_ENCRYPT_YOUR_KEYS).click();
    $(HIVESIGNER_GET_STARTED_BUTTON_LOCATOR).click();
  }


  @Step
  public FacebookSignPage clickOnSignInFacebook() {
    $(FACEBOOK_SING_IN_ENABLED_LOCATOR).shouldBe(Condition.visible).click();
    return new FacebookSignPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
