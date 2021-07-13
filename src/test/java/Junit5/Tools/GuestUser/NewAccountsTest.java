package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("New accounts page, Tools")
public class NewAccountsTest extends TestBase {
  static String facebookEmail = properties.getProperty("FacebookUserEmail00");
  static String facebookPassword = properties.getProperty("FacebookUserPass00");
  static boolean newWindow = true;

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
  }

  @Story("Open page")
  @DisplayName("Check new accounts page is opened in Tools")
  @Test
  void openNewAccount() {
    feedPage = FeedPage.openFeedPage();
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsGuest();
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
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsGuest();
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
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsGuest();
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
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsGuest();
    hiveOnBoardPage = newAccountsPage.clickOnApply();
    String expectedResult = "LEARN";
    String actualResult = hiveOnBoardPage.getLearnLabelText();
    assertEquals(expectedResult, actualResult);
  }
}