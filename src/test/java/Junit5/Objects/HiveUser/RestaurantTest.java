package Junit5.Objects.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ReviewsObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static com.wizardsdev.Context.properties;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Feature("Restaurant Page, Object")
public class RestaurantTest extends TestBase {
    String restaurantName = properties.getProperty("RestaurantName");
    String restaurantNameToSearch = "Tasty Indian Bistro (Delta)";
    static String restaurantObject = properties.getProperty("RestaurantObject");


    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
        reviewsObjectPage = ReviewsObjectPage.openReviewsObjectPage(restaurantObject);
    }

    @Story("Open page")
    @DisplayName("Check restaurant page is opened in review tab")
    @Test
    void openRestaurant() {
        refreshPage();
        String expectedResult = restaurantNameToSearch;
        String actualResult = reviewsObjectPage.getObjectName();
        System.out.println(expectedResult);
        System.out.println(actualResult);
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
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check restaurant Tasty Indian Bistro Delta is opened, this object has 1st tab news")
    @Test
    void openRestaurantTastyIndianBistroDelta() {
        header.inputTextToSearch(restaurantNameToSearch);
        pageObjectPage = header.clickOnTheFirstItemFromSearch();
        String actualResult = pageObjectPage.getObjectName();
        assertEquals(restaurantNameToSearch, actualResult);
    }
}
