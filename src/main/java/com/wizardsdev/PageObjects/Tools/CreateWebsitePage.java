package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Tools.Website.ConfigurationWebsitePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class CreateWebsitePage extends Page {
  private static final String PAGE_URL = "/create";
  private static final By INPUTS_LOCATOR = By.cssSelector(".ant-input");
  private static final By OPTIONS_IN_SELECT_WEBSITE_DROP_DOWN_LOCATOR =
      By.cssSelector(".ant-select-dropdown-menu-item");
  private static final By AVAILABLE_WEBSITE_NAME_LOCATOR = By.cssSelector(".CreateWebsite__available");
  private static final By CHECKBOX_HOSTING_AGREEMENT_LOCATOR = By.cssSelector(".ant-checkbox");
  private static final By BUTTON_CREATE_NEW_WEBSITE_LOCATOR = By.cssSelector(".ant-btn-primary");

  public CreateWebsitePage() {
    super(PAGE_URL);
  }

  @Step
  public CreateWebsitePage openCreateWebsitePage() {
    if (!url().contains(PAGE_URL)) {
      open(PAGE_URL);
    }
    return new CreateWebsitePage();
  }

  @Step
  public void clickOnSelectWebsiteInput() {
    $$(INPUTS_LOCATOR).get(1).shouldBe(Condition.visible).click();
  }

  @Step
  public void clickOnOptionInSelectWebsiteDropDownMenu(int templateNumber) {
    $$(OPTIONS_IN_SELECT_WEBSITE_DROP_DOWN_LOCATOR).get(templateNumber).shouldBe(Condition.visible).click();
  }

  @Step
  public void setWebsiteName(String websiteName) {
    $$(INPUTS_LOCATOR).get(2).shouldBe(Condition.visible).setValue(websiteName);
    $(AVAILABLE_WEBSITE_NAME_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickOnAgreementCheckbox() {
    $(CHECKBOX_HOSTING_AGREEMENT_LOCATOR).shouldBe(Condition.visible).click();
  }

  @Step
  public ConfigurationWebsitePage clickOnCreateNewWebsiteButton(String template, String websiteName) {
    $(BUTTON_CREATE_NEW_WEBSITE_LOCATOR).shouldBe(Condition.visible).click();
    sleep(15000);
    return new ConfigurationWebsitePage(websiteName, template);
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
