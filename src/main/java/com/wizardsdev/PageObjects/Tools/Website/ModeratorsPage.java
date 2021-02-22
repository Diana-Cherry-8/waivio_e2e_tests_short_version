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

public class ModeratorsPage extends Page {
  public static final By INPUT_MODERATORS_SEARCH_LOCATOR =
      By.cssSelector(".WebsiteModerators__search-user input");
  public static final By BUTTON_ADD_MODERATORS_LOCATOR =
      By.cssSelector(".WebsiteModerators__add-button");
  public static final By MODERATORS_USER_INFO_LOCATOR =
      By.cssSelector(".WebsitesAdministrators__user");
  public static final By BUTTON_DELETE_LOCATOR = By.cssSelector(".icon-delete");
  public static final By USER_IN_DROP_DOWN_LOCATOR = By.cssSelector(".SearchUser");

  public ModeratorsPage(String websiteName, String template) {
    super(Context.getSiteUrl()  + websiteName+ '.' + template + "/moderators");
  }

  @Step
  public static ModeratorsPage openModeratorsPage(String websiteName, String template) {
    if (!url().contains(Context.getSiteUrl()  + websiteName+ '.' + template + "/moderators")) {
      open(Context.getSiteUrl()  + websiteName+ '.' + template + "/moderators");
    }
    return new ModeratorsPage(websiteName, template);
  }

  @Step
  public void setUserNameModerators(String userName) {
    $(INPUT_MODERATORS_SEARCH_LOCATOR).shouldBe(Condition.visible).setValue(userName);
    $(USER_IN_DROP_DOWN_LOCATOR).shouldBe(Condition.visible).click();
    $(BUTTON_DELETE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickButtonAddModerators() {
    $(BUTTON_ADD_MODERATORS_LOCATOR).shouldBe(Condition.visible).click();
    $(MODERATORS_USER_INFO_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public String getUserNameInModeratorsTable() {
    return $$(MODERATORS_USER_INFO_LOCATOR).get(0).shouldBe(Condition.visible).getText();
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
