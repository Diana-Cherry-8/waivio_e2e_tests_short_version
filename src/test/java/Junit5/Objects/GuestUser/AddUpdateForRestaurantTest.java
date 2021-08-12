package Junit5.Objects.GuestUser;

import static org.junit.jupiter.api.Assertions.assertTrue;


import Junit5.TestBase;
import com.wizardsdev.PageObjects.FeedPage;
import com.wizardsdev.PageObjects.Objects.ReviewsObjectPage;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;

@Feature("Restaurant Page, Object")
public class AddUpdateForRestaurantTest extends TestBase {
  static String restaurantObject = properties.getProperty("RestaurantObjectForAddUpdate");
  static String facebookEmail = properties.getProperty("FacebookUserEmail00");
  static String facebookPassword = properties.getProperty("FacebookUserPass00");

  static boolean newWindow = true;
  static String description = "Test body " + (int) (Math.random() * 100000);
  static String price = "Price " + (int) (Math.random() * 1000000);
  static String hours = "Hours " + (int) (Math.random() * 1000000);
  static String address = "Ad " + (int) (Math.random() * 100);
  static String street = "Str " + (int) (Math.random() * 100);
  static String city = "C " + (int) (Math.random() * 100);
  static String state = "Sta " + (int) (Math.random() * 100);
  static String postalCode = "C " + (int) (Math.random() * 100);
  static String country = "Cnt " + (int) (Math.random() * 100);
  static String titleForWebsite = "Website " + (int) (Math.random() * 1000);
  static String linkForWebsite = "linkforWebsite" + (int) (Math.random() * 1000);
  static String phoneName = "Test Name" + (int) (Math.random() * 1000);
  static String phoneNumber = "Number" + (int) (Math.random() * 1000000);
  static String email = "testemail@" + "test" + (int) (Math.random() * 100000) + ".test";

  @BeforeAll
  static void login() {
    feedPage = FeedPage.openFeedPage();
    header.logInWithFacebook(facebookEmail, facebookPassword, newWindow);
    reviewsObjectPage = ReviewsObjectPage.openObjectPage(restaurantObject);
  }

  @Story("Add update")
  @DisplayName("Add description via left sidebar")
  @Test
  void addDescription() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddDescriptionViaLeftSidebar();
    updateObject.setDescription(description);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(description));
  }

  @Story("Add update")
  @DisplayName("Add price via left sidebar")
  @Test
  void addPrice() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddPriceViaLeftSidebar();
    updateObject.setPrice(price);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(price));
  }

  @Story("Add update")
  @DisplayName("Add hours via left sidebar")
  @Test
  void addHours() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddHoursViaLeftSidebar();
    updateObject.setHours(hours);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(hours));
  }

  @Story("Add update")
  @DisplayName("Add address via left sidebar")
  @Test
  void addAddress() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddAddressViaLeftSidebar();
    updateObject.setAllAddressInfo(address, street, city, state, postalCode, country);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(address) && contentBody.contains(street)
        && contentBody.contains(city) && contentBody.contains(state)
        && contentBody.contains(postalCode) && contentBody.contains(country));
  }

  @Story("Add update")
  @DisplayName("Add website via left sidebar")
  @Test
  void addWebsite() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddWebsiteViaLeftSidebar();
    updateObject.setWebsiteTitle(titleForWebsite);
    updateObject.setWebsiteLink(linkForWebsite);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(titleForWebsite) && contentBody.contains(linkForWebsite));
  }

  @Story("Add update")
  @DisplayName("Add website via left sidebar")
  @Test
  void addPhone() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddPhoneViaLeftSidebar();
    updateObject.setPhoneName(phoneName);
    updateObject.setPhoneNumber(phoneNumber);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(phoneName) && contentBody.contains(phoneNumber));
  }

  @Story("Add update")
  @DisplayName("Add email via left sidebar")
  @Test
  void addEmail() {
    reviewsObjectPage.clickEditButton();
    updateObject = reviewsObjectPage.clickAddEmailViaLeftSidebar();
    updateObject.setEmail(email);
    updatesObjectPage = updateObject.clickSubmit();
    String contentBody = updatesObjectPage.getContentBodyFromPostUpdate();
    assertTrue(contentBody.contains(email));
  }

  @AfterEach
  void closeModalWindow() {
    updateObject.closeModalWindow();
  }
}


