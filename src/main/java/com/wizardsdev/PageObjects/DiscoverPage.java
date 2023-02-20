package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DiscoverPage extends Page {

  private static final By LEFT_SIDEBAR_ITEM_LOCATOR = By.className("sidenav-discover-objects__item");
  private static final By MAP_FILTER_LOCATOR = By.className("MapOS");
  private static final By SIDEBAR_CONTENT_BLOCK = By.className("SidebarContentBlock");
  private static final By CARD_TAG_LOCATOR = By.cssSelector(".ObjectCardView__tag-text");
  private static  final By TAB_HASHTAGS_ALL_PAGE_LOCATOR = By.cssSelector(".hashtags-tab");

  public static DiscoverPage openDiscoverPage(String objectType) {
    open(Context.getSiteUrl() + '/' + objectType);
    return new DiscoverPage();
  }

  @Step
  public void clickOnLeftSidebarItemByIndex(int itemIndex) {
    $$(LEFT_SIDEBAR_ITEM_LOCATOR).get(itemIndex).click();
  }

  @Step
  public void clickOnRestaurantItem() {
    clickOnLeftSidebarItemByIndex(2);
  }

  @Step
  public boolean isMapFilterExist() {
    return $(MAP_FILTER_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public boolean isTopRatedFilterExist() {
    return $(Selectors.withText("Filters")).shouldBe(Condition.visible).exists();
  }

  @Step
  public String getTagName() {
    $(SIDEBAR_CONTENT_BLOCK).shouldBe(visible);
    return $(CARD_TAG_LOCATOR).shouldBe(visible).getText();
  }

  @Step
  public boolean isHashtagsTabExist() {
    return $(TAB_HASHTAGS_ALL_PAGE_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
