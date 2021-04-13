package Junit5.Tools.HiveUser;

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

   @BeforeEach
  void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
  }

  @Story("Open page")
  @DisplayName("Check new accounts page is opened in Tools")
  @Test
  void openNewAccount() {
    draftsPage = topNavigation.clickOnToolsItem();
    newAccountsPage = toolsLeftSidebar.clickOnNewAccountsAsHiveUser();
    String expectedResult = "Create new Hive accounts";
    String actualResult = newAccountsPage.getTitleTools();
    assertEquals(expectedResult, actualResult);
  }
}
