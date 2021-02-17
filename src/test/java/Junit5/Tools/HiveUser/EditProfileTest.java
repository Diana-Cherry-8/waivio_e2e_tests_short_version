package Junit5.Tools.HiveUser;

import static org.junit.jupiter.api.Assertions.assertEquals;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Feature("Edit profile page, Tools")
public class EditProfileTest extends TestBase {

    @BeforeEach
    void login() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
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


