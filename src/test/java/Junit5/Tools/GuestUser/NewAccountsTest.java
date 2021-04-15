package Junit5.Tools.GuestUser;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("New accounts page, Tools")
public class NewAccountsTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  static boolean newWindow = true;

  @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
  }

  @Story("Open page")
  @DisplayName("Check new accounts page is opened in Tools")
  @Test
  void openNewAccount() {
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsGuest();
    String expectedResult = "Create new Hive accounts";
    String actualResult = newAccountsPage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }
}