package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$$;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.NotificationsPage;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FeedLeftBar extends Page {

  private static final By SIDE_BAR_ITEMS_LINK_LOCATOR = By.cssSelector(".collapsible-block__item a");

  public static FeedLeftBar initFeedLeftBar() {
    return new FeedLeftBar();
  }

  public void clickOnSideBarItemByName(String itemName){
    $$(SIDE_BAR_ITEMS_LINK_LOCATOR).findBy(Condition.text(itemName)).click();
  }

  public void clickOnSideBarItemByIndex(int index){
    $$(SIDE_BAR_ITEMS_LINK_LOCATOR).get(index).click();
  }

  @Step
  public void clickOnTrendingItem() {
    clickOnSideBarItemByIndex(0);
  }

  @Step
  public void clickOnHotItem() {
    clickOnSideBarItemByIndex(1);
  }

  @Step
  public void clickOnNewItem() {
    clickOnSideBarItemByIndex(2);
  }

  @Step
  public NotificationsPage clickOnNotificationItem() {
    clickOnSideBarItemByName("Notifications");
    return  new NotificationsPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
