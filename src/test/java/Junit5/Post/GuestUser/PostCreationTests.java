package Junit5.Post.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Profile.PostsPage;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Post creation, Rewards")
public class PostCreationTests extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");


    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Post creation")
    @DisplayName("Post creation only with text")
    @Test
    void createPost() {
        editorPage = header.clickOnWritePostIcon();
        String postTitle = "Porsche's most powerful Panamera breaks cover with a 680hp powertrain";
        String contentPost = "German automaker Porsche has unveiled the Turbo S E-Hybrid variant of its Panamera model in the US. It is the most powerful Panamera in the company's line-up with a power output of 680hp and a claimed top-speed of 315 km/h. The four-door premium sedan is offered in Executive and Sport Turismo trims and in two color options.";
        editorPage.setPostTitle(postTitle);
        editorPage.setContentPost(contentPost);
        editorPage.clickReadyToPublish();
        editorPage.clickCheckboxLegalNotice();
        editorPage.clickPublish();
        refreshPage();
        sleep(10000);
        refreshPage();
        String actualResult = PostsPage.getPostTitle();

        assertTrue(actualResult.contains(postTitle));
    }
}