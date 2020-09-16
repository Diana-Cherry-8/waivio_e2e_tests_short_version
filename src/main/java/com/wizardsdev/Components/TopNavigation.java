package com.wizardsdev.Components;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.AboutPage;
import com.wizardsdev.PageObjects.DiscoverPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Rewards.EligiblePage;
import com.wizardsdev.PageObjects.Tools.DraftsPage;
import com.wizardsdev.PageObjects.Tools.NotificationsPageTools;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;

public class TopNavigation extends Page {
  private static final By TOP_NAVIGATION_ITEMS_LOCATOR = By.cssSelector(".TopNavigation__item");
  private static final By CENTER_LOCATOR = By.cssSelector(".center");

  protected TopNavigation() {
    super();
  }

  public static TopNavigation initTopNavigation() {
    return new TopNavigation();
  }

  @Step
  public WebElement getTopNavigationItemByIndex(int index) {
    return  $$(TOP_NAVIGATION_ITEMS_LOCATOR).get(index).shouldBe(Condition.visible);
  }

  @Step
  public DiscoverPage clickOnDiscoverItem() {
    getTopNavigationItemByIndex(2).click();
    return new DiscoverPage();
  }

  @Step
  public EligiblePage clickOnRewardsItem() {
    getTopNavigationItemByIndex(1).click();
    sleep(6000);
    return new EligiblePage();
  }

  @Step
  public DraftsPage clickOnToolsItem() {
    $$(TOP_NAVIGATION_ITEMS_LOCATOR).get(4).shouldBe(Condition.appear);
    getTopNavigationItemByIndex(3).click();
    return new DraftsPage();
  }

  @Step
  public AboutPage clickOnAboutItem() {
    $$(TOP_NAVIGATION_ITEMS_LOCATOR).get(4).shouldBe(Condition.visible);
    getTopNavigationItemByIndex(4).click();
    return new AboutPage();
  }



  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
