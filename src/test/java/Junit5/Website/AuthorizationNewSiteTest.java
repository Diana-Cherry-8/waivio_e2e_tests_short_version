package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.codeborne.selenide.Modal;
import com.wizardsdev.Modals.UseCookies;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.NewSitePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationNewSiteTest extends TestBase {
  static int templateIndex = 0;
  static String websiteName = "checkingauthorizationonthenewsite1";
  static String templateName = properties.getProperty("TemplateNameProd");
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");

  static String hiveUserEmail = properties.getProperty("UserLogin04");
  static String hivePasswordPassword = properties.getProperty("LoginPassword04");
  boolean newWindow = true;

  @BeforeAll
  static void createAndOpenSite() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(hiveUserEmail, hivePasswordPassword);
    draftsPage = topNavigation.clickOnToolsItem();
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    createWebsitePage.clickOnSelectWebsiteInput();
    createWebsitePage.clickOnOptionInSelectWebsiteDropDownMenu(templateIndex);
    createWebsitePage.setWebsiteName(websiteName);
    createWebsitePage.clickOnAgreementCheckbox();
    configurationWebsitePage =
        createWebsitePage.clickOnCreateNewWebsiteButton(websiteName, templateName);
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    manageWebsitePage.clickCheckboxSiteActivation();
    newSitePage = NewSitePage.openNewSitePage(websiteName, templateName);
    NewSitePage.closeCookiesWindow();
  }

  @Story("Log in new site")
  @DisplayName("Log in as hive-user, in new site")
  @Test
  void logInAsHiveUser() {
    header.logInWithHiveSignerForNewSite(hiveUserEmail, hivePasswordPassword);
    profilePage = header.clickOnAccountIcon();
    refreshPage();
    boolean actualResult = profilePage.isButtonEditProfileExist();
    assertTrue(actualResult);
  }

  @Story("Log in new site")
  @DisplayName("Log in as guest-user, new site")
  @Test
  void logInAsGuestUser() {
    header.logInWithFacebookNewSite(facebookEmail, facebookPassword, newWindow);
    profilePage = header.clickOnAccountIcon();
    refreshPage();
    boolean actualResult = profilePage.isButtonEditProfileExist();
    assertTrue(actualResult);
  }

  @AfterEach
  void logout(){
    header.logOut();
  }

  @AfterAll
  static void delete() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    manageWebsitePage.clickCheckboxSiteForDeactivation();
    deleteWebsite = manageWebsitePage.clickDelete();
    deleteWebsite.submitDeleteWebsite();
  }
}
