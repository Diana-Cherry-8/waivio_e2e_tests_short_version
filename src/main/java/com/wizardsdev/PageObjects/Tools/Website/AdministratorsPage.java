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

public class AdministratorsPage extends Page {
  public static final By INPUT_FOR_SEARCH_LOCATOR = By.cssSelector(".ant-select-search__field");
  public static final By BUTTON_ADD_ADMINISTRATORS_LOCATOR =
      By.cssSelector(".WebsitesAdministrators__add-button");
  public static final By ADMINISTRATORS_USER_INFO_LOCATOR =
      By.cssSelector(".WebsitesAdministrators__user-info");
  public static final By BUTTON_DELETE_LOCATOR = By.cssSelector(".icon-delete");
  public static final By USER_IN_DROP_DOWN_LOCATOR = By.cssSelector(".SearchUser");

  public AdministratorsPage(String websiteName, String template) {
    super(Context.getSiteUrl()  + websiteName+ '.' + template + "/administrations");
  }

  @Step
  public static AdministratorsPage openAdministratorsPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl()  + websiteName+ '.' + template + "/administrations")) {
      open(Context.getSiteUrl()  + websiteName+ '.' + template + "/administrations");
    }
    return new AdministratorsPage(websiteName, template);
  }

  @Step
  public void setUserNameAdministrators(String userName) {
    $$(INPUT_FOR_SEARCH_LOCATOR).get(1)
        .shouldBe(Condition.visible)
        .setValue(userName);
    $(USER_IN_DROP_DOWN_LOCATOR).shouldBe(Condition.visible).click();
    $(BUTTON_DELETE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickButtonAddAdministrators() {
    $(BUTTON_ADD_ADMINISTRATORS_LOCATOR).shouldBe(Condition.visible).click();
    $(ADMINISTRATORS_USER_INFO_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public String getUserNameInAdministratorsTable() {
    return $$(ADMINISTRATORS_USER_INFO_LOCATOR).get(0).shouldBe(Condition.visible).getText();
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
