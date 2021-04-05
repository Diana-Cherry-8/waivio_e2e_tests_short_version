package Junit5.Website;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.NewSitePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AuthorizationDiningGiftsTest extends TestBase {
  static String websiteNameForDiningGifts = "";
  static String templateNameForDiningGifts = properties.getProperty("TemplateNameProd");
  String facebookEmail = properties.getProperty("FacebookUserEmail00");
  String facebookPassword = properties.getProperty("FacebookUserPass00");

    @Story("Log in dining.gifts")
  @DisplayName("Log in as hive-user, in dining.gifts")
  @Test
  void logInAsHiveUser() {
    newSitePage = NewSitePage.openDiningGifts(websiteNameForDiningGifts, templateNameForDiningGifts);
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    profilePage = header.clickOnAccountIcon();
    refreshPage();
    boolean actualResult = profilePage.isButtonEditProfileExist();
    assertTrue(actualResult);
  }

  @Story("Log in dining.gifts")
  @DisplayName("Log in as guest-user, in dining.gifts")
  @Test
  void logInAsGuestUser() {
    newSitePage = NewSitePage.openDiningGifts(websiteNameForDiningGifts, templateNameForDiningGifts);
   // header.logInWithFacebook(facebookEmail, facebookPassword);
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
