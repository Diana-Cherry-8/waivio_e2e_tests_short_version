package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class WalletPage extends ProfilePage {

    private static final By BUTTONS_TRANSFER_LOCATOR = By.cssSelector(".Action--primary");
    private static final By HIVE_AMOUNT_LOCATOR = By.cssSelector(".UserWalletSummary__value");
    public static final By INPUT_FOR_SEARCH_LOCATOR = By.cssSelector(".ant-select-search__field");
    public static final By INPUT_FOR_AMOUNT_LOCATOR = By.cssSelector(".Transfer__amount__input");
    public static final By BUTTON_CONTINUE_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By CHECKBOX_IN_MODAL_LINK_HIVE_ACCOUNT =
        By.cssSelector(".ant-checkbox-input");
    public static final By BUTTON_OK_IN_MODAL_LINK_HIVE_ACCOUNT = By.cssSelector(".ant-btn-primary");

    public WalletPage(String userName) {
        super(Context.getSiteUrl()  + "/@" + userName + "/transfers");
    }

    @Step
    public static WalletPage openWalletPage(String userName) {
        if (!url().contains(Context.getSiteUrl()  + "/@" + userName + "/transfers")) {
            open(Context.getSiteUrl()  + "/@" + userName + "/transfers");
        }
        return new WalletPage(userName);
    }

    @Step
    public boolean isButtonsForTransferExist() {
        return $(BUTTONS_TRANSFER_LOCATOR).shouldBe(Condition.visible).exists();
    }

    public static void clickOnTransferOrWithdrawButtonsByIndex(int index){
        $$(BUTTONS_TRANSFER_LOCATOR).get(index).click();
    }

    @Step
    public WalletPage clickOnTransferButton() {
        clickOnTransferOrWithdrawButtonsByIndex(0);
        return new WalletPage(getUserNameValue());
    }

    @Step
    public WalletPage clickOnWithdrawButton() {
        clickOnTransferOrWithdrawButtonsByIndex(1);
        return new WalletPage(getUserNameValue());
    }

    @Step
    public Float getHiveAmount() {
        sleep(3000);
        String expectedString = $(HIVE_AMOUNT_LOCATOR).shouldBe(Condition.visible).getText();
        String deleteText = " HIVE";
        String replace = "";
        String deleteHive = expectedString.replaceAll(deleteText, replace);
        float expectedFloat = Float.parseFloat(deleteHive);
         return expectedFloat;
    }

    @Step
    public void setUserNameForWalletSearch(String userName) {
        $$(INPUT_FOR_SEARCH_LOCATOR).get(1)
            .shouldBe(Condition.visible)
            .setValue(userName)
            .pressEnter();
    }

    @Step
    public void setAmountAsHive(String amountFotTransfer) {
        $(INPUT_FOR_AMOUNT_LOCATOR).setValue(amountFotTransfer);
    }

    @Step
    public void setAmountAsGuest(String amountFotTransfer, String hiveName) {
        if($(INPUT_FOR_AMOUNT_LOCATOR).exists()) {
            $(INPUT_FOR_AMOUNT_LOCATOR).shouldBe(Condition.visible).setValue(amountFotTransfer);
        }
        else {
            $$(INPUT_FOR_SEARCH_LOCATOR).get(1).shouldBe(Condition.visible).setValue(hiveName);
            $(".SearchUser").shouldBe(Condition.visible);
            $$(INPUT_FOR_SEARCH_LOCATOR).get(1).pressEnter();

            $(CHECKBOX_IN_MODAL_LINK_HIVE_ACCOUNT).click();
            $(BUTTON_OK_IN_MODAL_LINK_HIVE_ACCOUNT).click();
            $(INPUT_FOR_AMOUNT_LOCATOR).shouldBe(Condition.visible).setValue(amountFotTransfer);
        }
    }

    @Step
    public void clickContinueAsGuest(){
        $(BUTTON_CONTINUE_LOCATOR).click();
    }

    @Step
    public void clickContinueAsHiveUser(){
        final By BUTTONS_CONTINUE_TRANSFER_LOCATOR = By.cssSelector(".btn-blue");
        final By BUTTONS_APPROVE_TRANSFER_LOCATOR = By.cssSelector(".btn-success");

        $(BUTTON_CONTINUE_LOCATOR).click();
        switchTo().window(1);
        $(BUTTONS_CONTINUE_TRANSFER_LOCATOR).shouldBe(Condition.visible).click();
        $(BUTTONS_CONTINUE_TRANSFER_LOCATOR).shouldBe(Condition.visible).click();
        $(BUTTONS_APPROVE_TRANSFER_LOCATOR).shouldBe(Condition.visible).click();
        switchTo().window(0);
    }




    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$().shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}

