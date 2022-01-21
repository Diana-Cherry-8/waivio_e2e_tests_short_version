package com.wizardsdev.PageObjects.Discord;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPageDiscord extends Page {
  private static final By INPUT_EMAIL_LOCATOR = By.cssSelector("input[type='text']");
  private static final By INPUT_PASSWORD_LOCATOR = By.cssSelector("input[type='password']");
  private static final By BUTTONS_LOCATOR = By.cssSelector(".contents-3ca1mk");
  private static final By TITLE_CHANNEL_LOCATOR = By.cssSelector(".children-3xh0VB");

  public static LoginPageDiscord openDiscordPage() {
    open("https://discord.com/login");
    return new LoginPageDiscord();
  }

  public LoginPageDiscord() {
    $(INPUT_EMAIL_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void loginDiscord(String email, String password) {
    $(INPUT_EMAIL_LOCATOR).shouldBe(Condition.visible).setValue(email);
    $(INPUT_PASSWORD_LOCATOR).shouldBe(Condition.visible).setValue(password);
    $$(BUTTONS_LOCATOR).get(1).click();
    $(TITLE_CHANNEL_LOCATOR).shouldBe(Condition.visible);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
