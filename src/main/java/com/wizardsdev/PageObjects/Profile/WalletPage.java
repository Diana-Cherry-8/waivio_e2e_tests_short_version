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
    private static final By ITEM_IN_DROP_DOWN_LOCATOR =
        By.cssSelector(".ant-select-dropdown-menu-item");
    private static final By USER_WALLET_TRANSACTION_CONTENT_LOCATOR =
        By.cssSelector(".UserWalletTransactions__content");
    private static final By CURRENCY_TITLE_HIVE_ENGINE_LOCATOR = By.cssSelector(".HiveEngineCurrencyItem__info");
    private static final By DROP_DOWNS_SWAP_TOKENS_LOCATOR = By.cssSelector(".SwapTokens__selector");
    private static final By DROP_DOWN_DISABLED_LOCATOR = By.className(".ant-select-disabled");
    private static final By INPUTS_SWAP_TOKENS_LOCATOR = By.cssSelector(".SwapTokens__input .ant-input");
    private static final By BUTTONS_MAX_SWAP_LOCATOR = By.cssSelector(".SwapTokens__max-button");
    private static final By YOUR_BALANCES_LOCATOR = By.cssSelector(".SwapTokens__balance");
    private static final By BUTTON_ARROW_LOCATOR = By.cssSelector(".SwapTokens__arrow");
    private static final By BUTTONS_SLIDER_LOCATOR = By.cssSelector(".ant-radio-button-wrapper");
    private static final By ESTIMATED_PRICE_IMPACT_LOCATOR = By.cssSelector(".SwapTokens__estimatedWrap p");
    private static final By INVALID_MESSAGE_LOCATOR = By.cssSelector(".invalid");

    private static final By DROPDOWN_DEPOSIT_LOCATOR = By.cssSelector(".Deposit__step .ant-select");
    private static final By INPUTS_DEPOSIT_LOCATOR = By.cssSelector(".Deposit__input");
    private static final By QR_CODE_LOCATOR = By.cssSelector(".Deposit__qr-code");


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

    public static void clickOnTransferButtonByIndex(int index) {
        $$(BUTTONS_TRANSFER_LOCATOR).get(index).click();
    }

    @Step
    public WalletPage clickOnTransferButton() {
        clickOnTransferButtonByIndex(0);
        $(CURRENCIES_DROP_DOWN_LOCATOR).shouldNotBe(Condition.disabled);
        return new WalletPage(getUserNameValue());
    }

    @Step
    public WalletPage clickOnWithdrawButton() {
        clickOnTransferButtonByIndex(1);
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
    public void chooseCurrency(String currency) {
        $(CURRENCIES_DROP_DOWN_LOCATOR).shouldBe(Condition.visible).click();
        $$(ITEM_IN_DROP_DOWN_LOCATOR).findBy(Condition.text(currency)).click();
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
    public void openWaivWalletTab() {
        if($(TABS_WALLET_LOCATOR).shouldBe(Condition.visible).exists()) {
            $$(TABS_WALLET_LOCATOR).get(0).shouldBe(Condition.visible).click();
        }
    }

    @Step
    public void openHiveWalletTab() {
        if($(TABS_WALLET_LOCATOR).shouldBe(Condition.visible).exists()) {
            $$(TABS_WALLET_LOCATOR).get(1).shouldBe(Condition.visible).click();
        }
    }

    @Step
    public void openHiveEngineWalletTab() {
        if($(TABS_WALLET_LOCATOR).shouldBe(Condition.visible).exists()) {
            $$(TABS_WALLET_LOCATOR).get(2).shouldBe(Condition.visible).click();
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

    @Step
    public boolean isCurrencyInHistoryDisplayed(String mainCurrency, String currencyPower, String additionalCurrency) {
        for (int i = 0; i < 10; i++) {
            String temp = $$(USER_WALLET_TRANSACTION_CONTENT_LOCATOR).get(i).getText();
            if(!temp.contains(mainCurrency) & !temp.contains(currencyPower)
                & !temp.contains("Limit order to")  & !temp.contains(additionalCurrency)) {
                System.out.println("Result with index "+ i + " has failure: " + temp);
                return false;
            }
        }
        return true;
    }

    @Step
    public boolean isCurrencyInHiveEngineWalletDisplayed(String currency1, String currency2, String currency3, String currency4) {
        for (int i = 0; i < 4; i++) {
            String temp = $$(CURRENCY_TITLE_HIVE_ENGINE_LOCATOR).get(i).getText();
            if(!temp.contains(currency1) & !temp.contains(currency2)
                & !temp.contains(currency3)  & !temp.contains(currency4)) {
                System.out.println("Result with index "+ i + " has failure: " + temp);
                return false;
            }
        }
        return true;
    }

    @Step
    public void clickSwapTokens () {
        clickOnTransferButtonByIndex(1);
        sleep(5000);
    }

    @Step
    public void clickMaxButtonSwap (int index) {
        $$(BUTTONS_MAX_SWAP_LOCATOR).get(index).shouldBe(Condition.visible).click();
    }

    @Step
    public String getInputValueSwap(int index) {
        return $$(INPUTS_SWAP_TOKENS_LOCATOR).get(index).shouldBe(Condition.visible).getValue();
    }

    @Step
    public void setInputValueSwap(int index, String text) {
        $$(INPUTS_SWAP_TOKENS_LOCATOR).get(index).shouldBe(Condition.visible).setValue(text);
    }

    @Step
    public String getYourBalanceWithoutCurrencySwap(int index, String textDelete) {
        return $$(YOUR_BALANCES_LOCATOR).get(index)
            .shouldBe(Condition.visible).getText()
            .replace(textDelete, "");
    }

    @Step
    public String getYourBalanceWithCurrencySwap(int index) {
        return $$(YOUR_BALANCES_LOCATOR).get(index).shouldBe(Condition.visible).getText();
    }

    @Step
    public void clickArrowButton () {
        $(BUTTON_ARROW_LOCATOR).shouldBe(Condition.visible).click();
        sleep(3000);
    }

    @Step
    public boolean isExpectedPercentInSlider() {
        for (int i = 0; i < 6; i++) {
            clickPercentSlider(i);
            String temp = $$(ESTIMATED_PRICE_IMPACT_LOCATOR).get(1).getText();
            String temp2 = temp.replace("Estimated price impact: ", "");
            String estPrice = temp2.replace("%", "");
            if (i == 0 & estPrice.equals("0.5")) {
                continue;
            }
            if (i == 1 & estPrice.equals("1")) {
                continue;
            }
            if (i == 2 & estPrice.equals("5")) {
                continue;
            }
            if (i == 3 & estPrice.equals("10")) {
                continue;
            }
            if (i == 4 & estPrice.equals("25")) {
                continue;
            }
            if (i == 5 & estPrice.equals("49")) {
                continue;
            }
            System.out.println("Index: " + i + ' ' + "Estimated price impact: " + estPrice + '%');
            return false;
        }
        return true;
    }

    @Step
    public void clickPercentSlider(int index) {
        $$(BUTTONS_SLIDER_LOCATOR).get(index).click();
    }

    @Step
    public boolean isInvalidMessageVisible () {
        return $(INVALID_MESSAGE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public void clickDeposit() {
        clickOnTransferButtonByIndex(2);
        sleep(5000);
    }

    @Step
    public void clickDepositDropdown(String currency) {
        $(DROPDOWN_DEPOSIT_LOCATOR).shouldBe(Condition.visible).click();
        $$(ITEM_IN_DROP_DOWN_LOCATOR).findBy(Condition.text(currency)).click();
    }

    @Step
    public String getContentFirstInputInDeposit() {
        return $$(INPUTS_DEPOSIT_LOCATOR).get(0).getText();
    }

    @Step
    public String getMemoInDeposit() {
        return $$(INPUTS_DEPOSIT_LOCATOR).get(1).getText();
    }

    @Step
    public boolean isAddressPresent() {
        return !getContentFirstInputInDeposit().isEmpty() && getContentFirstInputInDeposit().length() > 20;
    }

    @Step
    public boolean isQRCodePresent() {
        return $(QR_CODE_LOCATOR).exists();
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

