package Junit5.Login;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LoginTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  String testFBGuestUserUsername = properties.getProperty("FacebookUserName00");

  @Feature("Login")
  @Story("Login")
  @DisplayName("Check hive signer login")
  @Test
  public void loginWithHiveSigner() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    userPage = header.clickOnAccountIcon();
    assertEquals(getUserLogin(), userPage.getUserNameValue());
  }

  @Feature("Login")
  @Story("Login")
  @DisplayName("Check facebook login")
  @Test
  public void logInWithFacebook() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword);
    userPage = header.clickOnAccountIcon();
    assertEquals(testFBGuestUserUsername, userPage.getUserNameValue());
  }

  @AfterEach
  public void logOut() {
    header.logOut();
  }

}
