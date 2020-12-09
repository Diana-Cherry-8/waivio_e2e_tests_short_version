package com.wizardsdev.PageObjects.Rewards;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class ReceivablesPage extends Page {
    private static final String PAGE_URL = "/rewards/receivables";
    private static final By TITLE_TOTAL_LOCATOR = By.cssSelector(".Debts__information-row");
    private static final By BUTTON_PAYMENT_HISTORY_LOCATOR = By.cssSelector(".PaymentCard__end-wrap-icon");
    private static final By TITLES_SPONSOR_NAME_LOCATOR = By.cssSelector(".PaymentCard__content-name-wrap-row-name");
    private static final By TITLE_WITH_USER_AND_SPONSOR_NAMES_LOCATOR = By.cssSelector(".Payment__title-link");
    private static final By LINKS_REPORT_LOCATOR = By.cssSelector(".PaymentTable__report");
    private static final By TITLE_REPORT_LOCATOR = By.cssSelector(".ant-modal-title");

    public ReceivablesPage() {
        super(PAGE_URL);
    }

    @Step
    public static ReceivablesPage openReceivablesPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new ReceivablesPage();
    }

    @Step
    public String getTitleReceivables() {
        return $(TITLE_TOTAL_LOCATOR).shouldBe(Condition.visible).getText();
    }

    @Step
    public void clickButtonPaymentHistory() {
        $(BUTTON_PAYMENT_HISTORY_LOCATOR).shouldBe(Condition.visible).click();
    }

    @Step
    public String getSponsorNameInTheFirstCardInReceivables() {
        String fullNameOfSponsor = $$(TITLES_SPONSOR_NAME_LOCATOR).get(0).shouldBe(Condition.visible).getText();
        String deleteText = "@";
        String replace = "";
        String nameOfSponsor = fullNameOfSponsor.replaceAll(deleteText, replace);
        return nameOfSponsor;
    }

    @Step
    public String getSponsorNameInPaymentHistory() {
        return $$(TITLE_WITH_USER_AND_SPONSOR_NAMES_LOCATOR).get(1).shouldBe(Condition.visible).getText();
    }

    @Step
    public void clickOnTheFirstReportLink() {
        $$(LINKS_REPORT_LOCATOR).get(0).shouldBe(Condition.visible).click();
    }

    @Step
    public String getTitleReport() {
        return $(TITLE_REPORT_LOCATOR).shouldBe(Condition.visible).getText();
    }


        @Override
        protected void init () {
            // Page initialization
            // Checking correctness of page loading
//        String pageUrl = getCurrentPage();
//        $(TITLE_TOTAL_LOCATOR).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
        }

        @Override
        protected void parsePage () {
            // Parsing Page Elements
            // Filling the necessary variables with data from the page
        }
}

