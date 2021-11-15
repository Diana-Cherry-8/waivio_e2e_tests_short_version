package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Create page, Tools")
public class CreateWebsiteTest extends TestBase {
  int templateIndex = 0;
  String websiteName = "test1234unique";
  String templateName = "dining.gifts";

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    draftsPage = topNavigation.clickOnToolsItem();
  }

  @Story("Open page")
  @DisplayName("Check create page is opened in Tools")
  @Test
  void openCreate() {
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    refreshPage();
    String expectedResult = "Create new website";
    String actualResult = createWebsitePage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Create website")
  @DisplayName("Check website is created")
  @Test
  void createWebsite() {
    createWebsitePage = toolsLeftSidebar.clickOnCreateWebsite();
    createWebsitePage.clickOnSelectWebsiteInput();
    createWebsitePage.clickOnOptionInSelectWebsiteDropDownMenu(templateIndex);
    createWebsitePage.setWebsiteName(websiteName);
    createWebsitePage.clickOnAgreementCheckbox();
    configurationWebsitePage = createWebsitePage.clickOnCreateNewWebsiteButton(websiteName, templateName);
    String expectedTitle = "Website configuration";
    String actualTitle = configurationWebsitePage.getTitleTools();
    assertEquals(expectedTitle, actualTitle);
  }

  @AfterAll
  static void delete() {
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    deleteWebsite = manageWebsitePage.clickDelete();
    deleteWebsite.submitDeleteWebsite();
  }
}
