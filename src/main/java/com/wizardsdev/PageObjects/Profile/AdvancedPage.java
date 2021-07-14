package com.wizardsdev.PageObjects.Profile;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.regex.Pattern;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class AdvancedPage extends ProfilePage {
    public static final By FIELD_DATE_CALENDAR_LOCATOR = By.cssSelector(".ant-calendar-input");
    public static final By BUTTON_ACCOUNT_CREATION_LOCATOR = By.cssSelector(".WalletTable__datepickerFooter");
    public static final By BUTTON_TODAY_LOCATOR = By.cssSelector(".ant-calendar-today-btn ");
    public static final By INPUT_DATE_LOCATOR = By.cssSelector(".ant-calendar-picker-input");
    public static final By DROPDOWN_CURRENCY_LOCATOR = By.cssSelector(".ant-select-selection-selected-value");
    public static final By BUTTON_CURRENCY_LOCATOR = By.cssSelector(".ant-select-dropdown-menu-item");
    public static final By BUTTON_SUBMIT_LOCATOR = By.cssSelector(".ant-btn-primary");
    public static final By STRING_TOTAL_LOCATOR = By.cssSelector(".WalletTable__total");
    public static final By FIELD_FIND_USERS_LOCATOR = By.cssSelector(".ant-select-search__field");
    public static final By DROPDOWN_USER_LOCATOR = By.cssSelector(".SearchUser");
    public static final By TABLE_BODY_LOCATOR = By.cssSelector("#app > section > div > div.main-panel > div.shifted > div > div > div > table > tbody");
    public static final By BUTTON_CLEAR_USER_LOCATOR = By.cssSelector(".icon-delete");
    public static final By BUTTON_SHOW_MORE_LOCATOR = By.cssSelector(".DynamicTable__showMore");

    public final String TOTAL_INFO_DEFAULT = "TOTAL: Deposits: -. Withdrawals: -. (Totals can be calculated only for a defined from-till period.)";

    @Step
    public SelenideElement getShowMoreButton() {
        return $(BUTTON_SHOW_MORE_LOCATOR);
    }

    @Step
    public String getStringTotal() {
        return $(STRING_TOTAL_LOCATOR).getText();
    }

    @Step
    public AdvancedPage clearFirstUser() {
        $$(BUTTON_CLEAR_USER_LOCATOR).get(0).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public AdvancedPage enterDateOfStart(String startDate) {
        $$(INPUT_DATE_LOCATOR).get(0).shouldBe(Condition.visible).click();
        if (startDate.equals("Account Creation")) {
            $(BUTTON_ACCOUNT_CREATION_LOCATOR).shouldBe(Condition.visible).click();
        } else {
            $(FIELD_DATE_CALENDAR_LOCATOR).setValue(startDate);
        }
        return this;
    }

    @Step
    public AdvancedPage enterDateOfEnd(String endDate) {
        $$(INPUT_DATE_LOCATOR).get(1).shouldBe(Condition.visible).click();
        if (endDate.equals("Today")) {
            $(BUTTON_TODAY_LOCATOR).shouldBe(Condition.visible).click();
        } else {
            $(FIELD_DATE_CALENDAR_LOCATOR).setValue(endDate);
        }
        return this;
    }

    @Step
    public AdvancedPage choseCurrency(String currency) {
        $(DROPDOWN_CURRENCY_LOCATOR).click();
        $$(BUTTON_CURRENCY_LOCATOR).find(Condition.text(currency)).click();
        return this;
    }

    @Step
    public AdvancedPage clickButtonSubmit() {
        $(BUTTON_SUBMIT_LOCATOR).shouldBe(Condition.visible).click();
        return this;
    }

    @Step
    public boolean waitUntilReportToBeCounted() {
        WebDriverWait wait = new WebDriverWait(getWebDriver(), 200);
        wait.until(ExpectedConditions.textMatches(STRING_TOTAL_LOCATOR, Pattern.compile(".*\\(Completed\\)")));
        return true;
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
    public String counterTotal(String totalType) {
        float typeValue = 0;
        WebElement tableBody = $(TABLE_BODY_LOCATOR);
        int tableSize = tableBody.findElements(By.xpath(".//tr[*]")).size();
        for (int i = 1; i <= tableSize; i++) {
            String hive = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[3]")).getText().replaceAll("\\s+", "");
            String hiveCurrency = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[6]")).getText().replaceAll("\\s+", "");
            String hp = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[4]")).getText().replaceAll("\\s+", "");
            String hbd = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[5]")).getText().replaceAll("\\s+", "");
            String hbdCurrency = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[7]")).getText().replaceAll("\\s+", "");
            String type = $(By.xpath("//*[@id=\"app\"]/section/div/div[1]/div[2]/div/div/div/table/tbody/tr[" + i + "]/td[8]")).getText().replaceAll("\\s+", "");
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
        if (totalType.equals("W")) {
            return "Withdrawals: $" + formattedTypeValue;
        } else if (totalType.equals("D")) {
            return "Deposits: $" + formattedTypeValue;
        }
        return "Incorrect type value";
    }

    @Step
    public String totalText() {
        return $(STRING_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public AdvancedPage fillTheFields(String startDate, String endDate, String currency) {
        enterDateOfStart(startDate);
        enterDateOfEnd(endDate);
        choseCurrency(currency);
        return this;
    }

    @Override
    protected void init() {
    }

    @Override
    protected void parsePage() {

    }
}
