package Junit5.Post.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Post creation, Rewards")
public class PostCreationTest extends TestBase {
    static String username = "dv56d";
    String title = "Test " + (int) (Math.random() * 50);
    String contentPost = "Test body " + (int) (Math.random() * 100);
    String image = "https://cdn.discordapp.com/attachments/740485430943809546/822392335345647616/Test.png";

    @Disabled
    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
    }

    @Disabled
    @BeforeEach
    void clickPostIcon() {
        editorPage = header.clickOnWritePostIcon();
    }

    @Disabled
    @Story("Editor")
    @DisplayName("Editor opening")
    @Test
    void openEditor() {
        assert (editorPage.isButtonReadyToPublishExists());
    }

    @Disabled
    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        editorPage.setPostTitle(title);
        editorPage.setContentPost(contentPost);
        editorPage.clickButtonReadyToPublish();
        editorPage.clickCheckboxLegalNotice();
        postsPage = editorPage.clickButtonPublish(username);
        postsPage.postAppearWaiter();
        refreshPage();
        assertEquals(title, postsPage.getPostTitle(0));
        String contentBody = postsPage.getContentBody();
        // здесь нужны две проверки, что title соответствует, и что текст есть, чтобы убедиться что это действительно нужный пост
        assertEquals(title, postsPage.getPostTitle(0));
        assertTrue(contentBody.contains(contentPost));
    }

//    @Story("Post creation")
//    @DisplayName("Post creation only with image")
//    @Test
//    void createPostWithImage() throws IOException, UnsupportedFlavorException {
//        editorPage.setPostTitle(title);
//        editorPage.setContentPost(image);
//        editorPage.savePictureLinkToClipboard();
//        editorPage.clickPlusButton();
//        addImages = editorPage.clickPhotoButtonInPlusLocator();
//        addImages.pasteImageLink();
//        editorPage = addImages.clickOk();
//        editorPage.clickButtonReadyToPublish();
//        editorPage.clickCheckboxLegalNotice();
//        postsPage = editorPage.clickButtonPublish(facebookName);
//        postsPage.postAppearWaiter();
//        refreshPage();
//        // здесь нужны две проверки, что title соответствует, и что контейнер картинки есть, чтобы убедиться что это действительно нужный пост
//        assertEquals(title, postsPage.getPostTitle(0));
//        assertTrue(postsPage.isImageContainerExist());
//    }

    @AfterEach
    void clickAccountIcon() {
        profilePage = header.clickOnAccountIcon();
    }
}