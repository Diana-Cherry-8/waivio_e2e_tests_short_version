package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("New accounts page, Tools")
public class NewAccountsTest extends TestBase {

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Open page")
  @DisplayName("Check new accounts page is opened in Tools")
  @Test
  void openNewAccount() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsHiveUser();
    String expectedResult = "Create new Hive accounts";
    String actualResult = newAccountsPage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Open page")
  @DisplayName("Check hiveonboard/create-account is opened")
  @Test
  void openHiveOnBoardCreateAccount() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsHiveUser();
    hiveOnBoardPage = newAccountsPage.clickOnForFreeLink();
    String expectedResult = "CONTINUE";
    String actualResult = hiveOnBoardPage.getContinueButtonText();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Open page")
  @DisplayName("Check hiveonboard.com, hiveonboard is opened")
  @Test
  void openHiveOnBoard() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsHiveUser();
    hiveOnBoardPage = newAccountsPage.clickOnHiveOnBoard();
    String expectedResult = "LEARN";
    String actualResult = hiveOnBoardPage.getLearnLabelText();
    assertEquals(expectedResult, actualResult);
  }

  @Story("Open page")
  @DisplayName("Check apply link, hiveonboard is opened")
  @Test
  void openHiveOnBoardThoughApplyLink() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsHiveUser();
    hiveOnBoardPage = newAccountsPage.clickOnApply();
    String expectedResult = "LEARN";
    String actualResult = hiveOnBoardPage.getLearnLabelText();
    assertEquals(expectedResult, actualResult);
  }
}
