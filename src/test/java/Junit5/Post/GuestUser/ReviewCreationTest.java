package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Post creation, Rewards")
public class ReviewCreationTest extends TestBase {

  static String facebookEmail = "diana8899877@gmail.com";
  static String facebookPassword = "zxcdba9898";
  static String facebookName = "waivio_diana-ch";

  static boolean newWindow = true;
  String title = "Test " + (int) (Math.random() * 20);
  String contentPost = "Test body";
  String sponsorName = "daine-cherry2";

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
    eligiblePage.clickOnSpecificSponsorInFilter(sponsorName);
    eligiblePage.clickEarnButton();
    reservation = eligiblePage.clickReserveButtonInCard();
    reservedPage = reservation.clickReserveButtonInModalWindow();
    writeReview = reservedPage.clickWriteReview();
    editorPage = writeReview.clickWriteReviewInModalWindow();
    editorPage.setPostTitle(title);
    editorPage.clickButtonReadyToPublish();
    editorPage.clickCheckboxLegalNotice();
    postsPage = editorPage.clickButtonPublish(facebookName);
    postsPage.postAppearWaiter();
    refreshPage();
    assertEquals(title, postsPage.getPostTitle(0));
  }

  @AfterEach
  void editPost() {
    postsPage = header.clickOnAccountIcon();
    editorPage = postsPage.clickOnEditPostInPostMenu();
    editorPage.clickOnObjectSwitch();
    editorPage.clickOnObjectSwitch();
    editorPage.clearContentPost();
    editorPage.setContentPostForEdit(contentPost);
    editorPage.clickButtonReadyToPublish();
    editorPage.clickCheckboxLegalNotice();
    editorPage.clickButtonPublish(facebookName);
  }
}