package Junit5.About;

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

@Feature("About page")
public class AboutTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check waivio page is opened in About")
    @Test
    void openAbout() {
        aboutPage = topNavigation.clickOnAboutItem();
        refresh();
        boolean actualResult = aboutPage.isFollowButtonExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check About page is opened with Reviews tab")
    @Test
    void openReviewsInAbout() {
        aboutPage = topNavigation.clickOnAboutItem();
        refresh();
        String expectedResult = "Write a new review";
        String actualResult = aboutPage.getTextButton();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Gallery is opened")
    @Test
    void openGalleryInAbout() {
        aboutPage = topNavigation.clickOnAboutItem().clickOnGalleryItem();
        //refresh(); - проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = aboutPage.getTextButton();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page") //иногда может не приходить по неизвестным причинам) если через дебаг - то все пройдет
    @DisplayName("Check Updates is opened")
    @Test
    void openUpdatesInAbout() {
        aboutPage = topNavigation.clickOnAboutItem().clickOnUpdatesItem();
        refresh();
        String expectedResult = "Add";
        String actualResult = aboutPage.getTextButton();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page") //странный баг, мануально не воспроизводится
    @DisplayName("Check Followers is opened")
    @Test
    void openFollowersInAbout() {
        aboutPage = topNavigation.clickOnAboutItem().clickOnFollowersItem();
        refresh();
        boolean actualResult = aboutPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page") //странный баг, мануально не воспроизводится
    @DisplayName("Check Experts is opened")
    @Test
    void openExpertsInAbout() {
        aboutPage = topNavigation.clickOnAboutItem().clickOnExpertiseItem();
        refresh();
        boolean actualResult = aboutPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }
}