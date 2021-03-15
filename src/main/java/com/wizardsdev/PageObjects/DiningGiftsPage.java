package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class DiningGiftsPage extends Page{
  private static final String PAGE_URL = "https://dining.gifts";
  private static final By OBJECTS_MARKS_ON_MAP_LOCATOR = By.cssSelector(".pigeon-click-block");
  private static final By WEBSITE_DESKTOP_LOGO_LOCATOR = By.cssSelector(".WebsiteBody__logo");
  private static final By BUTTON_MY_LOCATION_LOCATOR = By.cssSelector(".MapOS__locateGPS-button");
  private static final By BUTTONS_FOR_ZOOM_LOCATOR = By.cssSelector(".WebsiteBodyControl__zoom");
  private static final By SEARCH_PANEL_LOCATOR = By.cssSelector(".SearchAllResult__toggle-button");
  private static final By OBJECT_CARD_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");
  private static final By NAVIGATION_SEARCH_TABS_LOCATOR = By.cssSelector(".SearchAllResult__type");
  private static final By CARD_TAG_LOCATOR = By.cssSelector(".ObjectCardView__tag-text");
  private static final By USERS_CARDS_LOCATOR = By.cssSelector(".UserCard");

  public DiningGiftsPage() {
    super(PAGE_URL);
  }

  @Step
  public static DiningGiftsPage openDiningGiftsPage() {
    if (!url().equals(Context.getSiteUrl())) {
      open(PAGE_URL);
    }
    return new DiningGiftsPage();
  }

  @Step
  public boolean areObjectsMarksExist() {
    return $(OBJECTS_MARKS_ON_MAP_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public boolean isWebsiteDesktopLogoExist() {
    return $(WEBSITE_DESKTOP_LOGO_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public boolean isButtonMyLocationExist() {
    return $(BUTTON_MY_LOCATION_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public boolean areButtonsForZoomExist() {
    return $(BUTTONS_FOR_ZOOM_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public void clickSearchPanel() {
    if($(OBJECT_CARD_NAME_LOCATOR).exists()) {
    $(OBJECT_CARD_NAME_LOCATOR).shouldBe(Condition.visible);
    }
    else if ($(USERS_CARDS_LOCATOR).exists()){
      $(USERS_CARDS_LOCATOR).shouldBe(Condition.visible);
    }
    else {
      $(SEARCH_PANEL_LOCATOR).shouldBe(Condition.visible).click();
    }
  }

  @Step
  public boolean isSearchPanelOpen() {
    return $(OBJECT_CARD_NAME_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Step
  public void clickRestaurantTab() {
    $$(NAVIGATION_SEARCH_TABS_LOCATOR).get(0).shouldBe(Condition.visible).click();
  }

  @Step
  public void clickDishTab() {
    $$(NAVIGATION_SEARCH_TABS_LOCATOR).get(1).shouldBe(Condition.visible).click();
  }

  @Step
  public void clickDrinkTab() {
    $$(NAVIGATION_SEARCH_TABS_LOCATOR).get(2).shouldBe(Condition.visible).click();
  }

  @Step
  public void clickUsersTab() {
    $$(NAVIGATION_SEARCH_TABS_LOCATOR).get(3).shouldBe(Condition.visible).click();
  }

  @Step
  public String getTagName() {
    $(OBJECT_CARD_NAME_LOCATOR).shouldBe(visible);
    return $(CARD_TAG_LOCATOR).shouldBe(visible).getText();
  }

  @Step
  public boolean areUsersListOpen() {
    return $(USERS_CARDS_LOCATOR).shouldBe(Condition.visible).exists();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
