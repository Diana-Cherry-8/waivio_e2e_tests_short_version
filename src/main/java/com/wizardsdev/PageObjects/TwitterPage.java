package com.wizardsdev.PageObjects;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static com.codeborne.selenide.WebDriverRunner.url;


import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class TwitterPage extends Page{
  private static final String PAGE_URL = "/";
  private static final By INPUTS_LOCATOR = By.cssSelector(".r-30o5oe.r-1niwhzg.r-17gur6a.r-1yadl64");
  private static final By BUTTONS_LOG_IN_LOCATOR = By.cssSelector(".css-18t94o4.css-1dbjc4n.r-l5o3uw.r-sdzlij.r-1phboty.r-rs99b7.r-2yi16.r-1qi8awa.r-1ny4l3l.r-ymttw5.r-o7ynqc.r-6416eg.r-lrvibr");
  private static final By BUTTON_TWITTER_PUBLISH_LOCATOR = By.cssSelector(".css-901oao.r-1awozwy." +
      "r-jwli3a.r-6koalj.r-18u37iz.r-16y2uox.r-1qd0xha.r-a023e6.r-b88u0q.r-1777fci.r-rjixqe." +
      "r-dnmrzs.r-bcqeeo.r-q4m81j.r-qvutc0");
  private static final By POSTS_CARD_LOCATOR =
      By.cssSelector(".css-1dbjc4n.r-1iusvr4.r-16y2uox.r-1777fci.r-kzbkwu");
  private static final By MODAL_EDITOR_LOCATOR =
      By.cssSelector(".css-1dbjc4n.r-14lw9ot.r-1867qdf.r-16y2uox.r-1wbh5a2");
  private static final By TREE_DOTS_BUTTON_LOCATORS = By.cssSelector(".css-1dbjc4n.r-xoduu5");
  private static final By DELETE_ITEM_LOCATOR =
      By.cssSelector(".css-901oao.r-daml9f.r-1qd0xha.r-a023e6.r-16dba41.r-rjixqe.r-bcqeeo.r-qvutc0");
  private static final By CONFIRM_DELETE_LOCATOR = By.cssSelector(".css-901oao.r-1awozwy.r-jwli3a." +
      "r-6koalj.r-18u37iz.r-16y2uox.r-1qd0xha.r-a023e6.r-b88u0q.r-1777fci.r" +
      "-rjixqe.r-dnmrzs.r-bcqeeo.r-q4m81j.r-qvutc0");


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
  public void setTwitterUsername(String twitterUsername) {
    $$(INPUTS_LOCATOR).get(0).shouldBe(Condition.visible).setValue(twitterUsername);
  }

  @Step
  public void setTwitterPassword(String twitterPassword) {
    $$(INPUTS_LOCATOR).get(1).shouldBe(Condition.visible).setValue(twitterPassword);
  }

  @Step
  public void clickLogIn() {
    $$(BUTTONS_LOG_IN_LOCATOR).get(1).shouldBe(Condition.visible).click();
  }

  @Step
  public void twitterLogin(String twitterUserName, String twitterPassword) {
    sleep(4000);
    if($$(INPUTS_LOCATOR).get(1).exists()) {
      setTwitterUsername(twitterUserName);
      setTwitterPassword(twitterPassword);
      clickLogIn();
    }
    else {
      $(BUTTON_TWITTER_PUBLISH_LOCATOR).shouldBe(Condition.visible);
    }

  }

  @Step
  public void publishInTwitter() {
    $$(BUTTON_TWITTER_PUBLISH_LOCATOR).get(0).shouldBe(Condition.visible).click();
    sleep(3000);
    $(MODAL_EDITOR_LOCATOR).shouldBe(Condition.disappear);
  }

  @Step
  public String getTitle() {
    refresh();
    sleep(2000);
    return $$(POSTS_CARD_LOCATOR).get(0).shouldBe(Condition.visible).getText();
  }

  @Step
  public void deleteTwitterPost() {
    $$(TREE_DOTS_BUTTON_LOCATORS).get(2).click();
    $(DELETE_ITEM_LOCATOR).shouldBe(Condition.visible).click();
    $$(CONFIRM_DELETE_LOCATOR).get(0).shouldBe(Condition.visible).click();

  }


  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
