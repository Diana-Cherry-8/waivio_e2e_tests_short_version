package com.wizardsdev.PageObjects.Profile;
import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
public class AdvancedPage  extends ProfilePage {
    public static final By FIELD_FROM_DATA  = By.cssSelector(".ant-calendar-picker-icon");
    public static final By BUTTON_ACCOUNT_CREATION  = By.cssSelector(".WalletTable__datepickerFooter");
    public static final By BUTTON_TODAY  = By.cssSelector(".ant-calendar-today-btn ");
    public static final By INPUT_DATEPICKER  = By.cssSelector(".ant-calendar-picker-input");
    public static final By DROPDOWN_CURRENCY  = By.cssSelector(".ant-select-selection-selected-value");
    public static final By BUTTON_USD  = By.cssSelector(".ant-select-dropdown-menu-item-selected");
    public static final By BUTTON_SUBMIT  = By.cssSelector(".ant-btn-primary");
    public static final By STRING_TOTAL  = By.cssSelector(".WalletTable__total");
    public static final By FIELD_FIND_USERS  = By.cssSelector(".ant-select-search__field");
    public static final By DROPDOWN_USER  = By.cssSelector(".SearchUser");
    public static final By TABLE  = By.cssSelector(".DynamicTable");
    public static final By COLUMN_HIVE_USD_1_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_2_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_3_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(6)");
    public static final By COLUMN_HIVE_USD_4_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(4) > td:nth-child(6)");
    public static final By COLUMN_HIVE_1_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(1) > td:nth-child(6)");
    public static final By COLUMN_HIVE_2_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(2) > td:nth-child(6)");
    public static final By COLUMN_HIVE_3_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(3) > td:nth-child(3)");
    public static final By COLUMN_HIVE_4_LINE = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody > tr:nth-child(4) > td:nth-child(3)");
    public static final By CLEAR_FILED_ICON = By.cssSelector(".icon-delete");
    float sum = 0;
    float expectedFloat = 0;
    @Step
    public void inputFromDate(int index){
        $$(FIELD_FROM_DATA).get(index).click();
        $(BUTTON_ACCOUNT_CREATION).click();
    }
    @Step
    public void inputToDate(int index){
       $$(INPUT_DATEPICKER).get(index).click();
       $(BUTTON_TODAY).click();
    }
    @Step
    public void dropdownCurrency(int index){
        $(DROPDOWN_CURRENCY).click();
        sleep(1000);
        $$(BUTTON_USD).get(index).click();
    }
 @Step
    public void clickButtonSubmit(){
        $(BUTTON_SUBMIT).click();
    }
 @Step
    public boolean isCompleted() {
        return $(STRING_TOTAL).shouldHave(text("Completed")).exists();
    }
    @Step
    public boolean isButtonSubmitExist() {
        return $(BUTTON_SUBMIT).shouldBe(Condition.visible).exists();
    }
    @Step
    public void addUsers(int index, int index2) {
        $$(FIELD_FIND_USERS).get(index).click();
        $$(FIELD_FIND_USERS).get(index).setValue("waiviotest2");
        $$(DROPDOWN_USER).get(index2).click();
    }
    @Step
    public boolean isCompletedForMultiply() {
        return $(TABLE).shouldHave(text("waiviotest2")).exists();
    }
    @Step
    public float isCountedCorrectDeposit() {
        return newCount(COLUMN_HIVE_USD_3_LINE, COLUMN_HIVE_USD_4_LINE, COLUMN_HIVE_3_LINE, COLUMN_HIVE_4_LINE);
    }
    @Step
    public float isCountedCorrectWithdrawal() {
        return newCount(COLUMN_HIVE_USD_1_LINE, COLUMN_HIVE_USD_2_LINE, COLUMN_HIVE_1_LINE, COLUMN_HIVE_2_LINE);
    }

    public float newCount(By columnHiveUsd1Line, By columnHiveUsd2Line, By columnHive1Line, By columnHive2Line) {
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
        $(CLEAR_FILED_ICON).click();
    }
    @Step
    public String totalText() {
        return $(STRING_TOTAL).shouldBe(Condition.visible).getText();
    }
       @Override
    protected void init() {
    }
    @Override
    protected void parsePage() {

    }
}
