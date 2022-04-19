package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.wizardsdev.Context;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class AdvancedPage extends ProfilePage {
    public static final By FIELD_DATE_CALENDAR_LOCATOR = By.cssSelector(".ant-calendar-input");
    public static final By BUTTON_ACCOUNT_CREATION_LOCATOR = By.cssSelector(".WalletTable__datepickerFooter");
    public static final By BUTTON_TODAY_LOCATOR = By.cssSelector(".ant-calendar-today-btn ");
    public static final By INPUTS_DATE_LOCATOR = By.cssSelector(".ant-calendar-picker-input");
    public static final By DROPDOWN_CURRENCY_LOCATOR = By.cssSelector(".ant-select-selection-selected-value");
    public static final By BUTTON_CURRENCY_LOCATOR = By.cssSelector(".ant-select-dropdown-menu-item");
    public static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By STRING_TOTAL_DATA_LOCATOR = By.cssSelector(".WalletTable__total");
    public static final By FIELDS_SEARCH_USERS_LOCATOR = By.cssSelector(".ant-select-search__field");
    public static final By DROPDOWN_USER_LOCATOR = By.cssSelector(".SearchUser");
    public static final By TABLE_ROWS_LOCATOR = By.cssSelector("tbody tr");
    public static final By BUTTON_CLEAR_USER_LOCATOR = By.cssSelector(".icon-delete");
    public static final By BUTTON_SHOW_MORE_LOCATOR = By.cssSelector(".DynamicTable__showMore");

    public AdvancedPage(String userName) {
        super(Context.getSiteUrl() + "/@" + userName + "/transfers/table");
    }

    @Step
    public boolean isShowMoreButtonExists() {
        return $(BUTTON_SHOW_MORE_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public String getStringTotalData() {
        return $(STRING_TOTAL_DATA_LOCATOR).getText();
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
        $(STRING_TOTAL_DATA_LOCATOR).waitUntil(Condition.matchText(".*\\(Completed\\)"), 200000);
    }

    @Step
    public boolean isButtonSubmitExist() {
        return $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public void addUsers(String username) {
        $$(FIELDS_SEARCH_USERS_LOCATOR).get(1).shouldBe(Condition.visible).click();
        $$(FIELDS_SEARCH_USERS_LOCATOR).get(1).shouldBe(Condition.visible).setValue(username);
        $$(DROPDOWN_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public String getCellValue(int rowIndex, String columnName) {
        int cellId = 0;
        switch (columnName) {
            case "HIVE" -> cellId = 2;
            case "HP" -> cellId = 3;
            case "HBD" -> cellId = 4;
            case "HIVE/USD" -> cellId = 5;
            case "HBD/USD" -> cellId = 6;
            case "±" -> cellId = 7;
        }
        return $$(TABLE_ROWS_LOCATOR).get(rowIndex).$$("td").get(cellId).getText().replaceAll("\\s+", "");
    }

    @Step
    public String getCounterTotal(String totalType) {
        float typeValue = 0;
        String result = "";
        for (int i = 0; i < $$(TABLE_ROWS_LOCATOR).size(); i++) {
            String hive = getCellValue(i, "HIVE");
            String hiveCurrency = getCellValue(i, "HIVE/USD");
            String hp = getCellValue(i, "HP");
            String hbd = getCellValue(i, "HBD");
            String hbdCurrency = getCellValue(i, "HBD/USD");
            String type = getCellValue(i, "±");
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
        System.out.println(result);
        return result;
    }

    @Step
    public String getCountedTotal() {
        return $(STRING_TOTAL_DATA_LOCATOR).shouldBe(Condition.visible).getText();
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
