package Junit5.Discover;

import Junit5.TestBase;
import com.codeborne.selenide.Selenide;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestaurantTest extends TestBase {
  //был период когда пропадала карта и фильтра

  @BeforeEach
  void goToDiscoverRestaurantPage() {
    FeedPage.openFeedPage();
    discoverPage = topNavigation.clickOnDiscoverItem();
    discoverPage.clickOnRestaurantItem();
  }

  @Story("Discover Restaurant")
  @DisplayName("Is map filter appear when page load")
  @Test
  void mapFilterAppearTest(){
    Selenide.refresh(); // без этого фильтра сначала появляются, потом пропадают(только в браузере вебдрайвер)
    assert(discoverPage.isMapFilterExist());
  }

  @Story("Discover Restaurant")
  @DisplayName("Is rated filter appear when page load")
  @Test
  void topRatedFilterAppearTest() {
    Selenide.refresh(); // без этого карта сначала появляется, потом пропадает(только в браузере вебдрайвер)
    assert(discoverPage.isTopRatedFilterExist());
  }
}
