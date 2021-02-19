package Junit5.Objects.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ListObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@Feature("List type, Object")
public class ListTest extends TestBase {
    static String facebookEmail = properties.getProperty("FacebookUserEmail00");
    static String facebookPassword = properties.getProperty("FacebookUserPass00");
    static String listObject = properties.getProperty("ListObject");
    String listName = properties.getProperty("ListObjectName");

    @BeforeAll
    static void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
        listObjectPage = ListObjectPage.openListObjectPage(listObject);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened")
    @Test
    void openList() {
        refreshPage();
        String expectedResult = listName;
        String actualResult = listObjectPage.getObjectName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Check page")
    @DisplayName("Check list page is opened with correct object type")
    @Test
    void checkListObjectType() {
        String expectedResult = "list";
        String actualResult = listObjectPage.getObjectTypeName();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened in review tab")
    @Test
    void openListReviewTab() {
        reviewsObjectPage = listObjectPage.clickOnReviewsItemList();
        refreshPage();   //проблемы с перезагрузой
        String expectedResult = "Write a new review";
        String actualResult = reviewsObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened in gallery tab")
    @Test
    void openListGalleryTab() {
        galleryObjectPage = listObjectPage.clickOnGalleryItemList();
        //refreshPage();   проблемы с перезагрузой
        String expectedResult = "Add new album";
        String actualResult = galleryObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened in updates tab")
    @Test
    void openRestaurantUpdatesTab() {
        updatesObjectPage = listObjectPage.clickOnUpdatesItemList();
        refreshPage();
        String expectedResult = "Add";
        String actualResult = updatesObjectPage.getButtonText();
        assertEquals(expectedResult, actualResult);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened in followers tab")
    @Test
    void openRestaurantFollowersTab() {
        followersObjectPage = listObjectPage.clickOnFollowersItemList();
        refreshPage();
        boolean actualResult = followersObjectPage.isSortingInFollowersExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check list page is opened in experts tab")
    @Test
    void openRestaurantExpertsTab() {
        expertsObjectPage = listObjectPage.clickOnExpertiseItemList();
        //refreshPage();
        boolean actualResult = expertsObjectPage.isButtonFollowSecondaryExist();
        assertTrue(actualResult);
    }
}

