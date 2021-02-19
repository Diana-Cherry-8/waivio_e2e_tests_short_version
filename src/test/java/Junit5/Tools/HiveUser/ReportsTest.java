package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Reports page, Tools")
public class ReportsTest extends TestBase {

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Open page")
  @DisplayName("Check reports page is opened in Tools")
  @Test
  void openReports() {
    draftsPage = topNavigation.clickOnToolsItem();
    reportsWebsitePage = toolsLeftSidebar.clickOnReportsWebsite();
    String expectedResult = "Reports for websites:";
    String actualResult = reportsWebsitePage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }
}
