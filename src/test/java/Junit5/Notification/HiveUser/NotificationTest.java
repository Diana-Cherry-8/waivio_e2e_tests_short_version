package Junit5.Notification.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NotificationTest extends TestBase {

    static String hiveUserEmail = properties.getProperty("UserLogin03");
    static String hivePasswordPassword = properties.getProperty("LoginPassword03");

    @BeforeAll
    static void logInAsHiveUser() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(hiveUserEmail, hivePasswordPassword);
    }

    @Story("Notification pop-up")
    @DisplayName("Check that notification pop-up is opening")
    @Test
    void checkThatNotificationPopUpOpens() {
        header.clickOnNotificationIcon();
        assert(header.isNotificationPopUpOpened());
    }

    @Story("Notification page")
    @DisplayName("Check that notification page is opening from pop-up")
    @Test
    void checkNotificationPageOpensFromPopUp() {
        header.clickOnNotificationIcon();
        notificationsPage = header.clickSeeAllNotifications();
        assert(notificationsPage.isNotificationPageOpened());
    }

    @Story("Notification page")
    @DisplayName("Check that notification page is opening from Feed left bar")
    @Test
    void checkNotificationPageOpensFromFeedLeftBar() {
        notificationsPage = feedLeftBar.clickOnNotificationItem();
        assert(notificationsPage.isNotificationPageOpened());
    }
}
