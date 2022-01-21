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

public class ObjectPreviewTest extends TestBase {
  static String discordChannelLink = "https://discord.com/channels/933278946710134884/933278946710134887";
  static String email = "jasecarmel@gmail.com";
  static String password = "qweqwe123QWE";
  static String objectName = "Bottoms Bar & Grill at Sun Peaks Resort";
  String app = "Waivio";
  static String objectDescription;
  static String objectAddress;
  static String link;

  @BeforeAll
  static void actions() {
    //take url from waivio
    feedPage = FeedPage.openFeedPage();
    pageObjectPage = header.generalMethodForSearch(objectName);
    link = header.getSiteUrlString();
    objectDescription = pageObjectPage.getObjectDescription();
    objectName = pageObjectPage.getObjectName();
    objectAddress = pageObjectPage.getObjectAddress();

    //discord login
    loginPageDiscord = LoginPageDiscord.openDiscordPage();
    loginPageDiscord.loginDiscord(email, password);
    mainPageDiscord = MainPageDiscord.openMainPage(discordChannelLink); // open Preview channels

    //insert link to discord
    mainPageDiscord.setLink(link);
  }

  @Story("Preview. Object restaurant")
  @DisplayName("Check preview is loaded")
  @Test
  public void checkPreviewLoaded() {
    assertTrue (mainPageDiscord.isPreviewLoaded(), "Preview didn't load");
  }

  @Story("Preview. Object restaurant")
  @DisplayName("Check app name is waivio")
  @Test
  public void checkAppName() {
    String actualAppName = mainPageDiscord.getAppName();
    assertEquals(app, actualAppName, "App name is not correct");
  }

  @Story("Preview. Object restaurant")
  @DisplayName("Check object name is correct")
  @Test
  public void checkObjectName() {
    String actualUserName = mainPageDiscord.getUserNameFromPreview();
    assertTrue(actualUserName.contains(objectName), "Object name is not correct");
  }

  @Story("Preview. Object restaurant")
  @DisplayName("Check description is correct")
  @Test
  public void checkObjectDescription() {
    String actualDescription = mainPageDiscord.getDescriptionFromPreview();
    assertTrue(actualDescription.contains(objectDescription), "Object description is not correct");
  }

  @Story("Preview. Profile")
  @DisplayName("Check link is correct")
  @Test
  public void checkLink() {
    String actualLink = mainPageDiscord.getLinkFromPreview();
    assertEquals(link, actualLink, "Link not found");
  }

  @Story("Preview. Object restaurant")
  @DisplayName("Check address in description is correct")
  @Test
  public void checkObjectAddress() {
    String actualDescription = mainPageDiscord.getDescriptionFromPreview();
    assertTrue(actualDescription.contains(objectAddress), "Object address is not correct");
  }

  @AfterAll
  static void deleteLink() {
    mainPageDiscord.deleteLinkInDiscord();
  }
}
