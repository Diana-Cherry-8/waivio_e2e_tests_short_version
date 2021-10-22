package com.wizardsdev.PageObjects.DiningGifts;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.wizardsdev.Context;
import io.qameta.allure.Step;

public class HomePage extends GeneralInfoPage {
  private static final String PAGE_URL = "https://";

  protected HomePage(String siteName, String template) {
    super(siteName, template);
  }

  @Step
  public static HomePage openDiningGiftsHomePage(String siteName, String template) {
    if (!url().equals(Context.getSiteUrl() + siteName  + template)) {
      open(PAGE_URL + siteName + template);
      sleep(2000);
    }
    return new HomePage(siteName, template);
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
