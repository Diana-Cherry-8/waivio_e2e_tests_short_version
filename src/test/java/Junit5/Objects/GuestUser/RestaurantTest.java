package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ReviewsObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.sleep;
import static com.wizardsdev.Context.properties;
import static org.junit.jupiter.api.Assertions.*;

@Feature("Restaurant Page, Object")
public class RestaurantTest extends TestBase {
    static String restaurantObject = properties.getProperty("RestaurantObject");
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    String restaurantName = properties.getProperty("RestaurantName");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        reviewsObjectPage = ReviewsObjectPage.openObjectPage(restaurantObject);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in review tab")
    @Test
    void openRestaurant() {
        refreshPage();
        String expectedResult = restaurantName;
        String actualResult = reviewsObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check restaurant page is opened with correct object type")
    @Test
    void checkRestaurantObjectType() {
        String expectedResult = "restaurant";
        String actualResult = reviewsObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in gallery tab")
    @Test
    void openRestaurantGalleryTab() {
        galleryObjectPage = reviewsObjectPage.clickOnGalleryItem();
        //refreshPage();   проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = galleryObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in updates tab")
    @Test
    void openRestaurantUpdatesTab() {
        updatesObjectPage = reviewsObjectPage.clickOnUpdatesItem();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in followers tab")
    @Test
    void openRestaurantFollowersTab() {
        followersObjectPage = reviewsObjectPage.clickOnFollowersItem();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in experts tab")
    @Test
    void openRestaurantExpertsTab() {
        expertsObjectPage = reviewsObjectPage.clickOnExpertiseItem();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }
}
