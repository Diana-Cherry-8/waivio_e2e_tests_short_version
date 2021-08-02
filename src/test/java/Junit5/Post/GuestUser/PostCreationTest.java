package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.junit.jupiter.api.*;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Post creation, Rewards")
public class PostCreationTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static String facebookName = properties.getProperty("FacebookUserName00");
    static boolean newWindow = true;
    String title = "Test " + (int) (Math.random() * 50);
    String contentPost = "Test body " + (int) (Math.random() * 100);
    String image = "https://cdn.discordapp.com/attachments/740485430943809546/822392335345647616/Test.png";

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
        postsPage.postAppearWaiter();
        refreshPage();
        assertEquals(title, postsPage.getPostTitle(0));
        String contentBody = postsPage.getContentBody();
        // здесь нужны две проверки, что title соответствует, и что текст есть, чтобы убедиться что это действительно нужный пост
        assertEquals(title, postsPage.getPostTitle(0));
        assertTrue(contentBody.contains(contentPost));
    }

    @Story("Post creation")
    @DisplayName("Post creation only with image")
    @Test
    void createPostWithImage() throws IOException, UnsupportedFlavorException {
        editorPage.setPostTitle(title);
        editorPage.setContentPost(image);
        editorPage.savePictureLinkToClipboard();
        editorPage.clickPlusButton();
        addImages = editorPage.clickPhotoButtonInPlusLocator();
        addImages.pasteImageLink();
        editorPage = addImages.clickOk();
        editorPage.clickButtonReadyToPublish();
        editorPage.clickCheckboxLegalNotice();
        postsPage = editorPage.clickButtonPublish(facebookName);
        postsPage.postAppearWaiter();
        refreshPage();
        // здесь нужны две проверки, что title соответствует, и что контейнер картинки есть, чтобы убедиться что это действительно нужный пост
        assertEquals(title, postsPage.getPostTitle(0));
        assertTrue(postsPage.isImageContainerExist());
    }

    @AfterEach
    void clickAccountIcon() {
        profilePage = header.clickOnAccountIcon();
    }
}