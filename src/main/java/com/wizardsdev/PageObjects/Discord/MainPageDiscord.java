package com.wizardsdev.PageObjects.Discord;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class MainPageDiscord extends Page {
  private static final By TEXTAREA_LOCATOR = By.cssSelector("div[data-slate-object='block']");
  private static final By APP_NAME_LOCATOR = By.cssSelector(".embedProvider-1GSN0c");
  private static final By USER_NAME_LOCATOR = By.cssSelector(".message-2CShn3 .anchor-1MIwyf.anchorUnderlineOnHover-2qPutX.embedTitleLink-1QbYA-");
  private static final By DESCRIPTION_LOCATOR = By.cssSelector(".embedDescription-1DrJxZ");
  private static final By PREVIEW_CARDS_LOCATOR = By.cssSelector(".grid-1aWVsE");
  private static final By FULL_MESSAGE_LOCATOR = By.cssSelector(".message-2CShn3");
  private static final By BUTTON_ACTIONS_LOCATOR = By.cssSelector(".button-3bklZh");
  private static final By ITEMS_IN_DROP_DOWN_LOCATOR = By.cssSelector(".item-1OdjEX");
  private static final By BUTTON_SUBMIT_IN_DELETE_MODAL_WINDOW_LOCATOR =
      By.cssSelector(".button-f2h6uQ.lookFilled-yCfaCM.colorRed-rQXKgM");
  private static final By LINK_LOCATOR_IN_MESSAGE_LOCATOR = By.cssSelector(".anchor-1MIwyf");

  public static MainPageDiscord openMainPage(String discordLink) {
    open(discordLink);
    return new MainPageDiscord();
  }

  public MainPageDiscord() {
    $(TEXTAREA_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void setLink (String link) {
    $(TEXTAREA_LOCATOR).shouldBe(Condition.visible).click();
    $(TEXTAREA_LOCATOR).shouldBe(Condition.visible).sendKeys(link);
    $(TEXTAREA_LOCATOR).shouldBe(Condition.visible).pressEnter();
  }

  @Step
  public boolean isPreviewLoaded () {
    sleep(2000);
    return $(PREVIEW_CARDS_LOCATOR).exists();
  }

  @Step
  public void hoverFullMessage() {
    $(FULL_MESSAGE_LOCATOR).hover().click();
  }

  @Step
  public void clickTreeDotsButton() {
    $$(BUTTON_ACTIONS_LOCATOR).get(3).shouldBe(Condition.visible).click();
  }

  @Step
  public void clickItemDeleteInDropDown() {
    $$(ITEMS_IN_DROP_DOWN_LOCATOR).findBy(Condition.exactText("Delete Message"))
        .shouldBe(Condition.visible).click();
  }

  @Step
  public void clickSubmitDelete() {
    $(BUTTON_SUBMIT_IN_DELETE_MODAL_WINDOW_LOCATOR).shouldBe(Condition.visible).click();
  }

  @Step
  public void deleteLinkInDiscord() {
    hoverFullMessage();
    clickTreeDotsButton();
    clickItemDeleteInDropDown();
    clickSubmitDelete();
  }

  @Step
  public String getAppName () {
    return $(APP_NAME_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getUserNameFromPreview() {
    return $(USER_NAME_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getDescriptionFromPreview() {
    return $(DESCRIPTION_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getShortDescriptionFromPreview() {
    String cutDescription = $(DESCRIPTION_LOCATOR).shouldBe(Condition.visible).getText().substring(0, 120);
    String withoutNewLineDescription = cutDescription.replace(System.getProperty("line.separator"), " ");
    return withoutNewLineDescription;
  }

  @Step
  public String getLinkFromPreview() {
    return $$(LINK_LOCATOR_IN_MESSAGE_LOCATOR).get(2).shouldBe(Condition.visible).getText();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
