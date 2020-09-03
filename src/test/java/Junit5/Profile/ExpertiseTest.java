package Junit5.Profile;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Profile page")
public class ExpertiseTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check expertise page hashtags tab is opened")
    @Test
    void openExpertiseHashtagsTab() {
        postsPage = header.clickOnAccountIcon();
        expertisePage = postsPage.clickOnExpertiseProfileItem();
        refresh();
        String expectedResult = "No data";
        String actualResult = expertisePage.getTextNoDataHashtagsTab();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check expertise page object tab is opened")
    @Test
    void openExpertiseObjectsTab() {
        postsPage = header.clickOnAccountIcon();
        expertisePage = postsPage.clickOnExpertiseProfileItem();
        expertisePage.clickOnObjectsExpertiseItem();
        boolean actualResult = expertisePage.isButtonFollowObjectExist();
        assertTrue(actualResult);
    }
}
