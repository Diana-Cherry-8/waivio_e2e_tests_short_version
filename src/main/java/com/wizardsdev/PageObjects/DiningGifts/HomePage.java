package com.wizardsdev.PageObjects.DiningGifts;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomePage extends GeneralInfoPage {
  private static final String PAGE_URL = "https://";
  private static final By BUTTONS_LOCATOR = By.cssSelector(".WebsiteMainPage__button");
  private static final By LINKS_CITY_LOCATOR = By.cssSelector(".DistrictsCard__city");
  private static final By TITLES_NEARBY_LOCATOR = By.cssSelector(".NearByCard__title");

  protected HomePage(String siteName, String template) {
    super(siteName, template);
  }

  @Step
  public static HomePage openDiningGiftsHomePage(String siteName, String template) {
    if (!url().equals(Context.getSiteUrl() + siteName  + template)) {
      open(PAGE_URL + siteName + template);
      sleep(2000);
    }
    return new HomePage(siteName, template);
  }

  @Step
  public MapPage clickOnHomePageToOpenMap(String siteName, String template, int index) {
    scrollToElement($$(BUTTONS_LOCATOR).get(index));
    $$(BUTTONS_LOCATOR).get(index).shouldBe(Condition.visible).click();
    return new MapPage(siteName, template);
  }

  @Step
  public MapPage clickOnCityLinkOnGeographicBlock(String siteName, String template, int index) {
    scrollToElement($$(LINKS_CITY_LOCATOR).get(index));
    $$(LINKS_CITY_LOCATOR).get(index).shouldBe(Condition.visible).click();
    return new MapPage(siteName, template);
  }

  @Step
  public MapPage clickOnNearbyTitleLinkOnDishBlock(String siteName, String template, int index) {
    scrollToElement($$(TITLES_NEARBY_LOCATOR).get(index));
    $$(TITLES_NEARBY_LOCATOR).get(index).shouldBe(Condition.visible).click();
    return new MapPage(siteName, template);
  }

  @Step
  public ObjectPage clickOnLearnMoreInStepsBlock(int index) {
    scrollToElement($$(BUTTONS_LOCATOR).get(index));
    $$(BUTTONS_LOCATOR).get(index).shouldBe(Condition.visible).click();
    return new ObjectPage() {
      @Override
      protected void init() {

      }

      @Override
      protected void parsePage() {

      }
    };
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
