package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Modals.DeleteWebsite;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ManageWebsitePage extends Page {
  private static final String PAGE_URL = "/manage";
  private static final By BUTTON_DELETE_LOCATOR = By.cssSelector(".DynamicTable__delete");
  private static final By CHECKBOX_SITE_ACTIVATION_LOCATOR = By.cssSelector(".ant-checkbox");
  private static final By CHECKBOX_ACTIVATED_LOCATOR = By.cssSelector(".ant-checkbox-checked");

  public ManageWebsitePage() {
    super(PAGE_URL);
  }

  @Step
  public ManageWebsitePage openManageWebsitePage() {
    if (!url().contains(PAGE_URL)) {
      open(PAGE_URL);
    }
    return new ManageWebsitePage();
  }

  @Step
  public DeleteWebsite clickDelete() {
    $(BUTTON_DELETE_LOCATOR).shouldBe(Condition.visible).click();
    return new DeleteWebsite();
  }

  @Step
  public void clickCheckboxSiteActivation() {
    $(CHECKBOX_SITE_ACTIVATION_LOCATOR).shouldBe(Condition.visible).click();
    $(CHECKBOX_ACTIVATED_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickCheckboxSiteForDeactivation() {
    $(CHECKBOX_ACTIVATED_LOCATOR).shouldBe(Condition.visible).click();
    $(CHECKBOX_SITE_ACTIVATION_LOCATOR).shouldBe(Condition.visible);
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