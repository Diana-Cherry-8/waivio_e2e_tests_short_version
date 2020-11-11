package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.PageObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Page type, Object")
public class PageTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    String pageName = properties.getProperty("PageObjectName");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        pageObjectPage = PageObjectPage.openPageObjectPage();
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened")
    @Test
    void openPage() {
        refreshPage();
        String expectedResult = pageName;
        String actualResult = pageObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check Page object  is opened with correct object type")
    @Test
    void checkPageObjectType() {
        String expectedResult = "page";
        String actualResult = pageObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in review tab")
    @Test
    void openPageReviewTab() {
        reviewsObjectPage = pageObjectPage.clickOnReviewsItemPage();
        refreshPage();   //проблемы с перезагрузой
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }


    @Story("Open page")
    @DisplayName("Check Page object page is opened in updates tab")
    @Test
    void openPageUpdatesTab() {
        updatesObjectPage = pageObjectPage.clickOnUpdatesItemPage();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in followers tab")
    @Test
    void openPageFollowersTab() {
        followersObjectPage = pageObjectPage.clickOnFollowersItemPage();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Page object page is opened in experts tab")
    @Test
    void openPageExpertsTab() {
        expertsObjectPage = pageObjectPage.clickOnExpertiseItemPage();
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }
}


