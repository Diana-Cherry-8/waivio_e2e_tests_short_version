package com.wizardsdev.PageObjects;


import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.ex.ElementNotFound;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {
  public static final By TITLE_REWARDS_LOCATOR = By.cssSelector(".ant-breadcrumb-link");
  private static final By TITLE_TOOLS_LOCATOR = By.cssSelector(".center h1");
  protected static final By NAME_OBJECT_LOCATOR = By.cssSelector(".ObjectHeader__text");

  public static final By MODAL_DIMMER_LOCATOR = By.cssSelector(".modals.dimmer");
  private static final By LOADER_DIMMER_LOCATOR = By.cssSelector(".anticon-loading");
  private static final By USERNAME_LOCATOR = By.cssSelector(".UserHeader__row.UserHeader__handle");

  protected static final By INPUT_VALIDATION_MESSAGE_LOCATOR = By.className("is-field__validation");
  protected static final By TOP_NAVIGATION_OBJECT_PAGE_LOCATOR = By.cssSelector(".ObjectMenu__item");

  public static final long ONE_DAY_IN_MILLISECONDS = 86400000;

  private static final ThreadLocal<String> currentPage = new ThreadLocal<>();

  protected Page(String pageUrl) {
    currentPage.set(pageUrl);
    init();
    parsePage();
  }

  protected Page() {
    init();
  }

  protected abstract void init();

  protected abstract void parsePage();

  public static String getCurrentPage() {
    return Context.getSiteUrl() + currentPage.get();
  }

  protected static WebDriverWait waiter;


  //  Click methods
  @Step
  public void clickOnElementByAction(By locator) {
    SelenideElement element = $(locator);
    clickOnElementByAction(element);
  }

  @Step
  public void clickOnElementByAction(SelenideElement element) {
    actions().moveToElement(element).click(element).perform();
  }

  //  Waiting methods
  @Step
  public void waitForDisappearModalDimmer() {
    $(MODAL_DIMMER_LOCATOR).should(Condition.disappear);
  }

  @Step
  public void waitForInvisibilityLoaderDimmer() {
    $(LOADER_DIMMER_LOCATOR).should(Condition.disappear);
  }

  // Methods for scrolling
  @Step
  public SelenideElement scrollToElement(SelenideElement element) {
    executeJavaScript("arguments[0].scrollIntoView(true);", element);
    return element;
  }

  @Step
  public SelenideElement scrollToElement(By locator) {
    SelenideElement element = $(locator);
    return scrollToElement(element);
  }

  @Step
  public void scrollToBottom(By locator) {
    SelenideElement element = $(locator);
    executeJavaScript("arguments[0].scrollBy(0, 320)", element);
  }

  @Step
  public void scrollToTop(By locator) {
    SelenideElement element = $(locator);
    executeJavaScript("arguments[0].scrollBy(0, -320)", element);
  }

  //  Service methods
  @Step
  public boolean isElementPresent(SelenideElement element) {
    boolean isPresents = true;
    try {
      element.exists();
    } catch (ElementNotFound ignored) {
      isPresents = false;
    }
    return isPresents;
  }

  @Step
  public boolean isElementPresent(SelenideElement element, By locator) {
    boolean isPresents = true;
    try {
      element.findElement(locator);
    } catch (ElementNotFound ignored) {
      isPresents = false;
    }
    return isPresents;
  }

  /**
   * @param dateInNumberFormat date in "MM/dd/yyyy" format
   * @return date in format "MMMMMMMMM d, yyyy hh:mm aa"
   */
  @Step
  public String convertDate(String dateInNumberFormat) {
    long dateInMilliseconds = 0;
    try {
      dateInMilliseconds = new SimpleDateFormat("MM/dd/yyyy hh:mm aa").parse(dateInNumberFormat).getTime();
    } catch (ParseException e) {
      System.err.println("Incorrect date format");
      e.printStackTrace();
    }
    DateFormat format = new SimpleDateFormat("MMMMMMMMM d, yyyy hh:mm aa", Locale.US);
    return format.format(dateInMilliseconds);
  }

  @Step
  public void switchTabWindowToNext() {
    ArrayList<String> tabsWindows = new ArrayList<>(getWebDriver().getWindowHandles());
    int i = 1;
    i += tabsWindows.stream().takeWhile(tabId -> !tabId.equals(getWebDriver().getWindowHandle())).count();
    getWebDriver().switchTo().window(tabsWindows.get(i));
  }

  @Step
  public void switchTabWindowToPrevious() {
    ArrayList<String> tabsWindows = new ArrayList<>(getWebDriver().getWindowHandles());
    int i = tabsWindows.size() - 1;
    i -= tabsWindows.stream().takeWhile(tabId -> !tabId.equals(getWebDriver().getWindowHandle())).count();
    getWebDriver().switchTo().window(tabsWindows.get(i));
  }

  @Step
  public void closeTabWindow() {
    closeWindow();
    switchTo().window(0);
  }

  @Step
  public String getCurrentDay(String dateFormat) {
    long date = new Date().getTime();
    DateFormat format = new SimpleDateFormat(dateFormat, Locale.US);
    return format.format(date);
  }

  public String addDaysToCurrentDay(String dateFormat, int daysCount) {
    long date = new Date().getTime();
    date += ONE_DAY_IN_MILLISECONDS * daysCount;
    DateFormat format = new SimpleDateFormat(dateFormat, Locale.US);
    return format.format(date);
  }

  public boolean isTwoListsHaveSameItem(List<String> firstList, List<String> secondList) {
    return secondList.stream().anyMatch(firstList::contains);
  }

  @Step
  public String getTitleRewards() {
    sleep(2000);
    return $(TITLE_REWARDS_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getTitleTools() {
    return $(TITLE_TOOLS_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getObjectName() {
    return $(NAME_OBJECT_LOCATOR).shouldBe(Condition.visible).getText();
  }

  @Step
  public String getUserNameValue() {
    return $(USERNAME_LOCATOR)
            .shouldBe(Condition.visible)
            .getText()
            .replace("@","")
            .replace(" (guest)", "");
  }

  @Step
  public void waiter() {
    waiter = new WebDriverWait(WebDriverRunner.getWebDriver(), 20);
  }
}
