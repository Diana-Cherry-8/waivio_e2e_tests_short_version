package Junit5.Notification.HiveUser;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NotificationEmptyTest extends TestBase {

  static String hiveUserEmail = properties.getProperty("UserLogin03");
  static String hivePasswordPassword = properties.getProperty("LoginPassword03");

  @BeforeAll
  static void logInAsTestUser() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(hiveUserEmail, hivePasswordPassword);
  }

  @Test
  void checkIsNotificationListEmptyTest(){
    header.clickOnNotificationIcon();
    assert(header.isNotificationEmpty());
  }

  @Test
  void checkNotificationPageIsAvailable() {
    header.clickOnNotificationIcon();
    notificationsPage = header.clickSeeAllNotifications();
    assert(notificationsPage.isNotificationsPageContentEmpty());
  }

  @Test
  void clickOnLeftSideBarMenuTest() {
    notificationsPage = feedLeftBar.clickOnNotificationItem();
    assert(notificationsPage.isNotificationsPageContentEmpty());
  }
}
