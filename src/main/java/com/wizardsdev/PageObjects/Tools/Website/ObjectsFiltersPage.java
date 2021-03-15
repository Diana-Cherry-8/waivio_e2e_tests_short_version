package com.wizardsdev.PageObjects.Tools.Website;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;

public class ObjectsFiltersPage extends Page {

  public ObjectsFiltersPage(String websiteName, String template) {
    super(Context.getSiteUrl() + websiteName + '.' + template + "/objects-filters");
  }

  @Step
  public static ObjectsFiltersPage openObjectsFiltersPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl() + websiteName + '.' + template + "/objects-filters")) {
      open(Context.getSiteUrl() + websiteName + '.' + template + "/objects-filters");
    }
    return new ObjectsFiltersPage(websiteName, template);
  }

  @Override
  protected void init() {
//        String pageUrl = getCurrentPage();
//        $(TITLE_REWARDS_LOCATOR).shouldBe(Condition.exactText("Website configuration"));
//        assert url().equals(pageUrl) : "Invalid page is opened";
  }

  @Override
  protected void parsePage() {
  }
}