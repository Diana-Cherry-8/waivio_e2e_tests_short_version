package com.wizardsdev.PageObjects.Tools;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewAccountsPage extends Page {
  private static final String PAGE_URL = "/new-accounts";

  public NewAccountsPage() {
    super(PAGE_URL);
  }

  @Step
  public NewAccountsPage openNewAccountsPage() {
    if (!url().contains(PAGE_URL)) {
      open(PAGE_URL);
    }
    return new NewAccountsPage();
  }

  @Override
  protected void init() {
  }

  @Override
  protected void parsePage() {
  }
}
