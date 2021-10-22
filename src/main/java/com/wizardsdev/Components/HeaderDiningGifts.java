package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HeaderDiningGifts extends Page {
  private static final By LINKS_HEADER_LOCATOR =
      By.cssSelector(".MainPageHeader__listLink a");
  private static final String PAGE_URL = "/object/";
  private static final By LINK_LOGO_LOCATOR = By.cssSelector(".MainPageHeader__logoLink");


  public HeaderDiningGifts() {
    super();
  }

  public static HeaderDiningGifts initHeaderDiningGifts() {
    return new HeaderDiningGifts();
  }


  @Step
  public ObjectPage clickOnLogo() {
    $(LINK_LOGO_LOCATOR).shouldBe(Condition.visible).click();
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
  public ObjectPage clickReviewsTab() {
    $$(LINKS_HEADER_LOCATOR).get(0).shouldBe(Condition.visible).click();
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
  public ObjectPage clickPartnersLink() {
    $$(LINKS_HEADER_LOCATOR).get(2).shouldBe(Condition.visible).click();
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
  public boolean isLinkCorrect(String objectPermlink, String additionalPartUrl) {
    if (url().contains(PAGE_URL + objectPermlink + additionalPartUrl)) {
      return true;
    }
    System.out.println(url());
    return false;
  }

  @Step
  public boolean isObjectNameCorrect(String objectName, String expectedName) {
    if (objectName.equals(expectedName)) {
      return true;
    }
    System.out.println("Actual result: "+ objectName + "  "+ "Expected result: " + expectedName);
    return false;
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
