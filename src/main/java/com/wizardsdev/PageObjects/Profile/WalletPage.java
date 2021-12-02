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
    public static final By CHECKBOX_IN_MODAL_LINK_LOCATOR = By.cssSelector(".ant-checkbox-input");
    public static final By BUTTON_OK_IN_MODAL_LINK_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By LINK_ADVANCED_REPORT_LOCATOR = By.cssSelector(".UserWallet__view-btn");
    public static final By TABS_WALLET_LOCATOR = By.cssSelector(".ant-tabs-tab");
    public static final By PRICE_IN_CHART_LOCATOR = By.cssSelector(".CryptoTrendingCharts__usd-price");
    public static final By CHART_DATA_POINT_LOCATOR = By.cssSelector(".data-point");
    public static final By BUTTON_CHART_OPEN_LOCATOR = By.cssSelector(".icon-unfold");
    private static final By WAIV_AMOUNT_LOCATOR = By.cssSelector(".WalletSummaryInfo__value");
    private static final By CURRENCIES_DROP_DOWN_LOCATOR =
        By.cssSelector(".ant-select-selection-selected-value");
    private static final By ITEM_IN_CURRENCIES_DROP_DOWN_LOCATOR =
        By.cssSelector(".ant-select-dropdown-menu-item");

    public WalletPage(String userName) { super(Context.getSiteUrl() + "/@" + userName + "/transfers");
    }

    @Step
    public static WalletPage openWalletPage(String userName) {
        if (!url().contains(Context.getSiteUrl() + "/@" + userName + "/transfers")) {
            open(Context.getSiteUrl() + "/@" + userName + "/transfers");
        }
        return new WalletPage(userName);
    }

    @Step
    public boolean isButtonsForTransferExist() {
        return $(BUTTONS_TRANSFER_LOCATOR).shouldBe(Condition.visible).exists();
    }

    public static void clickOnTransferOrWithdrawButtonsByIndex(int index) {
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
        String expectedString = $(HIVE_AMOUNT_LOCATOR).shouldBe(Condition.visible).getText();
        String deleteText = " HIVE";
        String replace = "";
        String deleteHive = expectedString.replaceAll(deleteText, replace);
        float expectedFloat = Float.parseFloat(deleteHive);
        return expectedFloat;
    }

    @Step
    public Float getWaivAmount() {
        String expectedString = $$(WAIV_AMOUNT_LOCATOR).get(0).shouldBe(Condition.visible).getText();
        String deleteText = " WAIV";
        String replace = "";
        String deleteWaiv = expectedString.replaceAll(deleteText, replace);
        float expectedFloat = Float.parseFloat(deleteWaiv);
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
        if ($(INPUT_FOR_AMOUNT_LOCATOR).exists()) {
            $(INPUT_FOR_AMOUNT_LOCATOR).shouldBe(Condition.visible).setValue(amountFotTransfer);
        } else {
            $$(INPUT_FOR_SEARCH_LOCATOR).get(1).shouldBe(Condition.visible).setValue(hiveName);
            $(".SearchUser").shouldBe(Condition.visible);
            $$(INPUT_FOR_SEARCH_LOCATOR).get(1).pressEnter();

            $(CHECKBOX_IN_MODAL_LINK_LOCATOR).click();
            $(BUTTON_OK_IN_MODAL_LINK_LOCATOR).click();
            $(INPUT_FOR_AMOUNT_LOCATOR).shouldBe(Condition.visible).setValue(amountFotTransfer);
        }
    }

    @Step
    public void choseCurrency(String currency) {
        $(CURRENCIES_DROP_DOWN_LOCATOR).shouldBe(Condition.visible).click();
        $$(ITEM_IN_CURRENCIES_DROP_DOWN_LOCATOR).findBy(Condition.text(currency)).click();
    }

    @Step
    public void clickContinueAsGuest() {
        $(BUTTON_CONTINUE_LOCATOR).click();
    }

    @Step
    public void clickContinueAsHiveUser() {
        final By BUTTON_APPROVE_TRANSFER_LOCATOR = By.cssSelector(".button-success");
        final By TEXT_SUCCESS_LOCATOR = By.cssSelector(".text-2xl");

        $(BUTTON_CONTINUE_LOCATOR).click();
        switchTo().window(1);
        $(BUTTON_APPROVE_TRANSFER_LOCATOR).shouldBe(Condition.visible).click();
        $(TEXT_SUCCESS_LOCATOR).shouldBe(Condition.exactText('\n' +
            "    Transaction has been successfully broadcasted\n" +
            "  "));
        closeWindow();
        switchTo().window(0);
    }

    @Step
    public AdvancedPage clickOnLinkAdvancedReport() {
        sleep(1000);
        $(LINK_ADVANCED_REPORT_LOCATOR).shouldBe(Condition.visible).click();
        return new AdvancedPage(getUserNameValue());
    }

    @Step
    public void openHiveWalletTab() {
        if($(TABS_WALLET_LOCATOR).shouldBe(Condition.visible).exists()) {
            $$(TABS_WALLET_LOCATOR).get(1).shouldBe(Condition.visible).click();
        }
    }

    @Step
    public void openWaivWalletTab() {
        if($(TABS_WALLET_LOCATOR).shouldBe(Condition.visible).exists()) {
            $$(TABS_WALLET_LOCATOR).get(0).shouldBe(Condition.visible).click();
        }
    }

    @Step
    public boolean isCurrencyInPriceInChartDisplayed(String currency) {
        for (int i = 0; i < 3; i++) {
            String temp = $$(PRICE_IN_CHART_LOCATOR).get(i).getText();
            if(!temp.contains(currency)) {
                System.out.println("Failure from "+ i + " index");
                return false;
            }
        }
        return true;
    }

    @Step
    public void clickDisplayChart(int index) {
        $$(BUTTON_CHART_OPEN_LOCATOR).get(index).shouldBe(Condition.visible).click();
    }

    @Step
    public boolean isChartDataPointPresent() {
        return $$(CHART_DATA_POINT_LOCATOR).get(0).exists();
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

