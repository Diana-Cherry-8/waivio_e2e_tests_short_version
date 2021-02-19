package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Manage page, Tools")
public class ManageTest extends TestBase {

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Open page")
  @DisplayName("Check manage page is opened in Tools")
  @Test
  void openManage() {
    draftsPage = topNavigation.clickOnToolsItem();
    manageWebsitePage = toolsLeftSidebar.clickOnManageWebsite();
    refreshPage();
    String expectedResult = "Manage websites";
    String actualResult = manageWebsitePage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }
}