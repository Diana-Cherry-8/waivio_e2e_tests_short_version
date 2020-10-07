package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.*;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("Drink type, Object")
public class DrinkTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    String drinkName = properties.getProperty("DrinkObjectName");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        drinkObjectPage = DrinkObjectPage.openDrinkObjectPage();
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened")
    @Test
    void openDrinkObjectPage() {
        refreshPage();
        String expectedResult = drinkName;
        String actualResult = drinkObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check drink page is opened with correct object type")
    @Test
    void checkDrinkObjectType() {
        String expectedResult = "drink";
        String actualResult = drinkObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened in review tab")
    @Test
    void openDrinkReviewTab() {
        reviewsObjectPage = drinkObjectPage.clickOnReviewsItem();
        refreshPage();   //проблемы с перезагрузой
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened in gallery tab")
    @Test
    void openDrinkGalleryTab() {
        galleryObjectPage = drinkObjectPage.clickOnGalleryItem();
        //refreshPage();   проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = galleryObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened in updates tab")
    @Test
    void openDrinkUpdatesTab() {
        updatesObjectPage = drinkObjectPage.clickOnUpdatesItem();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened in followers tab")
    @Test
    void openDrinkFollowersTab() {
        followersObjectPage = drinkObjectPage.clickOnFollowersItem();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check drink page is opened in experts tab")
    @Test
    void openRestaurantExpertsTab() {
        expertsObjectPage = drinkObjectPage.clickOnExpertiseItem();
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }

    @AfterAll
    static void logout() {
        header.logOut();
    }
}


