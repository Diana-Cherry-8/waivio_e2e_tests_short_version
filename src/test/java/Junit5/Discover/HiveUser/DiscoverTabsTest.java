package Junit5.Discover.HiveUser;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class DiscoverTabsTest extends TestBase {

    @BeforeAll
    static void goToDiscoverRestaurantPage() {
        feedPage = FeedPage.openFeedPage();
        header.logInWithHiveSigner(getUserLogin(), getUserPassword());
        discoverPage = topNavigation.clickOnDiscoverItem();
    }

    @Story("Open page")
    @DisplayName("Check Hashtag page is opened in Discover, default")
    @Test
    void openHashtagDiscover() {
        refreshPage();
        String expectedResult = "Hashtag";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check All page is opened in Discover")
    @Test
    void openAllDiscover() {
        discoverPage = discoverLeftSidebar.clickOnAllObjectsItem();
        refreshPage();
        boolean actualResult = discoverPage.isHashtagsTabExist();
        assertTrue(actualResult);
    }

    @Story("Open page")
    @DisplayName("Check Restaurant page is opened in Discover")
    @Test
    void openRestaurantDiscover() {
        discoverPage = discoverLeftSidebar.clickOnRestaurantObjectItems();
        refreshPage();
        String expectedResult = "Restaurant";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Dish page is opened in Discover")
    @Test
    void openDishDiscover() {
        discoverPage = discoverLeftSidebar.clickOnDishObjectItem();
        refreshPage();
        String expectedResult = "Dish";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Business page is opened in Discover")
    @Test
    void openBusinessDiscover() {
        discoverPage = discoverLeftSidebar.clickOnBusinessObjectItem();
        refreshPage();
        String expectedResult = "Business";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Product page is opened in Discover")
    @Test
    void openProductDiscover() {
        discoverPage = discoverLeftSidebar.clickOnProductObjectItem();
        refreshPage();
        String expectedResult = "Product";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Drink page is opened in Discover")
    @Test
    void openDrinkDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnDrinkObjectItem();
        refreshPage();
        String expectedResult = "Drink";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Place page is opened in Discover")
    @Test
    void openPlaceDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnPlaceObjectItem();
        refreshPage();
        String expectedResult = "Place";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check List page is opened in Discover")
    @Test
    void openListDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnListObjectItem();
        refreshPage();
        String expectedResult = "List";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Page (type) page is opened in Discover")
    @Test
    void openPageDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnPageObjectItem();
        refreshPage();
        String expectedResult = "Page";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Crypto page is opened in Discover")
    @Test
    void openCryptoDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnCryptoObjectItem();
        refreshPage();
        String expectedResult = "Crypto";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Indices page is opened in Discover")
    @Test
    void openIndicesDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnIndicesObjectItem();
        refreshPage();
        String expectedResult = "Indices";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Commodity page is opened in Discover")
    @Test
    void openCommodityDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnCommodityObjectItem();
        refreshPage();
        String expectedResult = "Commodity";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Currency page is opened in Discover")
    @Test
    void openCurrencyDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnCurrencyObjectItem();
        refreshPage();
        String expectedResult = "Currency";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Stocks page is opened in Discover")
    @Test
    void openStocksDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnStocksObjectItem();
        refreshPage();
        String expectedResult = "Stocks";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check App page is opened in Discover")
    @Test
    void openAppDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnAppObjectItem();
        refreshPage();
        String expectedResult = "App";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Currencies page is opened in Discover")
    @Test
    void openCurrenciesDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        //refreshPage(); - проблемы с перезагрузкой
        discoverPage = discoverLeftSidebar.clickOnCurrenciesObjectItem();
        String expectedResult = "Currencies";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Service page is opened in Discover")
    @Test
    void openServiceDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnServiceObjectItem();
        refreshPage();
        String expectedResult = "Service";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Company page is opened in Discover")
    @Test
    void openCompanyDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnCompanyObjectItem();
        refreshPage();
        String expectedResult = "Company";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Organization page is opened in Discover")
    @Test
    void openOrganizationDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnOrganizationObjectItem();
        refreshPage();
        String expectedResult = "Organization";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Hotel page is opened in Discover")
    @Test
    void openHotelDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnHotelObjectItem();
        refreshPage();
        String expectedResult = "Hotel";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Motel page is opened in Discover")
    @Test
    void openMotelDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnMotelObjectItem();
        refreshPage();
        String expectedResult = "Motel";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Resort page is opened in Discover")
    @Test
    void openResortDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnResortObjectItem();
        refreshPage();
        String expectedResult = "Resort";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check B&B page is opened in Discover")
    @Test
    void openBAndBDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnBAndBObjectItem();
        refreshPage();
        String expectedResult = "B&B";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Person page is opened in Discover")
    @Test
    void openPersonDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnPersonObjectItem();
        refreshPage();
        String expectedResult = "Person";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Car page is opened in Discover")
    @Test
    void openCarDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnCarObjectItem();
        refreshPage();
        String expectedResult = "Car";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }

    @Story("Open page")
    @DisplayName("Check Test page is opened in Discover")
    @Test
    void openTestDiscover() {
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverLeftSidebar.clickOnShowMoreButton();
        discoverPage = discoverLeftSidebar.clickOnTestObjectItem();
        refreshPage();
        String expectedResult = "Test";
        String actualResult = discoverPage.getTagName();
        assertTrue(actualResult.contains(expectedResult));
    }
}

