package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AdvancedPage extends ProfilePage {
    public static final By FIELD_DATE_CALENDAR_LOCATOR = By.cssSelector(".ant-calendar-input");
    public static final By BUTTON_ACCOUNT_CREATION_LOCATOR = By.cssSelector(".WalletTable__datepickerFooter");
    public static final By BUTTON_TODAY_LOCATOR = By.cssSelector(".ant-calendar-today-btn ");
    public static final By INPUTS_DATE_LOCATOR = By.cssSelector(".ant-calendar-picker-input");
    public static final By DROPDOWN_CURRENCY_LOCATOR = By.cssSelector(".ant-select-selection-selected-value");
    public static final By BUTTON_CURRENCY_LOCATOR = By.cssSelector(".ant-select-dropdown-menu-item");
    public static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By STRING_TOTAL_LOCATOR = By.cssSelector(".WalletTable__total");
    public static final By FIELD_FIND_USERS_LOCATOR = By.cssSelector(".ant-select-search__field");
    public static final By DROPDOWN_USER_LOCATOR = By.cssSelector(".SearchUser");
    public static final By TABLE_ROW_LOCATOR = By.cssSelector("tbody > tr");
    public static final By BUTTON_CLEAR_USER_LOCATOR = By.cssSelector(".icon-delete");
    public static final By BUTTON_SHOW_MORE_LOCATOR = By.cssSelector(".DynamicTable__showMore");


    @Step
    public boolean isShowMoreButtonExists() {
        return $(BUTTON_SHOW_MORE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getStringTotal() {
        return $(STRING_TOTAL_LOCATOR).getText();
    }

    @Step
    public void clearFirstUser() {
        $$(BUTTON_CLEAR_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public void enterDateOfStart(String startDate) {
        $$(INPUTS_DATE_LOCATOR).get(0).shouldBe(Condition.visible).click();
        if (startDate.equals("Account Creation")) {
            $(BUTTON_ACCOUNT_CREATION_LOCATOR).shouldBe(Condition.visible).click();
        } else {
            $(FIELD_DATE_CALENDAR_LOCATOR).setValue(startDate);
        }
    }

    @Step
    public void enterDateOfEnd(String endDate) {
        $$(INPUTS_DATE_LOCATOR).get(1).shouldBe(Condition.visible).click();
        if (endDate.equals("Today")) {
            $(BUTTON_TODAY_LOCATOR).shouldBe(Condition.visible).click();
        } else {
            $(FIELD_DATE_CALENDAR_LOCATOR).setValue(endDate);
        }
    }

    @Step
    public void choseCurrency(String currency) {
        $(DROPDOWN_CURRENCY_LOCATOR).click();
        $$(BUTTON_CURRENCY_LOCATOR).find(Condition.text(currency)).click();
    }

    @Step
    public void clickButtonSubmit() {
        $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public void waitUntilReportToBeCounted() {
        $(STRING_TOTAL_LOCATOR).waitUntil(Condition.matchText(".*\\(Completed\\)"), 200000);
    }

    @Step
    public boolean isButtonSubmitExist() {
        return $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public void addUsers(String username) {
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).click();
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).setValue(username);
        $$(DROPDOWN_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public String getHiveValue(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(3)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getHiveCurrencyValue(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(6)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getHpValue(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(4)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getHbdValue(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(5)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getHbdCurrencyValue(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(7)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getRowType(int rowNumber) {
        return $(By.cssSelector("tbody > tr:nth-child(" + rowNumber + ") > td:nth-child(8)")).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getCounterTotal(String totalType) {
        float typeValue = 0;
        String result = "";
        for (int i = 1; i <= $$(TABLE_ROW_LOCATOR).size(); i++) {
            String hive = getHiveValue(i);
            String hiveCurrency = getHiveCurrencyValue(i);
            String hp = getHpValue(i);
            String hbd = getHbdValue(i);
            String hbdCurrency = getHbdCurrencyValue(i);
            String type = getRowType(i);
            if (!hive.equals("") && type.equals(totalType)) {
                typeValue = typeValue + (Float.parseFloat(hive) * Float.parseFloat(hiveCurrency));
            }
            if (!hp.equals("") && type.equals(totalType)) {
                typeValue = typeValue + (Float.parseFloat(hp) * Float.parseFloat(hiveCurrency));
            }
            if (!hbd.equals("") && type.equals(totalType)) {
                typeValue = typeValue + (Float.parseFloat(hbd) * Float.parseFloat(hbdCurrency));
            }
        }
        float formattedTypeValue = (float) (Math.round(Math.abs(typeValue) * 100.0) / 100.0);
        switch (totalType) {
            case "W" -> result = "Withdrawals: $" + formattedTypeValue;
            case "D" -> result = "Deposits: $" + formattedTypeValue;
        }
        return result;
    }

    @Step
    public String getCountedTotal() {
        return $(STRING_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public void fillTheFields(String startDate, String endDate, String currency) {
        enterDateOfStart(startDate);
        enterDateOfEnd(endDate);
        choseCurrency(currency);
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {

    }
}
