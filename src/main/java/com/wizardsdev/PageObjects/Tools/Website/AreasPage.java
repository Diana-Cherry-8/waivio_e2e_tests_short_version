package com.wizardsdev.PageObjects.Tools.Website;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AreasPage extends Page {
  private static final By BUTTON_CHOSE_AREA_LOCATOR = By.cssSelector(".MapWrap__new-aria-btn");

  public AreasPage(String websiteName, String template) {
    super(Context.getSiteUrl() + websiteName + '.' + template + "/objects");
  }

  @Step
  public static AreasPage openAreasPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl() + websiteName + '.' + template + "/objects")) {
      open(Context.getSiteUrl() + websiteName + '.' + template + "/objects");
    }
    return new AreasPage(websiteName, template);
  }

  @Step
  public void clickClickChoseAreaButton() {
    sleep(2000);
    $(BUTTON_CHOSE_AREA_LOCATOR).shouldBe(Condition.visible).click();
    sleep(2000);

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

