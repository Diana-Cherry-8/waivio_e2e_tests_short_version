package com.wizardsdev.PageObjects.Profile;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdvancedPage  extends ProfilePage {
    public static final By FIELD_FROM_DATA_LOCATOR  = By.cssSelector(".ant-calendar-picker-icon");
    public static final By BUTTON_ACCOUNT_CREATION_LOCATOR = By.cssSelector(".WalletTable__datepickerFooter");
    public static final By BUTTON_TODAY_LOCATOR = By.cssSelector(".ant-calendar-today-btn ");
    public static final By INPUT_DATEPICKER_LOCATOR = By.cssSelector(".ant-calendar-picker-input");
    public static final By DROPDOWN_CURRENCY_LOCATOR = By.cssSelector(".ant-select-selection-selected-value");
    public static final By BUTTON_USD_LOCATOR = By.cssSelector(".ant-select-dropdown-menu-item-selected");
    public static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By STRING_TOTAL_LOCATOR = By.cssSelector(".WalletTable__total");
    public static final By FIELD_FIND_USERS_LOCATOR = By.cssSelector(".ant-select-search__field");
    public static final By DROPDOWN_USER_LOCATOR = By.cssSelector(".SearchUser");
    public static final By TABLE_LOCATOR = By.cssSelector(".DynamicTable");
    public static final By COLUMN_HIVE_USD_1_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_2_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_3_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_4_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(4) > td:nth-child(6)");
    public static final By COLUMN_HIVE_1_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(6)");
    public static final By COLUMN_HIVE_2_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");
    public static final By COLUMN_HIVE_3_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(3)");
    public static final By COLUMN_HIVE_4_LINE_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(4) > td:nth-child(3)");
    public static final By CLEAR_FILED_ICON_LOCATOR = By.cssSelector(".icon-delete");
    float sum;
    float expectedFloat;
    String username = "waiviotest2";

    @Step
    public void enterDateOfStart(){
        $$(FIELD_FROM_DATA_LOCATOR).get(0).shouldBe(Condition.visible).click();
        $(BUTTON_ACCOUNT_CREATION_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void enterDateOfEnd(){
       $$(INPUT_DATEPICKER_LOCATOR).get(1).shouldBe(Condition.visible).click();
       $(BUTTON_TODAY_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void choseCurrency(){
        $(DROPDOWN_CURRENCY_LOCATOR).click();
        $$(BUTTON_USD_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public void clickButtonSubmit(){
        $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public boolean waitUntilReportToBeCounted() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 100);
        return wait.until(ExpectedConditions.invisibilityOfElementWithText(BUTTON_SUBMIT_LOCATOR,"Loading"));
    }

    @Step
    public boolean isButtonSubmitExist() {
        return $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public void addUsers() {
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).click();
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).setValue(username);
        $$(DROPDOWN_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public boolean isReportCompletedForMultipleUsers() {
        return $(TABLE_LOCATOR).shouldHave(text(username)).exists();
    }

    @Step
    public float countTotalDeposit() {
        return counter(COLUMN_HIVE_USD_3_LINE_LOCATOR, COLUMN_HIVE_USD_4_LINE_LOCATOR, COLUMN_HIVE_3_LINE_LOCATOR, COLUMN_HIVE_4_LINE_LOCATOR);
    }

    @Step
    public float countTotalWithdrawal() {
        return counter(COLUMN_HIVE_USD_1_LINE_LOCATOR, COLUMN_HIVE_USD_2_LINE_LOCATOR, COLUMN_HIVE_1_LINE_LOCATOR, COLUMN_HIVE_2_LINE_LOCATOR);

    }
    public float counter(By columnHiveUsd1Line, By columnHiveUsd2Line, By columnHive1Line, By columnHive2Line) {
        String hiveCurrency1 = ($(columnHiveUsd1Line).shouldBe(Condition.visible).getText());
        String hiveCurrency2 = ($(columnHiveUsd2Line).shouldBe(Condition.visible).getText());
        String hiveAmount1 = ($(columnHive1Line).shouldBe(Condition.visible).getText());
        String hiveAmount2 = ($(columnHive2Line).shouldBe(Condition.visible).getText());
        float hiveCurrency1F = Float.parseFloat(hiveCurrency1);
        float hiveCurrency2F = Float.parseFloat(hiveCurrency2);
        float hiveAmount1F = Float.parseFloat(hiveAmount1);
        float hiveAmount2F = Float.parseFloat(hiveAmount2);
        sum = hiveAmount1F * hiveCurrency1F + hiveAmount2F * hiveCurrency2F;
        expectedFloat = (float) (Math.round(sum * 1000.0) / 1000.0);
        return expectedFloat;
    }

    @Step
    public void clickClearButton(){
        $(CLEAR_FILED_ICON_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public String totalText() {
        return $(STRING_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public void fillTheFields(){
        addUsers();
        enterDateOfStart();
        enterDateOfEnd();
        choseCurrency();
    }

       @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {

    }
}
