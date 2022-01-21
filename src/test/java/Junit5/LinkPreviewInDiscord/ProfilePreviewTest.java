package Junit5.LinkPreviewInDiscord;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.Discord.LoginPageDiscord;
import com.wizardsdev.PageObjects.Discord.MainPageDiscord;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfilePreviewTest extends TestBase {
  static String email = "jasecarmel@gmail.com";
  static String password = "qweqwe123QWE";
  static String name = "grampo";
  String app = "Waivio";
  static String description;
  static String username;
  static String link;
  static String discordChannelLink = "https://discord.com/channels/933278946710134884/933278946710134887";

  @BeforeAll
  static void actions() {
    //take url from waivio
    feedPage = FeedPage.openFeedPage();
    pageObjectPage = header.generalMethodForSearch(name);
    link = header.getSiteUrlString();
    description = pageObjectPage.getUserDescription();
    username = pageObjectPage.getUserName();

    //discord login
    loginPageDiscord = LoginPageDiscord.openDiscordPage();
    loginPageDiscord.loginDiscord(email, password);
    mainPageDiscord = MainPageDiscord.openMainPage(discordChannelLink); // open Preview channels

    //insert link to discord
    mainPageDiscord.setLink(link);
  }

  @Story("Preview. Profile")
  @DisplayName("Check preview is loaded")
  @Test
  public void checkPreviewLoaded() {
    assertTrue (mainPageDiscord.isPreviewLoaded(), "Preview didn't load");
  }

  @Story("Preview. Profile")
  @DisplayName("Check app name is waivio")
  @Test
  public void checkAppName() {
    String actualAppName = mainPageDiscord.getAppName();
    assertEquals(app, actualAppName, "App name not found");
  }

  @Story("Preview. Profile")
  @DisplayName("Check username is correct")
  @Test
  public void checkUsername() {
    String actualUserName = mainPageDiscord.getUserNameFromPreview();
    assertEquals(username, actualUserName, "Username not found");
  }

  @Story("Preview. Profile")
  @DisplayName("Check description is correct")
  @Test
  public void checkDescription() {
    String actualDescription = mainPageDiscord.getDescriptionFromPreview();
    assertEquals(description, actualDescription, "Description not found");
  }

  @Story("Preview. Profile")
  @DisplayName("Check link is correct")
  @Test
  public void checkLink() {
    String actualLink = mainPageDiscord.getLinkFromPreview();
    assertEquals(link, actualLink, "Link not found");
  }

  @AfterAll
  static void deleteLink() {
    mainPageDiscord.deleteLinkInDiscord();
  }
}
