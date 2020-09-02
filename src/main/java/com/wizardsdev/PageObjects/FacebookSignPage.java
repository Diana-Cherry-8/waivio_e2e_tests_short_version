package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.Selenide.switchTo;

import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FacebookSignPage extends Page {
  private static final By LOGIN_INPUT_LOCATOR = By.cssSelector("#email");
  private static final By PASSWORD_INPUT_LOCATOR = By.cssSelector("#pass");
  private static final By LOGIN_BUTTON_LOCATOR = By.cssSelector("#u_0_0");

  public FacebookSignPage() {
    switchTo().window(1);
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
//    sleep(6000);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
