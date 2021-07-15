package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Post creation, Rewards")
public class PostCreationTests extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;
    String title = String.valueOf((int) (Math.random() * 20));
    String contentPost = "Test body";

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Editor")
    @DisplayName("Open editor")
    @Test
    void openEditor() {
        editorPage = header.clickOnWritePostIcon();
        editorPage.isButtonReadyToPublishExists();
    }

    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        header.clickOnWritePostIcon();
        editorPage.setPostTitle(title);
        editorPage.setContentPost(contentPost);
        editorPage.clickButtonReadyToPublish();
        editorPage.clickCheckboxLegalNotice();
        editorPage.clickButtonPublish();
        editorPage.postAppearWaiter();
        refreshPage();
        postsPage = profilePage.clickOnPostsProfileItem();
        assertEquals(title, postsPage.getPostTitle(0));
    }

    @AfterEach
    void clickAccountIcon() {
        profilePage = header.clickOnAccountIcon();
    }
}