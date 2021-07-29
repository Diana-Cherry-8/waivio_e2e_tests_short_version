package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.NewSitePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationDiningGiftsTest extends TestBase {
  static String websiteNameForDiningGifts = "";
  static String templateNameForDiningGifts = properties.getProperty("TemplateNameProd");
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");
  boolean newWindow = true;

  @Disabled
  @BeforeEach
  void openDiningGifts() {
    newSitePage = NewSitePage.openDiningGifts(websiteNameForDiningGifts, templateNameForDiningGifts);
    NewSitePage.closeCookiesWindow();
  }

  @Disabled
  @Story("Log in dining.gifts")
  @DisplayName("Log in as hive-user, in dining.gifts")
  @Test
  void logInAsHiveUser() {
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    profilePage = header.clickOnAccountIcon();
    refreshPage();
    boolean actualResult = profilePage.isButtonEditProfileExist();
    assertTrue(actualResult);
  }

  @Disabled
  @Story("Log in dining.gifts")
  @DisplayName("Log in as guest-user, in dining.gifts")
  @Test
  void logInAsGuestUser() {
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    profilePage = header.clickOnAccountIcon();
    refreshPage();
    boolean actualResult = profilePage.isButtonEditProfileExist();
    assertTrue(actualResult);
  }

  @AfterEach
  void logout(){
      header.logOut();
  }
}
