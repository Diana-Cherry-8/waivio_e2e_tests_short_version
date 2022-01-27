package com.wizardsdev.PageObjects.Facebook;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class FacebookProfilePage extends Page {
  private static final By USER_LINK_LOCATOR = By.cssSelector("._4kny ._1vp5");
  private static final By ALL_PAGE_LOCATOR = By.cssSelector("._3ixn");
  private static final By GENERAL_PAGE_LOCATOR = By.cssSelector(".iqfcb0g7");
  private static final By TITLE_POST_LOCATOR = By.cssSelector(".d2edcug0.hpfvmrgz.qv66sw1b" +
      ".c1et5uql.b0tq1wua.a8c37x1j.fe6kdd0r.mau55g9w.c8b282yb.keod5gw0.nxhoafnm.aigsh9s9" +
      ".tia6h79c.iv3no6db.a5q79mjw.g1cxx5fr.lrazzd5p.oo9gr5id.hzawbc8m span span");

  public static FacebookProfilePage openFacebookProfilePage() {
    open();
    return new FacebookProfilePage();
  }

  public FacebookProfilePage() {
    $(USER_LINK_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void clickUserTabInHeader() {
    if ($(ALL_PAGE_LOCATOR).exists()) {
      $(ALL_PAGE_LOCATOR).click();
    }
    $(USER_LINK_LOCATOR).click();
  }

  @Step
  public String getTitleForPostFacebook() {
    if ($$(GENERAL_PAGE_LOCATOR).get(2).exists()) {
      $$(GENERAL_PAGE_LOCATOR).get(2).click();
    }
    return $$(TITLE_POST_LOCATOR).get(0).scrollTo().getText();
  }
  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
