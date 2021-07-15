package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Post creation, Rewards")
public class PostCreationTests extends TestBase {
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

    @BeforeEach
    void clickPostIcon() {
        editorPage = header.clickOnWritePostIcon();
    }

    @Story("Editor")
    @DisplayName("Editor opening")
    @Test
    void openEditor() {
        assert (editorPage.isButtonReadyToPublishExists());
    }

    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        editorPage.setPostTitle(title);
        editorPage.setContentPost(contentPost);
        editorPage.clickButtonReadyToPublish();
        editorPage.clickCheckboxLegalNotice();
        postsPage = editorPage.clickButtonPublish(facebookName);
        editorPage.postAppearWaiter();
        refreshPage();
        assertEquals(title, postsPage.getPostTitle(0));
    }

    @AfterEach
    void clickAccountIcon() {
        profilePage = header.clickOnAccountIcon();
    }
}