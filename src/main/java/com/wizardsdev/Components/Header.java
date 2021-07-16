package com.wizardsdev.Components;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selectors;
import com.codeborne.selenide.ElementsCollection;
import com.wizardsdev.Modals.SignIn;
import com.wizardsdev.Modals.UseCookies;
import com.wizardsdev.PageObjects.*;
import com.wizardsdev.PageObjects.Objects.PageObjectPage;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import com.wizardsdev.PageObjects.Tools.SettingsPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Header extends Page {

  private static final By ANT_MENU_ITEMS_LOCATOR =
      By.cssSelector(".ant-menu-item");
  private static final By ACCOUNT_ICON_LOCATOR =
      By.cssSelector(".Topnav__user");
  private static final By DROPDOWN_ITEM_CHANGE_LANGUAGE_LOCATOR =
      By.cssSelector(".LanguageSettings__option");
  private static final By INPUT_SEARCH_LOCATOR =
      By.cssSelector(".ant-select-search__field");
  private static final By SEARCH_ITEMS_OBJECT_USER_LOCATOR =
      By.cssSelector(".Topnav__search-autocomplete");
  private static final By SEARCH_RESULT_OBJECT_TYPE_LOCATOR =
      By.className("Topnav__search-content-small");
  private static final By TILES_LOCATOR =
      Selectors.byAttribute("marker", "searchSelectBar");
  private static final By NOTIFICATIN_CONTENT_LOCATOR =
      By.cssSelector(".Notifications__content");
  private static final By SEE_ALL_NOTIFICATIONS_LOCATOR =
      By.cssSelector(".Notifications__footer a");
  private static final By LOGO_LOCATOR =
      By.className("Topnav__brand");
  private static final By USER_MENU_TRIANGLE_LOCATOR =
      By.cssSelector(".Topnav__menu--icon a");
  private static final By USER_MENU_ITEMS_LOCATOR =
      By.cssSelector(".PopoverMenuItem:not(.PopOverMenuItem__full-screen-hidden) a");
  private static final By LOADER_SIGN_IN_MODAL_LOCATOR = By.className("ModalSignIn__loading");
  private static final By LOADER_SIGN_IN_PAGE_MODAL_LOCATOR = By.className("RedirectedSignIn__loading");

  public Header() {
    super();
  }

  public static Header initHeader() {
    return new Header();
  }

  @Step
  public void logInWithHiveSigner(String login, String password) {
    SignIn signIn = clickOnSingIn();
    signIn.signInWithHiveSigner(login, password);
    UseCookies.closeModalWindowUseCookies();
    $(USER_MENU_TRIANGLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void logInWithHiveSignerForNewSite(String login, String password) {
    SignInPage signIn = clickOnSingInNewSite();
    NewSitePage.closeCookiesWindow();
    signIn.signInWithHiveSignerForNewSite(login, password);
    $(USER_MENU_TRIANGLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void logInWithFacebook(String email, String password, boolean newWindow) {
    SignIn signIn = clickOnSingIn();
    FacebookSignPage facebookSignPage = signIn.clickOnSignInFacebook(newWindow);
    facebookSignPage.setLogin(email);
    facebookSignPage.setPassword(password);
    facebookSignPage.clickOnLogIn();
    $(LOADER_SIGN_IN_MODAL_LOCATOR).shouldBe(Condition.visible).shouldBe(Condition.disappear);
    $(USER_MENU_TRIANGLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public void logInWithFacebookNewSite(String email, String password, boolean newWindow) {
    SignInPage signIn = clickOnSignInPage();
    NewSitePage.closeCookiesWindow();
    FacebookSignPage facebookSignPage = signIn.clickOnSignInFacebook(newWindow);
    facebookSignPage.setLogin(email);
    facebookSignPage.setPassword(password);
    facebookSignPage.clickOnLogIn();
    $(LOADER_SIGN_IN_PAGE_MODAL_LOCATOR).shouldBe(Condition.visible).shouldBe(Condition.disappear);
    UseCookies.closeModalWindowUseCookies();
    $(USER_MENU_TRIANGLE_LOCATOR).shouldBe(Condition.visible);
  }

  @Step
  public SignInPage clickOnSignInPage() {
    $(ANT_MENU_ITEMS_LOCATOR).shouldBe(Condition.visible).click();
    return new SignInPage();
  }

  @Step
  public SignIn clickOnSingIn() {
    $(ANT_MENU_ITEMS_LOCATOR).shouldBe(Condition.visible).click();
    return new SignIn();
  }

  @Step
  public SignInPage clickOnSingInNewSite() {
    $(ANT_MENU_ITEMS_LOCATOR).shouldBe(Condition.visible).click();
    return new SignInPage();
  }



  @Step
  public void logOut() {
    $(USER_MENU_TRIANGLE_LOCATOR).shouldBe(Condition.visible).click();
    $$(USER_MENU_ITEMS_LOCATOR).get($$(USER_MENU_ITEMS_LOCATOR).size()-1).click();
  }

  @Step
  public SettingsPage goToUserSettingPage() {
    $(USER_MENU_TRIANGLE_LOCATOR).click();
    $$(USER_MENU_ITEMS_LOCATOR).get($$(USER_MENU_ITEMS_LOCATOR).size()-2).click();
    return new SettingsPage();
  }

  @Step
  public PostsPage clickOnAccountIcon() {
    $(ACCOUNT_ICON_LOCATOR).shouldBe(Condition.visible).click();
    return new PostsPage(getUserNameValue());
  }

  @Step
  public EditorPage clickOnWritePostIcon() {
    $$(ANT_MENU_ITEMS_LOCATOR).get(0).shouldBe(Condition.visible).click();
    return new EditorPage();
  }

  @Step
  public void clickOnChangeLanguageIcon() {
    $$(ANT_MENU_ITEMS_LOCATOR).get(1).shouldBe(Condition.visible);
    $$(ANT_MENU_ITEMS_LOCATOR).get(1).click();
  }

  @Step
  public void chooseLanguage(String language) {
    $$(DROPDOWN_ITEM_CHANGE_LANGUAGE_LOCATOR).findBy(Condition.text(language)).click();
  }

  @Step
  public String expectedLanguage(String language) {
    String myFeedTabName;
    switch (language) {
      case "English": myFeedTabName = "MY FEED";
      break;
      case "Indonesian": myFeedTabName = "UMPAN SAYA";
      break;
      case "Malay": myFeedTabName = "MAKANAN SAYA";
      break;
      case "Catalan": myFeedTabName = "EL MEU FEED";
        break;
      case "Czech": myFeedTabName = "MŮJ PŘÍSPĚVEK";
        break;
      case "Danish": myFeedTabName = "MIT FEED";
        break;
      case "German": myFeedTabName = "NEUIGKEITEN";
        break;
      case "Estonian": myFeedTabName = "MINU VOOG";
        break;
      case "Spanish": myFeedTabName = "MI FEED";
        break;
      case "Filipino": myFeedTabName = "ANG AKING PAKAIN";
        break;
      case "French": myFeedTabName = "MON FLUX";
        break;
      case "Croatian": myFeedTabName = "MOJA FEED";
        break;
      case "Italian": myFeedTabName = "IL MIO FEDE";
        break;
      case "Hungarian": myFeedTabName = "SAJÁT HÍRCSATORNA";
        break;
      case "Polish": myFeedTabName = "MÓJ WKŁAD";
        break;
      case "Portuguese": myFeedTabName = "MEU FEED";
        break;
      case "Russian": myFeedTabName = "МОЯ ЛЕНТА";
        break;
      case "Ukrainian": myFeedTabName = "МОЇ НОВИНИ";
        break;
      case "Arabic": myFeedTabName = "موجز بلدي";
        break;
      case "Hindi": myFeedTabName = "एरा भोजन";
        break;
      case "Korean": myFeedTabName = "나의 먹이";
        break;
      case "Japanese": myFeedTabName = "マイフィード";
        break;
      case "Afrikaans": myFeedTabName = "MY VOER";
        break;
      case "Chinese": myFeedTabName = "我的饲料";
        break;
      default: myFeedTabName = "Something went wrong";
    }
    return myFeedTabName;
  }

  public void inputTextToSearch(String textToSearch) {
    $(INPUT_SEARCH_LOCATOR).clear();
    $(INPUT_SEARCH_LOCATOR).setValue(textToSearch);
  }

  public boolean isSearchResultAllObjectsUsersHasText(String searchText) {
    sleep(1500);
    ElementsCollection searchResultObjectsUsers = $$(SEARCH_ITEMS_OBJECT_USER_LOCATOR);
    boolean result = true;
    for (WebElement webElement:searchResultObjectsUsers) {
      if (!webElement.getText().contains(searchText)){
        result = false;
      }
    }
    return result;
  }

  public boolean isSearchResultAllTilesObjectsUsersHasText(String searchText) {
    $(SEARCH_ITEMS_OBJECT_USER_LOCATOR).shouldBe(Condition.visible);
    ElementsCollection searchResultTiles = $$(TILES_LOCATOR);
    boolean result = true;
    for (int i = 0; i < searchResultTiles.size() ; i++) {
      $(SEARCH_ITEMS_OBJECT_USER_LOCATOR).shouldBe(Condition.visible);
      result = isSearchResultAllObjectsUsersHasText(searchText);
      if (i < searchResultTiles.size()-1) {
        searchResultTiles.get(i+1).click();
      }
    }
    return result;
  }

  public void clickOnNotificationIcon() {
    $$(ANT_MENU_ITEMS_LOCATOR).get(2).shouldBe(Condition.visible);
    $$(ANT_MENU_ITEMS_LOCATOR).get(1).shouldBe(Condition.visible).click();
  }

  public boolean isNotificationPopUpOpened() {
    return $(SEE_ALL_NOTIFICATIONS_LOCATOR).shouldBe(Condition.visible).exists();
  }

  public boolean isNotificationEmpty() {
    sleep(1000);
    $(INPUT_SEARCH_LOCATOR).shouldBe(Condition.visible);
    return $(NOTIFICATIN_CONTENT_LOCATOR).getText().contains("You currently have no notifications.");
  }

  public NotificationsPage clickSeeAllNotifications() {
    $(SEE_ALL_NOTIFICATIONS_LOCATOR).shouldBe(Condition.visible).click();
    return new NotificationsPage();
  }

  public FeedPage clickOnLogo() {
    $(LOGO_LOCATOR).click();
    return new FeedPage();
  }

  public boolean isUserLogOuted() {
    return $$(ANT_MENU_ITEMS_LOCATOR).get(2).getText().equals("Log in");
  }

  public PageObjectPage clickOnTheFirstItemFromSearch () {
    $$(SEARCH_ITEMS_OBJECT_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
    return new PageObjectPage();
  }

  public PageObjectPage clickOnTheSecondItemFromSearch () {
    $$(SEARCH_ITEMS_OBJECT_USER_LOCATOR).get(1).shouldBe(Condition.visible).click();
    return new PageObjectPage();
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
