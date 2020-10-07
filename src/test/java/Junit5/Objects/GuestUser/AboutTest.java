package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("About page")
public class AboutTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        reviewsObjectPage = topNavigation.clickOnAboutItem();
    }

    @Story("Open page")
    @DisplayName("Check waivio page is opened in About")
    @Test
    void openAbout() {
        refreshPage();
        boolean actualResult = reviewsObjectPage.isFollowButtonExist();
        assertTrue(actualResult);
    }

    @Story("Check page")
    @DisplayName("Check about page is opened with correct object type - business")
    @Test
    void checkAboutObjectType() {
        String expectedResult = "business";
        String actualResult = reviewsObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check About page is opened with Reviews tab")
    @Test
    void openReviewsInAbout() {
        reviewsObjectPage = reviewsObjectPage.clickOnReviewsItem();
        refreshPage();
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Gallery is opened")
    @Test
    void openGalleryInAbout() {
        galleryObjectPage = reviewsObjectPage.clickOnGalleryItem();
        //refresh(); - проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = galleryObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page") //иногда может не приходить по неизвестным причинам) если через дебаг - то все пройдет
    @DisplayName("Check Updates is opened")
    @Test
    void openUpdatesInAbout() {
        updatesObjectPage = reviewsObjectPage.clickOnUpdatesItem();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page") //странный баг, мануально не воспроизводится
    @DisplayName("Check Followers is opened")
    @Test
    void openFollowersInAbout() {
        followersObjectPage = reviewsObjectPage.clickOnFollowersItem();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page") //странный баг, мануально не воспроизводится
    @DisplayName("Check Experts is opened")
    @Test
    void openExpertsInAbout() {
        expertsObjectPage = reviewsObjectPage.clickOnExpertiseItem();
        refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }

    @AfterAll
    static void logout() {
        header.logOut();
    }
}