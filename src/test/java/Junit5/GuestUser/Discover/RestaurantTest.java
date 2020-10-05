package Junit5.GuestUser.Discover;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

public class RestaurantTest extends TestBase {
  //был период когда пропадала карта и фильтра

  @BeforeAll
  static void goToDiscoverRestaurantPage() {
    FeedPage.openFeedPage();
    discoverPage = topNavigation.clickOnDiscoverItem();
    discoverPage.clickOnRestaurantItem();
  }

  @Story("Discover Restaurant")
  @DisplayName("Is map filter appear when page load")
  @Test
  void mapFilterAppearTest() {
    refreshPage(); // без этого фильтра сначала появляются, потом пропадают(только в браузере вебдрайвер)
    assert (discoverPage.isMapFilterExist());
  }

  @Story("Discover Restaurant")
  @DisplayName("Is rated filter appear when page load")
  @Test
  void topRatedFilterAppearTest() {
    refreshPage();// без этого карта сначала появляется, потом пропадает(только в браузере вебдрайвер)
    assert (discoverPage.isTopRatedFilterExist());
  }
}

