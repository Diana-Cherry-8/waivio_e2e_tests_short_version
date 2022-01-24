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

public class ReviewPreviewTest extends TestBase {
  static String discordChannelLink = "https://discord.com/channels/933278946710134884/933278946710134887";
  static String email = "jasecarmel@gmail.com";
  static String password = "qweqwe123QWE";
  String app = "Waivio";
  static String objectName = "Corduroy Restaurant";
  static int postIndex;
  static String postTitle;
  static String postBody;
  static String link;

  @BeforeAll
  static void actions() {
    //take url from waivio
    feedPage = FeedPage.openFeedPage();
    pageObjectPage = header.generalMethodForSearch(objectName);
    pageObjectPage.clickOnReviewsItem();
    postTitle = pageObjectPage.getTitleInFeed(postIndex);
    postBody = pageObjectPage.getPostBodyInFeed(postIndex);
    pageObjectPage.clickOnTitleInFeed(postIndex);
    link = header.getSiteUrlString();

    //discord login
    loginPageDiscord = LoginPageDiscord.openDiscordPage();
    loginPageDiscord.loginDiscord(email, password);
    mainPageDiscord = MainPageDiscord.openMainPage(discordChannelLink); // open Preview channels

    //insert link to discord
    mainPageDiscord.setLink(link);
  }

  @Story("Preview. Post")
  @DisplayName("Check preview is loaded")
  @Test
  public void checkPreviewLoaded() {
    assertTrue (mainPageDiscord.isPreviewLoaded(), "Preview didn't load");
  }

  @Story("Preview. Post")
  @DisplayName("Check app name is waivio")
  @Test
  public void checkAppName() {
    String actualAppName = mainPageDiscord.getAppName();
    assertEquals(app, actualAppName, "App name is not correct");
  }

  @Story("Preview. Post")
  @DisplayName("Check post title is correct")
  @Test
  public void checkPostTitle() {
    String actualPostTitle = mainPageDiscord.getUserNameFromPreview();
    assertTrue(actualPostTitle.contains(postTitle), "Post title is not correct");
  }

  @Story("Preview. Post")
  @DisplayName("Check post body is correct")
  @Test
  public void checkPostBody() {
    String actualPreviewPostBody = mainPageDiscord.getShortDescriptionFromPreview();
    assertEquals(postBody, actualPreviewPostBody, "Post body is not correct");
  }

  @Story("Preview. Post")
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
