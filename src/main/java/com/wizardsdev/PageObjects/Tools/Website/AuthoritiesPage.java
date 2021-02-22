package com.wizardsdev.PageObjects.Tools.Website;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class AuthoritiesPage extends Page {
  public static final By INPUT_FOR_SEARCH_LOCATOR = By.cssSelector(".ant-select-search__field");
  public static final By BUTTON_ADD_AUTHORITIES_LOCATOR =
      By.cssSelector(".WebsitesAuthorities__add-button");
  public static final By AUTHORITIES_USER_INFO_LOCATOR =
      By.cssSelector(".WebsitesAuthorities__user");
  public static final By BUTTON_DELETE_LOCATOR = By.cssSelector(".icon-delete");
  public static final By USER_IN_DROP_DOWN_LOCATOR = By.cssSelector(".SearchUser");

  public AuthoritiesPage(String websiteName, String template) {
    super(Context.getSiteUrl()  + websiteName+ '.' + template + "/authorities");
  }

  @Step
  public static AuthoritiesPage openAuthoritiesPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl()  + websiteName+ '.' + template + "/authorities")) {
      open(Context.getSiteUrl()  + websiteName+ '.' + template + "/authorities");
    }
    return new AuthoritiesPage(websiteName, template);
  }

  @Step
  public void setUserNameAuthorities(String userName) {
    $$(INPUT_FOR_SEARCH_LOCATOR).get(1)
        .shouldBe(Condition.visible)
        .setValue(userName);
    $(USER_IN_DROP_DOWN_LOCATOR).shouldBe(Condition.visible).click();
    $(BUTTON_DELETE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickButtonAddAuthorities() {
    $(BUTTON_ADD_AUTHORITIES_LOCATOR).shouldBe(Condition.visible).click();
    $(AUTHORITIES_USER_INFO_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public String getUserNameInModeratorsTable() {
    return $$(AUTHORITIES_USER_INFO_LOCATOR).get(0).shouldBe(Condition.visible).getText();
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
