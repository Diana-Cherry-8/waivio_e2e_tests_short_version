package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.EditorPage;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Profile.CommentsPage;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Post creation, Rewards")
public class PostCreationTests extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    String facebookUserName = properties.getProperty("FacebookUserName00");
    static boolean newWindow = true;
    String title = String.valueOf((int) (Math.random() * 20));
    String contentPost = "Test body";


    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Editor")
    @DisplayName("Open editor")
    @Test
    void openEditor() {
        editorPage = EditorPage.openEditor();
        editorPage.getButtonReadyToPublish().shouldBe(Condition.visible);
    }

    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        openEditor();
        editorPage
                .setPostTitle(title)
                .setContentPost(contentPost)
                .clickButtonReadyToPublish()
                .clickCheckboxLegalNotice()
                .clickButtonPublish()
                .postAppearWaiter();
        refreshPage();
        postsPage = PostsPage.openPostsPage(facebookUserName);
        assertEquals(title, postsPage.getPostTitle(0));
    }
}