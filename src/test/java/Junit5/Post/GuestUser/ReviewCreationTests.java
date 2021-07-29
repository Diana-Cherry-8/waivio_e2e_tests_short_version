package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;


import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Post creation, Rewards")
public class ReviewCreationTests extends TestBase {
  static String facebookEmail = properties.getProperty("FacebookUserEmail00");
  static String facebookPassword = properties.getProperty("FacebookUserPass00");
  static String facebookName = properties.getProperty("FacebookUserName00");
  static boolean newWindow = true;
  String title = "Test " + String.valueOf((int) (Math.random() * 20));
  String contentPost = "Test body";

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
  }

  @Story("Review creation")
  @DisplayName("Review creation only with text")
  @Test
  void createReview() {
    eligiblePage = topNavigation.clickOnRewardsItem();
    rewardsLeftSidebar.clickOnEligibleItem();
    eligiblePage.clickEarnButton();
    reservation = eligiblePage.clickReserveButtonInCard();
    reservedPage = reservation.clickReserveButtonInModalWindow();
    writeReview = reservedPage.clickWriteReview();
    editorPage = writeReview.clickWriteReviewInModalWindow();


    editorPage.setPostTitle(title);
    editorPage.setContentPost(contentPost);
    editorPage.clickButtonReadyToPublish();
    editorPage.clickCheckboxLegalNotice();
    postsPage = editorPage.clickButtonPublish(facebookName);
    postsPage.postAppearWaiter();
    refreshPage();
    assertEquals(title, postsPage.getPostTitle(0));
  }

  @Test
  void ddd(){
    postsPage = header.clickOnAccountIcon();
    editorPage = postsPage.clickOnEditPostInPostMenu();
    editorPage.clickOnObjectSwitch();
    editorPage.clickOnObjectSwitch();
    editorPage.clearContentPost();
    editorPage.setPostTitle("test123");
    editorPage.clickButtonReadyToPublish();
    editorPage.clickClosePreviewModalWindow();
    editorPage.setContentPost(contentPost);
    editorPage.clickButtonReadyToPublish();
    editorPage.clickCheckboxLegalNotice();
    editorPage.clickButtonPublish(facebookName);
  }

  @AfterEach
  void editPost() {
//    editorPage = postsPage.clickOnEditPostInPostMenu();
//    editorPage.clickOnObjectSwitch();
//    editorPage.clickOnObjectSwitch();
//    editorPage.clearContentPost();
//    editorPage.setContentPost(contentPost);
//    editorPage.clickButtonReadyToPublish();
//    editorPage.clickCheckboxLegalNotice();
//    editorPage.clickButtonPublish(facebookName);

  }
}