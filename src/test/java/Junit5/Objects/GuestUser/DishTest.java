package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Dish type, Object")
public class DishTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    String dishName = properties.getProperty("DishObjectName");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        dishObjectPage = DishObjectPage.openDishObjectPage();
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened")
    @Test
    void openDishObjectPage() {
        refreshPage();
        String expectedResult = dishName;
        String actualResult = dishObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check dish page is opened with correct object type")
    @Test
    void checkDishObjectType() {
        String expectedResult = "dish";
        String actualResult = dishObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened in review tab")
    @Test
    void openDishReviewTab() {
        reviewsObjectPage = dishObjectPage.clickOnReviewsItem();
        refreshPage();   //проблемы с перезагрузой
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened in gallery tab")
    @Test
    void openDishGalleryTab() {
        galleryObjectPage = dishObjectPage.clickOnGalleryItem();
        //refreshPage();   проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = galleryObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened in updates tab")
    @Test
    void openDishUpdatesTab() {
        updatesObjectPage = dishObjectPage.clickOnUpdatesItem();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened in followers tab")
    @Test
    void openDishFollowersTab() {
        followersObjectPage = dishObjectPage.clickOnFollowersItem();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check dish page is opened in experts tab")
    @Test
    void openDishExpertsTab() {
        expertsObjectPage = dishObjectPage.clickOnExpertiseItem();
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }
}


