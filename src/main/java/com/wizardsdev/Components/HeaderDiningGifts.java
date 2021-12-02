package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.PageObjects.DiningGifts.HomePage.openDiningGiftsHomePage;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import com.wizardsdev.PageObjects.Objects.ObjectPage;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import java.util.Objects;
import org.openqa.selenium.By;

public class HeaderDiningGifts extends Page {
  private static final By LINKS_HEADER_LOCATOR =
      By.cssSelector(".MainPageHeader__listLink a");
  private static final String PAGE_URL = "https://";
  private static final By LINK_LOGO_LOCATOR = By.cssSelector(".MainPageHeader__logoLink");


  public HeaderDiningGifts() {
    super();
  }

  public static HeaderDiningGifts initHeaderDiningGifts() {
    return new HeaderDiningGifts();
  }


  @Step
  public HomePage clickOnLogo(String siteName, String template) {
    if (!$(LINK_LOGO_LOCATOR).exists()) {
      openDiningGiftsHomePage(siteName, template);
    } else {
      $(LINK_LOGO_LOCATOR).shouldBe(Condition.visible).click();
    }
    return new HomePage(siteName, template);
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
    $$(LINKS_HEADER_LOCATOR).get(1).shouldBe(Condition.visible).click();
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
  public boolean isLinkCorrect(String template, String objectPermlink, String additionalPartUrl) {
    if(!(Objects.equals(objectPermlink, ""))) {
      if (url().contains(PAGE_URL + template + "/object/"+ objectPermlink + additionalPartUrl)) {
        return true;
      }
      System.out.println("Expected result: "+ PAGE_URL + template + "/object/" + objectPermlink + additionalPartUrl);
      System.out.println("  Actual result: " + url());
      return false;
    } if (url().contains(PAGE_URL + template + objectPermlink + additionalPartUrl)) {
      return true;
    }
    System.out.println("Expected result: "+ PAGE_URL + template + objectPermlink + additionalPartUrl);
    System.out.println("  Actual result: " + url());
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

  @Step
  public String getLink() {
    return url();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
