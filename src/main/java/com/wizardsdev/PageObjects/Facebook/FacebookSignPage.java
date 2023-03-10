package com.wizardsdev.PageObjects.Facebook;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FacebookSignPage extends Page {
  private static final By LOGIN_INPUT_LOCATOR = By.cssSelector("#email");
  private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#pass");
  private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector(".uiButton");
  private static final By POST_IN_EDITOR_LOCATOR = By.cssSelector(".unclickable");
  private static final By TITLE_COOKIES_LOCATOR = By.id("consent_cookies_title");
  private static final By BUTTON_ALLOW_COOKIES_LOCATOR =
          By.cssSelector("button[data-testid='cookie-policy-manage-dialog-accept-button']");

  public FacebookSignPage(boolean newWindow) {
    if(newWindow){
      switchTo().window(1);
    }
    else {
      switchTo().window(0);
    }
  }

  @Step
  public void loginWithFacebook(String login, String password) {
    sleep(1000);
    if($(LOGIN_INPUT_LOCATOR).exists()) {
      closeCookies();
      setLogin(login);
      setPassword(password);
      clickOnLogIn();
    }
    else {
      $(POST_IN_EDITOR_LOCATOR).shouldBe(Condition.visible);
    }
  }

  @Step
  public void setLogin(String login){
    $(LOGIN_INPUT_LOCATOR).setValue(login);
  }

  @Step
  public void setPassword(String password){
    $(PASSWORD_INPUT_LOCATOR).setValue(password);
  }

  @Step
  public void clickOnLogIn() {
    $(LOGIN_BUTTON_LOCATOR).click();
    switchTo().window(0);
  }

  public void closeCookies() {
    if($(TITLE_COOKIES_LOCATOR).exists()){
      $(BUTTON_ALLOW_COOKIES_LOCATOR).shouldBe(Condition.visible).click();
    }
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
