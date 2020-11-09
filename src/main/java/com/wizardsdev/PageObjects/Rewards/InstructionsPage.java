package com.wizardsdev.PageObjects.Rewards;

import com.wizardsdev.PageObjects.Page;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.url;
import static com.wizardsdev.Context.properties;

public class InstructionsPage extends Page {
    private static final String PAGE_URL = "/rewards/referral-instructions/" + properties.getProperty("FacebookUserEmail00");
    private static final By TITLE_INSTRUCTIONS_LOCATOR = By.cssSelector(".ReferralInstructions__title");

    public InstructionsPage() {
        super(PAGE_URL);
    }

    @Step
    public static InstructionsPage openInstructionsPage() {
        if (!url().contains(PAGE_URL)) {
            open(PAGE_URL);
        }
        return new InstructionsPage();
    }

    @Step
    public String getTitleInstructionsRewards() {
        return $(TITLE_INSTRUCTIONS_LOCATOR).getText();
    }

    @Override
    protected void init() {
        // Page initialization
        // Checking correctness of page loading
        //String pageUrl = getCurrentPage();
        //$(REWARDS_TITLE_LOCATOR).shouldBe(Condition.visible);
        //assert url().equals(pageUrl) : "Invalid page is opened";
    }

    @Override
    protected void parsePage() {
        // Parsing Page Elements
        // Filling the necessary variables with data from the page
    }
}
