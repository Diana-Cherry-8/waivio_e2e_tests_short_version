package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.PageObjects.Facebook.FacebookSignPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SignInPage extends Page {

  private static final By HIVESIGNER_CONTINUE_BUTTON_LOCATOR = By.cssSelector(".btn-blue.mb-2");
  private static final By MODAL_SING_IN_TITLE_LOCATOR = By.className("RedirectedSignIn__title");
  private static final By FACEBOOK_SING_IN_ENABLED_LOCATOR
      = Selectors.byAttribute ("style", "transition: opacity 0.5s ease 0s;");
  private static final By HIVESIGNER_SING_IN_FOR_NEW_SITE_LOCATOR =
      By.cssSelector(".RedirectedSignIn__signin");
  private static final By HIVESIGNER_USERNAME_LOCATOR = By.id("username");
  private static final By HIVESIGNER_PASSWORD_LOCATOR = By.id("password");
  private static final By HIVESIGNER_GET_STARTED_BUTTON_LOCATOR = (By.tagName("button"));
  private static final By HIVESIGNER_ENCRYPT_YOUR_KEYS = By.cssSelector("input[type='checkbox']");

  public SignInPage() {
    $(MODAL_SING_IN_TITLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void signInWithHiveSignerForNewSite(String login, String password) {
    $(HIVESIGNER_SING_IN_FOR_NEW_SITE_LOCATOR).click();
    $(HIVESIGNER_CONTINUE_BUTTON_LOCATOR).shouldBe(Condition.visible);
    if($(HIVESIGNER_PASSWORD_LOCATOR).exists()) {
      $(HIVESIGNER_CONTINUE_BUTTON_LOCATOR).click();
      $(HIVESIGNER_USERNAME_LOCATOR).setValue(login);
      $(HIVESIGNER_PASSWORD_LOCATOR).setValue(password);
      $(HIVESIGNER_ENCRYPT_YOUR_KEYS).click();
      $(HIVESIGNER_GET_STARTED_BUTTON_LOCATOR).click();
    }
    else {
      $(HIVESIGNER_CONTINUE_BUTTON_LOCATOR).click();
    }
  }

  @Step
  public FacebookSignPage clickOnSignInFacebook(boolean newWindow) {
    $(FACEBOOK_SING_IN_ENABLED_LOCATOR).shouldBe(Condition.visible);
    sleep(1000);
    $(FACEBOOK_SING_IN_ENABLED_LOCATOR).click();
    return new FacebookSignPage(newWindow);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
