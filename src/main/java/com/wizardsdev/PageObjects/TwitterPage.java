package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TwitterPage extends Page{
  private static final String PAGE_URL = "/";
  private static final By FIELD_EMAIL_LOCATOR =
      By.cssSelector(".css-1dbjc4n.r-18u37iz.r-1pi2tsx.r-1wtj0ep.r-u8s1d.r-13qz1uu");


  public TwitterPage() {
    super(PAGE_URL);
  }

  @Step
  public static TwitterPage openTwitterPage() {
    if (!url().equals(Context.getSiteUrl())) {
      open(PAGE_URL);
    }
    return new TwitterPage();
  }


  @Step
  public boolean isEmailFieldExist() {
    return $$(FIELD_EMAIL_LOCATOR).get(1).shouldBe(Condition.visible).exists();
  }
  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
