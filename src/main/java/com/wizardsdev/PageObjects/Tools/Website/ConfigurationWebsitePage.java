package com.wizardsdev.PageObjects.Tools.Website;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.Modals.ChooseLogo;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ConfigurationWebsitePage extends Page {
  private static final By BUTTONS_LOCATOR = By.cssSelector(".ant-btn.ant-btn-primary");

  public ConfigurationWebsitePage(String websiteName, String template) {
    super(Context.getSiteUrl()  + websiteName+ '.' + template + "/configuration");
  }

  @Step
  public static ConfigurationWebsitePage openConfigurationPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl()  + websiteName+ '.' + template + "/configuration")) {
      open(Context.getSiteUrl()  + websiteName+ '.' + template + "/configuration");
    }
    return new ConfigurationWebsitePage(websiteName, template);
  }

  @Step
  public ChooseLogo addDesktopLogo() {
    $$(BUTTONS_LOCATOR).get(0).shouldBe(Condition.visible).click();
    return new ChooseLogo();
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