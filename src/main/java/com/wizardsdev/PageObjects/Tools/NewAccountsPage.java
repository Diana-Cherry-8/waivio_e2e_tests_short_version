package com.wizardsdev.PageObjects.Tools;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.HiveOnBoardPage;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewAccountsPage extends Page {
  private static final By LINKS_LOCATOR = By.cssSelector(".VipTicketsSetting a");
  private static final By LINKS_IN_TABLE_LOCATOR = By.cssSelector(".DynamicTable a");

  @Step
  public HiveOnBoardPage clickOnForFreeLink() {
    $$(LINKS_LOCATOR).get(0).shouldBe(Condition.visible).click();
    switchTabWindowToNext();
    sleep(5000);
    return new HiveOnBoardPage();
  }

  @Step
  public HiveOnBoardPage clickOnHiveOnBoard() {
    $$(LINKS_LOCATOR).get(1).shouldBe(Condition.visible).click();
    switchTabWindowToNext();
    return new HiveOnBoardPage();
  }

  @Step
  public HiveOnBoardPage clickOnApply() {
    $$(LINKS_LOCATOR).get(1).shouldBe(Condition.visible).click();
    switchTabWindowToNext();
    return new HiveOnBoardPage();
  }

  @Override
  protected void init() {
  }

  @Override
  protected void parsePage() {
  }
}
