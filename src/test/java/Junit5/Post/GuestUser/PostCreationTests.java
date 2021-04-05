package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Post creation, Rewards")
public class PostCreationTests extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;


    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Disabled
    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        //#TODO
    }
}