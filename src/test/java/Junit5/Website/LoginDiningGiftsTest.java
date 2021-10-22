package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LoginDiningGiftsTest extends TestBase {
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  String testFBGuestUserUsername = properties.getProperty("FacebookUserName00");
  static boolean newWindow = true;

  static String websiteName = "";
  static String templateName = "dining.gifts";

  @BeforeAll
  static void openSite() {
    homePage = HomePage.openDiningGiftsHomePage(websiteName, templateName);
  }

  @Feature("Dining.gifts. Login")
  @Story("Login")
  @DisplayName("Check hive signer login")
  @Test
  public void loginWithHiveSigner() {
    signInDiningGifts = homePage.openSignInModalWindowDiningGifts();
    signInDiningGifts.signInWithHiveSigner(getUserLogin(), getUserPassword());
    profilePage = header.clickOnAccountIcon();
    assertEquals(getUserLogin(), profilePage.getUserNameValue());
  }

  @Feature("Dining.gifts. Login")
  @Story("Login")
  @DisplayName("Check facebook login")
  @Test
  public void logInWithFacebook() {
    signInDiningGifts = homePage.openSignInModalWindowDiningGifts();
    facebookSignPage = signInDiningGifts.clickOnSignInFacebook(newWindow);
    facebookSignPage.loginWithFacebook(facebookEmail, facebookPassword);
    profilePage = header.clickOnAccountIcon();
    assertEquals(testFBGuestUserUsername, profilePage.getUserNameValue());
  }

  @AfterEach
  void logout() {
    header.logOut();
  }

}

