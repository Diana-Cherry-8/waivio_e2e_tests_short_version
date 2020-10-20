package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import com.wizardsdev.PageObjects.Objects.GalleryObjectPage;
import com.wizardsdev.PageObjects.Objects.ReviewsObjectPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class WalletPage extends ProfilePage {

    private static final By BUTTONS_TRANSFER_LOCATOR = By.cssSelector(".Action--primary");
    private static final By HIVE_AMOUNT_LOCATOR = By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]" +
            "/div/div[3]/div/div[1]/div[1]/div[2]/span/span");
    public static final By INPUT_FOR_SEARCH = By.xpath("/html/body/div[2]/div/div[2]/div/div[2]/div[2]/" +
            "form/div[1]/div[2]/div/span/div/div/div/ul/li/div/input");
    public static final By INPUT_FOR_AMOUNT = By.cssSelector(".Transfer__amount__input");
    public static final By BUTTON_CONTINUE = By.cssSelector(".ant-btn-primary");

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
    public String getHiveAmount() {
         return $(HIVE_AMOUNT_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public WebElement getSearchFieldByIndex(int index) {
        return  $$(INPUT_FOR_SEARCH).get(index).shouldBe(Condition.visible);
    }

    @Step
    public WalletPage clickOnSearchItemInTransferFunds() {
        getSearchFieldByIndex(1).click();
        return new WalletPage(getUserNameValue());
    }

    @Step
    public void setHiveUserName(String hiveUserName) {
        $(INPUT_FOR_SEARCH).setValue(hiveUserName);
    }

    @Step
    public void setAmount(String amountFotTransfer) {
        $(INPUT_FOR_AMOUNT).setValue(amountFotTransfer).pressEnter();
    }

    @Step
    public void clickContinue(){
        $(BUTTON_CONTINUE).click();
        switchTo().window(1);
        $(".btn-blue").shouldBe(Condition.visible).click();
        $(".btn-blue").shouldBe(Condition.visible).click();
        $(".btn-success").shouldBe(Condition.visible).click();
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

