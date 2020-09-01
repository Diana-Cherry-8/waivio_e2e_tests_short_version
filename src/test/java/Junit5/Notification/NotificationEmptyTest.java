package Junit5.Notification;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class NotificationEmptyTest extends TestBase {

  @BeforeAll
  static void logInAsTestUser() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithHiveSigner(getUserLogin(), getUserPassword());
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
