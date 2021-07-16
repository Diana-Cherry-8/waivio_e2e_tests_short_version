package com.wizardsdev.PageObjects.Tools;

import com.codeborne.selenide.Condition;
import com.wizardsdev.PageObjects.Page;
import com.wizardsdev.PageObjects.Profile.ProfilePage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.url;

public class SettingsPage extends Page {
    private static final String PAGE_URL = "/settings";
    private static final By BUTTON_SAVE_NOTIFICATION_SETTINGS = By.cssSelector(".Action--primary");
    private static final By DROP_DOWNS_LOCATORS = By.cssSelector(".ant-select-selection");
    private static final By MENU_ITEMS_LOCATOR = By.cssSelector(".ant-select-dropdown-menu-item");
    private static final By BUTTON_SAVE_LOCATOR = By.cssSelector(".Action");

    public SettingsPage() {
        super(PAGE_URL);
    }

    @Step
    public SettingsPage openSettingsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new SettingsPage();
    }

    @Step
    public void clickOnBaseCurrencyDropdown() {
        $$(DROP_DOWNS_LOCATORS).get(3).shouldBe(Condition.visible).click();
    }

    @Step
    public void selectCurrency(String currency) {
        $$(MENU_ITEMS_LOCATOR).find(Condition.matchesText(currency)).shouldBe(Condition.visible).click();
    }

    @Step
    public ProfilePage clickSave() {
        $(BUTTON_SAVE_LOCATOR).shouldBe(Condition.visible).click();
        return new ProfilePage() {
            @Override
            protected void init() {

            }

            @Override
            protected void parsePage() {

            }
        };
    }

    @Override
    protected void init() {
//        String pageUrl = getCurrentPage();
//        $(BUTTON_SAVE_NOTIFICATION_SETTINGS).shouldBe(Condition.visible);
//        assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
    }
}


