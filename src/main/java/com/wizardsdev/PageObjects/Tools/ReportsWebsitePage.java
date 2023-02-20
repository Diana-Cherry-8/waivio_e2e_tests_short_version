package com.wizardsdev.PageObjects.Tools;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReportsWebsitePage extends Page {
  private static final String PAGE_URL = "/payments";

  public ReportsWebsitePage() {
    super(PAGE_URL);
  }

  @Step
  public ReportsWebsitePage openReportsWebsitePage() {
    if (!url().contains(PAGE_URL)) {
      open(PAGE_URL);
    }
    return new ReportsWebsitePage();
  }


  @Override
  protected void init() {
//        String pageUrl = getCurrentPage();
//        $(MESSAGE_ANY_BOOKMARKS).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
  }

  @Override
  protected void parsePage() {
  }
}
