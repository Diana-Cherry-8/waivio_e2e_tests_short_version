package Junit5.Profile;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Profile page")
public class ExpertiseTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

//    @Story("Open page")  //test if you do not have hashtags expertise
//    @DisplayName("Check expertise page hashtags tab is opened")
//    @Test
//    void openExpertiseHashtagsTabEmpty() {
//        postsPage = header.clickOnAccountIcon();
//        expertisePage = postsPage.clickOnExpertiseProfileItem();
//        refresh();
//        String expectedResult = "No data";
//        String actualResult = expertisePage.getTextNoDataHashtagsTab();
//        assertEquals(expectedResult, actualResult);
//    }

    @Story("Open page")
    @DisplayName("Check expertise page hashtags tab is opened")
    @Test
    void openExpertiseHashtagsTabIfHave() {
        postsPage = header.clickOnAccountIcon();
        expertisePage = postsPage.clickOnExpertiseProfileItem();
        refreshPage();
        boolean actualResult = expertisePage.getUserExpertiseFeed();
        sleep(5000);
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check expertise page object tab is opened")
    @Test
    void openExpertiseObjectsTab() {
        postsPage = header.clickOnAccountIcon();
        expertisePage = postsPage.clickOnExpertiseProfileItem();
        expertisePage.clickOnObjectsExpertiseItem();
        sleep(5000);
        boolean actualResult = expertisePage.isButtonFollowObjectExist();
        sleep(5000);
        assertTrue(actualResult);
    }

    @AfterAll
    static void logout() {
        header.logOut();
    }
}
