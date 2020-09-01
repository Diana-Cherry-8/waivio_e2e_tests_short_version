package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.DiscoverPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import com.wizardsdev.PageObjects.Tools.NotificationsPageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TopNavigation extends Page {
  private static final By TOP_NAVIGATION_ITEMS_LOCATOR = By.cssSelector(".TopNavigation__item");

  protected TopNavigation() {
    super();
  }

  public static TopNavigation initTopNavigation() {
    return new TopNavigation();
  }

  @Step
  public WebElement getTopNavigationItemByNumber(int itemNumber) {
    return  $$(TOP_NAVIGATION_ITEMS_LOCATOR).get(itemNumber).shouldBe(Condition.visible);
  }

  @Step
  public DiscoverPage clickOnDiscoverItem() {
    getTopNavigationItemByNumber(2).click();
    return new DiscoverPage();
  }

  @Step
  public EligiblePage clickOnRewardsItem() {
    getTopNavigationItemByNumber(1).click();
    return new EligiblePage();
  }

  @Step
  public NotificationsPageTools clickOnToolsItem() {
    $$(TOP_NAVIGATION_ITEMS_LOCATOR).get(4).shouldBe(Condition.appear);
    getTopNavigationItemByNumber(3).click();
    return new NotificationsPageTools();
  }



  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
