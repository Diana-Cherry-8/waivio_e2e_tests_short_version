package Junit5.Tools.HiveUser.WebsiteTest;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Website, Tools")
public class AdministrationsModeratorsAuthoritiesMutedTest extends TestBase {
  static int templateIndex = 0;
  static String websiteName = "testing1234560000";
  static String templateName = properties.getProperty("TemplateNameProd");
  String userName = "x6oc5";

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    draftsPage = topNavigation.clickOnToolsItem();
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    createWebsitePage.clickOnSelectWebsiteInput();
    createWebsitePage.clickOnOptionInSelectWebsiteDropDownMenu(templateIndex);
    createWebsitePage.setWebsiteName(websiteName);
    createWebsitePage.clickOnAgreementCheckbox();
    configurationWebsitePage =
        createWebsitePage.clickOnCreateNewWebsiteButton(websiteName, templateName);
  }

  @Story("Add an administrator for the site")
  @DisplayName("Check administrator is added")
  @Test
  void addAdministratorForWebsite() {
    administratorsPage = toolsLeftSidebar.clickOnAdministratorsWebsite(templateName, websiteName);
    administratorsPage.setUserNameAdministrators(userName);
    administratorsPage.clickButtonAddAdministrators();
    refreshPage();
    String expectedResult = userName;
    String actualResult = administratorsPage.getUserNameInAdministratorsTable();
    assertTrue((actualResult).contains(expectedResult));
  }

  @Story("Add an moderator for the site")
  @DisplayName("Check moderator is added")
  @Test
  void addModeratorForWebsite() {
    moderatorsPage = toolsLeftSidebar.clickOnModeratorsWebsite(templateName, websiteName);
    moderatorsPage.setUserNameModerators(userName);
    moderatorsPage.clickButtonAddModerators();
    refreshPage();
    String expectedResult = userName;
    String actualResult = moderatorsPage.getUserNameInModeratorsTable();
    assertTrue((actualResult).contains(expectedResult));
  }

  @Story("Add an authorities for the site")
  @DisplayName("Check authorities is added")
  @Test
  void addAuthoritiesForWebsite() {
    authoritiesPage = toolsLeftSidebar.clickOnAuthoritiesWebsite(templateName, websiteName);
    authoritiesPage.setUserNameAuthorities(userName);
    authoritiesPage.clickButtonAddAuthorities();
    refreshPage();
    String expectedResult = userName;
    String actualResult = authoritiesPage.getUserNameInModeratorsTable();
    assertTrue((actualResult).contains(expectedResult));
  }

  @Story("Add an user in muted list for the site")
  @DisplayName("Check user is added in muted list")
  @Test
  void addUserInMutedListForWebsite() {
    mutedUsersPage = toolsLeftSidebar.clickOnMutedUsersWebsite(templateName, websiteName);
    mutedUsersPage.setUserNameForMute(userName);
    mutedUsersPage.clickButtonMute();
    refreshPage();
    String expectedResult = userName;
    String actualResult = mutedUsersPage.getUserNameInMuteTable();
    assertTrue((actualResult).contains(expectedResult));
  }

  @AfterAll
  static void delete() {
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    deleteWebsite = manageWebsitePage.clickDelete();
    deleteWebsite.submitDeleteWebsite();
  }
}
