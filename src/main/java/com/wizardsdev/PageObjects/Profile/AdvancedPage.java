package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdvancedPage extends ProfilePage {
    public static final By FIELD_FROM_DATA_LOCATOR = By.cssSelector(".ant-calendar-picker-icon");
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
    public static final By TABLE_BODY_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody");
    public static final By CLEAR_FILED_ICON_LOCATOR = By.cssSelector(".icon-delete");

    public static final String TOTAL_INFO_LOADING = "TOTAL: Deposits: $0.00. Withdrawals: $0.00. (Loading...)";


    @Step
    public AdvancedPage enterDateOfStart() {
        $$(FIELD_FROM_DATA_LOCATOR).get(0).shouldBe(Condition.visible).click();
        $(BUTTON_ACCOUNT_CREATION_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public AdvancedPage enterDateOfEnd() {
        $$(INPUT_DATEPICKER_LOCATOR).get(1).shouldBe(Condition.visible).click();
        $(BUTTON_TODAY_LOCATOR).click();
        return this;
    }

    @Step
    public AdvancedPage choseCurrency() {
        $(DROPDOWN_CURRENCY_LOCATOR).click();
        $$(BUTTON_USD_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public AdvancedPage clickButtonSubmit() {
        $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public boolean waitUntilReportToBeCounted() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 20);
        return wait.until(ExpectedConditions.invisibilityOfElementWithText(STRING_TOTAL_LOCATOR, TOTAL_INFO_LOADING));
    }

    @Step
    public boolean isButtonSubmitExist() {
        return $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).exists();
    }

    @Step
    public AdvancedPage addUsers(String username) {
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).click();
        $$(FIELD_FIND_USERS_LOCATOR).get(1).shouldBe(Condition.visible).setValue(username);
        $$(DROPDOWN_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public boolean isReportCompletedForMultipleUsers(String username) {
        return $(TABLE_LOCATOR).shouldHave(text(username)).exists();
    }

    @Step
    public String counterTotal(String totalType) {
        float typeValue = 0;
        WebElement tableBody = $(TABLE_BODY_LOCATOR);
        int tableSize = tableBody.findElements(By.xpath(".//tr[*]")).size();
        for (int i = 1; i <= tableSize; i++) {
            String hive = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[3]")).getText().replaceAll("\\s+", "");
            String hiveUsd = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[6]")).getText().replaceAll("\\s+", "");
            String type = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[8]")).getText().replaceAll("\\s+", "");
            if (!hive.equals("") && !hiveUsd.equals("") && type.equals(totalType)) {
                typeValue = typeValue + (Float.parseFloat(hive) * Float.parseFloat(hiveUsd));
            }
        }
        float formattedTypeValue = (float) (Math.round(Math.abs(typeValue) * 100.0) / 100.0);
        if (totalType.equals("W")) {
            return "Withdrawals: $" + formattedTypeValue;
        } else if (totalType.equals("D")) {
            return "Deposits: $" + formattedTypeValue;
        }
        return "Incorrect type value";
    }

    @Step
    public AdvancedPage clickClearButton() {
        $(CLEAR_FILED_ICON_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public String totalText() {
        return $(STRING_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public AdvancedPage fillTheFields() {
        enterDateOfStart();
        enterDateOfEnd();
        choseCurrency();
        return this;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {

    }
}
