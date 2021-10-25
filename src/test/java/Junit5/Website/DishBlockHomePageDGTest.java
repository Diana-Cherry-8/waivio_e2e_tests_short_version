package Junit5.Website;

import Junit5.TestBase;
import com.wizardsdev.PageObjects.DiningGifts.HomePage;
import io.qameta.allure.Story;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DishBlockHomePageDGTest extends TestBase {
  static String websiteName = "";
  static String templateName = "dining.gifts";

  String additionalPartUrlNearbyVegan =
      "/map?type=dish&Category=vegan&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyVegetarian =
      "/map?type=dish&Category=vegetarian&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyGlutenFree =
      "/map?type=dish&Category=gluten-free&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbySteak =
      "/map?type=dish&Ingredients=steak&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyChickenWings =
      "/map?type=dish&Ingredients=wings&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbySushi =
      "/map?type=dish&Category=sushi&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyBBQ =
      "/map?type=dish&Category=bbq&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyDimSum =
      "/map?type=dish&Ingredients=dim-sum&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyPizza =
      "/map?type=dish&Ingredients=pizza&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyBeef =
      "/map?type=dish&Ingredients=beef&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyLamb =
      "/map?type=dish&Ingredients=lamb&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyPork =
      "/map?type=dish&Ingredients=pork&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyDuck =
      "/map?type=dish&Ingredients=duck&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyTuna =
      "/map?type=dish&Ingredients=tuna&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyPokeBowls =
      "/map?type=dish&Ingredients=poke&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbySalmon =
      "/map?type=dish&Ingredients=salmon&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyCod =
      "/map?type=dish&Ingredients=cod&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyOysters =
      "/map?type=dish&Ingredients=oysters&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyHalibut =
      "/map?type=dish&Ingredients=halibut&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";
  String additionalPartUrlNearbyBlackCod =
      "/map?type=dish&Ingredients=black-cod&showPanel=true&center=49.2268638%2C-123.1288576&zoom=12";


  @BeforeEach
  void openSite() {
    homePage = HomePage.openDiningGiftsHomePage(websiteName, templateName);
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Vegan link Dish block")
  @Test
  void openMapViaVeganLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 0);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyVegan));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Vegetarian link Dish block")
  @Test
  void openMapViaVegetarianLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 1);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyVegetarian));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Gluten free link Dish block")
  @Test
  void openMapViaGlutenFreeLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 2);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyGlutenFree));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Steak link Dish block")
  @Test
  void openMapViaSteakLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 3);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbySteak));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Chicken wings link Dish block")
  @Test
  void openMapViaChickenWingsLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 4);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyChickenWings));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Sushi link Dish block")
  @Test
  void openMapViaSushiLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 5);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbySushi));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the BBQ link Dish block")
  @Test
  void openMapViaBBQLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 6);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyBBQ));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Dim Sum link Dish block")
  @Test
  void openMapViaDimSumLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 7);
    assert(mapPage.areObjectsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyDimSum));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Pizza link Dish block")
  @Test
  void openMapViaPizzaLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 8);
    assert(mapPage.areObjectsMarksExistWithRefresh() && mapPage.areObjectsRewardsMarksExist() // Происходит что-то странное, не видит локатор поэтому добавлен sleep и refresh
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyPizza));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Beef link Dish block")
  @Test
  void openMapViaBeefLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 9);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyBeef));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Lamb link Dish block")
  @Test
  void openMapViaLambLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 10);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyLamb));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Pork link Dish block")
  @Test
  void openMapViaPorkLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 11);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyPork));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Duck link Dish block")
  @Test
  void openMapViaDuckLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 12);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyDuck));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Tuna link Dish block")
  @Test
  void openMapViaTunaLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 13);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyTuna));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Poke Bowls link Dish block")
  @Test
  void openMapViaPokeBowlsLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 14);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyPokeBowls));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Salmon link Dish block")
  @Test
  void openMapViaSalmonLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 15);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbySalmon));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Cod link Dish block")
  @Test
  void openMapViaCodLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 16);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyCod));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Oysters link Dish block")
  @Test
  void openMapViaOystersLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 17);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyOysters));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Halibut link Dish block")
  @Test
  void openMapViaHalibutLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 18);
    assert(mapPage.areObjectsMarksExist() && mapPage.areObjectsRewardsMarksExist()
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyHalibut));
  }

  @Story("Website dining.gifts. Home page. Dish block")
  @DisplayName("Check Map open via click on the Black cod link Dish block")
  @Test
  void openMapViaBlackCodLink() {
    mapPage = homePage.clickOnNearbyTitleLinkOnDishBlock(websiteName, templateName, 19);
    assert(mapPage.areObjectsMarksExistWithRefresh() // Происходит что-то странное, не видит локатор поэтому добавлен sleep и refresh
        && headerDiningGifts.isLinkCorrect(templateName, "",
        additionalPartUrlNearbyBlackCod));
  }

  @AfterEach
  void openHomePage() {
    headerDiningGifts.clickOnLogo();
  }

}


