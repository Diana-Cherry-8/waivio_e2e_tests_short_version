package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.Modals.SignInDiningGifts;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class NewSitePage extends Page{
  private static final String PAGE_URL = "https://";
  private static final By OBJECTS_MARKS_ON_MAP_LOCATOR = By.cssSelector(".pigeon-click-block");
  private static final By WEBSITE_DESKTOP_LOGO_LOCATOR = By.cssSelector(".WebsiteBody__logo");
  private static final By BUTTON_MY_LOCATION_LOCATOR = By.cssSelector(".MapConfigurationControl__locateGPS");
  private static final By BUTTONS_FOR_ZOOM_LOCATOR = By.cssSelector(".WebsiteBodyControl__zoom");
  private static final By SEARCH_PANEL_LOCATOR = By.cssSelector(".SearchAllResult__toggle-button");
  private static final By OBJECT_CARD_NAME_LOCATOR = By.cssSelector(".ObjectCardView__name");
  private static final By NAVIGATION_SEARCH_TABS_LOCATOR = By.cssSelector(".SearchAllResult__type");
  private static final By CARD_TAG_LOCATOR = By.cssSelector(".ObjectCardView__tag-text");
  private static final By USERS_CARDS_LOCATOR = By.cssSelector(".UserCard");
  private static final By BUTTON_CLOSE_FOR_COOKIES_WINDOW = By.cssSelector(".ant-modal-close-x");
  private static final By BUTTON_SIGN_IN_DINING_GIFTS_LOCATOR =
      By.cssSelector(".ModalSignIn__link-type");


  public NewSitePage(String siteName, String template) {
    super(PAGE_URL + siteName + template);
  }

  @Step
  public static NewSitePage openNewSitePage(String siteName, String template) {
    if (!url().equals(Context.getSiteUrl() + siteName + '.' + template)) {
      open(PAGE_URL + siteName + '.' + template);
      sleep(2000);
    }
    return new NewSitePage(siteName, template);
  }

  @Step
  public static NewSitePage openDiningGiftsMap(String siteName, String template) {
    if (!url().equals(Context.getSiteUrl() + siteName  + template + "/map")) {
      open(PAGE_URL + siteName + template + "/map");
      sleep(2000);
    }
    return new NewSitePage(siteName, template);
  }

  @Step
  public static NewSitePage openDiningGiftsHomePage(String siteName, String template) {
    if (!url().equals(Context.getSiteUrl() + siteName  + template)) {
      open(PAGE_URL + siteName + template);
      sleep(2000);
    }
    return new NewSitePage(siteName, template);
  }

  @Step
  public SignInDiningGifts openSignInModalWindowDiningGifts() {
    $(BUTTON_SIGN_IN_DINING_GIFTS_LOCATOR).shouldBe(visible).click();
    return new SignInDiningGifts();
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
    $(OBJECT_CARD_NAME_LOCATOR).shouldBe(visible);
  }

  @Step
  public void clickDrinkTab() {
    $$(NAVIGATION_SEARCH_TABS_LOCATOR).get(2).shouldBe(Condition.visible).click();
    $(OBJECT_CARD_NAME_LOCATOR).shouldBe(visible);
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

  @Step
  public ObjectPage clickOnDesktopLogo() {
    $(WEBSITE_DESKTOP_LOGO_LOCATOR).shouldBe(Condition.visible).click();
    return new ObjectPage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Step
  public static void closeCookiesWindow() {
    if($(BUTTON_CLOSE_FOR_COOKIES_WINDOW).exists()) {
      $(BUTTON_CLOSE_FOR_COOKIES_WINDOW).click();
    }
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
