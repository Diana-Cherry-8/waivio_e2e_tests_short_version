package Junit5.Tools.GuestUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Edit profile page, Tools")
public class EditProfileTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");
    static boolean newWindow = true;

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    }

    @Story("Open page")
    @DisplayName("Check edit profile page is opened in Tools")
    @Test
    void openEditProfile() {
        draftsPage = topNavigation.clickOnToolsItem();
        editProfilePage = toolsLeftSidebar.clickOnEditProfileItems();
        refreshPage();
        String expectedResult = "Edit profile";
        String actualResult = editProfilePage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}