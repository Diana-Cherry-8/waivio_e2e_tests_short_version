package Junit5.ChangeLanguage;

import static org.junit.jupiter.api.Assertions.assertEquals;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ChangeLanguageTest extends TestBase {
  private static final String EXPECTED_TOP_NAVIGATION_ITEM_TEXT = "МОЯ ЛЕНТА";

  @Story("Change site language")
  @DisplayName("Check change site language by not login user")
  @Test
  void changeLanguageToRussianTest() {
    FeedPage.openFeedPage();
    header.clickOnChangeLanguageIcon();
    header.clickOnRussianLanguage();
    assertEquals(EXPECTED_TOP_NAVIGATION_ITEM_TEXT, topNavigation.getTopNavigationItemByNumber(0).getText());
  }
}
