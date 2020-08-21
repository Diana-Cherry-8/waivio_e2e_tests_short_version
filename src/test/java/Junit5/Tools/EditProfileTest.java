package Junit5.Tools;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.refresh;
import static org.junit.jupiter.api.Assertions.assertEquals;

@Feature("Edit profile page, Tools")
public class EditProfileTest extends TestBase {
    String facebookEmail = properties.getProperty("FacebookUserEmail00");
    String facebookPassword = properties.getProperty("FacebookUserPass00");

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithFacebook(facebookEmail, facebookPassword);
    }

    @Story("Open page")
    @DisplayName("Check edit profile page is opened in Tools")
    @Test
    void openEditProfile() {
        notificationsPageTools = topNavigation.clickOnToolsItem();
        editProfilePage = toolsLeftSidebar.clickOnEditProfileItems();
        refresh();
        String expectedResult = "Edit profile";
        String actualResult = editProfilePage.getTitleTools();
        assertEquals(expectedResult, actualResult);
    }
}


