package com.wizardsdev.Modals;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;


import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Objects.UpdatesObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class UpdateObject extends Modal{
  private static final By TEXTAREA_DESCRIPTION_LOCATOR = By.cssSelector("#description");
  private static final By TEXTAREA_PRICE_LOCATOR = By.cssSelector("#price");
  private static final By TEXTAREA_HOURS_LOCATOR = By.cssSelector("#workTime");
  private static final By INPUTS_LOCATOR = By.cssSelector(".AppendForm__input");
  private static final By INPUT_STREET_LOCATOR = By.cssSelector("#street");
  private static final By INPUT_CITY_LOCATOR = By.cssSelector("#city");
  private static final By INPUT_STATE_LOCATOR = By.cssSelector("#state");
  private static final By INPUT_POSTAL_CODE_LOCATOR = By.cssSelector("#postalCode");
  private static final By INPUT_TITLE_LOCATOR = By.cssSelector("#title");
  private static final By INPUT_WEBSITE_LINK_LOCATOR = By.cssSelector("#link");
  private static final By INPUT_PHONE_NAME_LOCATOR = By.cssSelector("#name");
  private static final By INPUT_PHONE_NUMBER_LOCATOR = By.cssSelector("#number");
  private static final By INPUT_EMAIL_LOCATOR = By.cssSelector("#email");
  private static final By INPUT_LATITUDE_LOCATOR = By.cssSelector("#latitude");
  private static final By INPUT_LONGITUDE_LOCATOR = By.cssSelector("#longitude");

  @Step
  public UpdatesObjectPage clickSubmit() {
    $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
    return new UpdatesObjectPage();
  }

  @Step
  public void setDescription(String description) {
    $(TEXTAREA_DESCRIPTION_LOCATOR).shouldBe(Condition.visible).setValue(description);
  }

  @Step
  public void setPrice(String price) {
    $(TEXTAREA_PRICE_LOCATOR).shouldBe(Condition.visible).setValue(price);
  }

  @Step
  public void setHours(String hours) {
    $(TEXTAREA_HOURS_LOCATOR).shouldBe(Condition.visible).setValue(hours);
  }

  /*Add address */
  @Step
  public void setAllAddressInfo(String address, String street, String city, String state,
                                String postalCode, String country) {
    setAddress(address);
    setStreet(street);
    setCity(city);
    setState(state);
    setPostalCode(postalCode);
    setCountry(country);
  }

  @Step
  public void setAddress(String address) {
    $$(INPUTS_LOCATOR).get(0).shouldBe(Condition.visible).setValue(address);
  }

  @Step
  public void setStreet(String street) {
    $(INPUT_STREET_LOCATOR).shouldBe(Condition.visible).setValue(street);
  }

  @Step
  public void setCity(String city) {
    $(INPUT_CITY_LOCATOR).shouldBe(Condition.visible).setValue(city);
  }

  @Step
  public void setState(String state) {
    $(INPUT_STATE_LOCATOR).shouldBe(Condition.visible).setValue(state);
  }

  @Step
  public void setPostalCode(String postalCode) {
    $(INPUT_POSTAL_CODE_LOCATOR).shouldBe(Condition.visible).setValue(postalCode);
  }

  @Step
  public void setCountry(String country) {
    $$(INPUTS_LOCATOR).get(5).shouldBe(Condition.visible).setValue(country);
  }
  /*End Add address */

  @Step
  public void setWebsiteTitle(String title) {
    $(INPUT_TITLE_LOCATOR).shouldBe(Condition.visible).setValue(title);
  }

  @Step
  public void setWebsiteLink(String websiteLink) {
    $(INPUT_WEBSITE_LINK_LOCATOR).shouldBe(Condition.visible).setValue(websiteLink);
  }

  @Step
  public void setPhoneName(String phoneName) {
    $(INPUT_PHONE_NAME_LOCATOR).shouldBe(Condition.visible).setValue(phoneName);
  }

  @Step
  public void setPhoneNumber(String phoneNumber) {
    $(INPUT_PHONE_NUMBER_LOCATOR).shouldBe(Condition.visible).setValue(phoneNumber);
  }

  @Step
  public void setEmail(String email) {
    $(INPUT_EMAIL_LOCATOR).shouldBe(Condition.visible).setValue(email);
  }

  @Step
  public void setTitle(String title) {
    $(INPUT_TITLE_LOCATOR).shouldBe(Condition.visible).setValue(title);
  }

  @Step
  public void setLatitude(String latitude) {
    $(INPUT_LATITUDE_LOCATOR).shouldBe(Condition.visible).setValue(latitude);
    sleep(1000);//чтобы метка на карте успевала центроваться
  }

  @Step
  public void setLongitude(String longitude) {
    $(INPUT_LONGITUDE_LOCATOR).shouldBe(Condition.visible).setValue(longitude);
    sleep(1000);//чтобы метка на карте успевала центроваться
  }

  @Override
  protected void init() {

  }

  @Override
  protected void parsePage() {

  }
}
